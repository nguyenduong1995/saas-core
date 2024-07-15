/**
 * FtpClient.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     thuy.nguyen
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.util;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JPopupMenu.Separator;

/**
 * FtpClient. <<< Detail note.
 * 
 * @author thuy.nguyen
 * @access public
 */
public class FtpClient {
    
    private String server;
    private Integer port;
    private String user;
    private String password;
    private FTPClient ftpClient;
    
    // constructor
    public FtpClient() {
    }

    /**
     * @param server
     * @param port
     * @param user
     * @param password
     * @param ftpClient
     */
    public FtpClient(String server, Integer port, String user, String password) {
        super();
        this.server = server;
        this.port = port;
        this.user = user;
        this.password = password;
    }
    
    public void open() throws IOException {
        ftpClient = new FTPClient();

        ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));

        ftpClient.connect(server, port);
        if(!ftpClient.login(user, password))
        {
            ftpClient.logout();
        }
        
        int reply = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftpClient.disconnect();
            throw new IOException("Exception in connecting to FTP Server");
        }
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.enterLocalPassiveMode();
    }

    public void close() throws IOException {
        ftpClient.logout();
        ftpClient.disconnect();
    }
    
    public List<String> listFiles(String path) throws IOException {
        FTPFile[] files = ftpClient.listFiles(path);
        return Arrays.stream(files)
          .map(FTPFile::getName)
          .collect(Collectors.toList());
    }
    public List<String> processStoringFiles(MultipartFile[] files, String fileStorageLocation, String subDir) throws IOException {
        List<String> filePaths = new ArrayList<String>();
        String remoteDirectory = fileStorageLocation + subDir;
        
        open();
        if (!checkDirectoryExists(remoteDirectory)) {
            if (!ftpClient.makeDirectory(remoteDirectory)) {
                throw new IOException("Can not create the subDir " + remoteDirectory);
            }
        } 
        if (files != null && files.length > 0) {
            
            for (MultipartFile file : files) {
                String targetFile = remoteDirectory + file.getOriginalFilename();
                if (!ftpClient.storeFile(targetFile, file.getInputStream())) {
                    throw new IOException("Can not store the file " + targetFile);
                }
                filePaths.add(targetFile);
            }
        }
        close();
        
        return filePaths;
    }
    
    public String putFileToPath(MultipartFile file, String fileStorageLocation, String subDir, String fileName) throws IOException {
        String remoteDirectory = fileStorageLocation + subDir;
        String targetFile = remoteDirectory + fileName;
        
        open();
        if (!checkDirectoryExists(remoteDirectory)) {
            if (!ftpClient.makeDirectory(remoteDirectory)) {
                throw new IOException("Can not create the subDir " + remoteDirectory);
            }
        } 
        if (!ftpClient.storeFile(targetFile, file.getInputStream())) {
            throw new IOException("Can not store the file " + fileName);
        }
        close();
        
        return targetFile;
    }
    
    boolean checkDirectoryExists(String dirPath) throws IOException {
        ftpClient.changeWorkingDirectory(dirPath);
        int returnCode = ftpClient.getReplyCode();
        if (returnCode == 550) {
            return false;
        }
        System.err.println("Current directory is " + ftpClient.printWorkingDirectory());
        return true;
    }
    
    /**
     * @param fileName
     * @param filePath
     * @return
     * @throws IOException 
     */
    public String deleteFile(String fileStorageLocation, String filePath) throws IOException {
        String result = "File '"+ filePath + "'";
        open();
        ftpClient.changeWorkingDirectory(fileStorageLocation);
        // Delete file
        boolean exist = ftpClient.deleteFile(filePath);
         
        // Notify user for deletion 
        if (exist) {
            result = result + " deleted...";
        } else { // Notify user that file doesn't exist
            result = result + " doesn't exist...";
        }
        close();
        return result;
    }


    /**
     * @param fileNameMap
     * @param fileStorageLocation
     * @param subFolder
     * @return
     * @throws IOException 
     */
    public List<String> processStoringFiles(Map<String, MultipartFile> fileNameMap, String fileStorageLocation, String subFolder) throws IOException {
        List<String> filePaths = new ArrayList<String>();
        String remoteDirectory = fileStorageLocation + subFolder;
        
        open();
        if (!checkDirectoryExists(remoteDirectory)) {
            System.err.println("REMOTE DIR NOT EXIST: " + remoteDirectory);
            if (!ftpClient.makeDirectory(remoteDirectory)) {
                throw new IOException("Can not create the subDir " + remoteDirectory);
            }
        } 
        if (MapUtils.isNotEmpty(fileNameMap)) {
            for (Map.Entry<String, MultipartFile> fileInfo : fileNameMap.entrySet()) {
                String separator = "";
                if (!remoteDirectory.endsWith("/") && !fileInfo.getKey().startsWith("/")) {
                    separator = "/";
                }
                
                int index = fileInfo.getKey().lastIndexOf("/");
                if (index >= 0) {
                    String folderName = remoteDirectory + separator + fileInfo.getKey().substring(0, index);
                    if (!checkDirectoryExists(folderName)) {
                        if (!ftpClient.makeDirectory(folderName)) {
                            throw new IOException("Can not create the subDir " + folderName);
                        }
                    } 
                }
                
                String targetFile = remoteDirectory  + separator + fileInfo.getKey();
                
                if (!ftpClient.storeFile(targetFile, fileInfo.getValue().getInputStream())) {
                    throw new IOException("Can not store the file " + targetFile);
                }
                filePaths.add(targetFile);
            }
        }
        close();
        
        return filePaths;
    }
    
    /**
     * @param fileStorageLocation
     * @param is
     * @param filePath
     * @return
     * @throws IOException 
     */
    public String processStoringFile(InputStream imageInputStream, String fileStorageLocation, String subFolder, String fileName) throws IOException {
        String targetFile = null;
        String remoteDirectory = fileStorageLocation + subFolder;
        open();
        if (!checkDirectoryExists(remoteDirectory)) {
            if (!ftpClient.makeDirectory(remoteDirectory)) {
                throw new IOException("Can not create the subDir " + remoteDirectory);
            }
        } 
        if (imageInputStream != null) {    
            targetFile = remoteDirectory + fileName;
            if (!ftpClient.storeFile(targetFile, imageInputStream)) {
                throw new IOException("Can not store the file " + targetFile);
            }
        }
        imageInputStream.close();
        close();
        
        return targetFile;
    }

    /**
     * @param folderStorageLocation
     * @return
     * @throws IOException 
     */
    public void processStoringFolder(String folderStorageLocation) throws IOException {
        String remoteDirectory = folderStorageLocation;
        open();
        if (!checkDirectoryExists(remoteDirectory)) {
            if (!ftpClient.makeDirectory(remoteDirectory)) {
                throw new IOException("Can not create the subDir " + remoteDirectory);
            }
        }
        close();
    }
    
    /**
     * get value of <b>server</b>.
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * Set value to <b>server</b>.
     * @param server the server to set
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * get value of <b>port</b>.
     * @return the port
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Set value to <b>port</b>.
     * @param port the port to set
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * get value of <b>user</b>.
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * Set value to <b>user</b>.
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * get value of <b>password</b>.
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set value to <b>password</b>.
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get value of <b>ftp</b>.
     * @return the ftp
     */
    public FTPClient getFtp() {
        return ftpClient;
    }

    /**
     * Set value to <b>ftp</b>.
     * @param ftp the ftp to set
     */
    public void setFtp(FTPClient ftp) {
        this.ftpClient = ftp;
    }

}
