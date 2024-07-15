/**
 * FileStorageService.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     thuy.nguyen
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.components;

import co.ipicorp.saas.core.web.exception.FileStorageException;
import co.ipicorp.saas.core.web.util.FtpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * FileStorageService.
 * <<< Detail note.
 * @author thuy.nguyen
 * @access public
 */
@Service
public class FileStorageServiceImpl implements FileStorageService {
    private final String fileStorageLocation;
    
    private FtpClient ftpClient;

    @Autowired
    public FileStorageServiceImpl(FileStorageConfigurer fileStorageProperties) {
        initFtpClient(fileStorageProperties);
        this.fileStorageLocation = fileStorageProperties.getUploadDir();
    }

    /**
     * @param ftpClient2
     * @param fileStorageProperties
     */
    private void initFtpClient(FileStorageConfigurer fileStorageProperties) {
        String server = fileStorageProperties.getServer();
        Integer port = fileStorageProperties.getPort();
        String user = fileStorageProperties.getUser();
        String password = fileStorageProperties.getPassword();
        this.ftpClient = new FtpClient(server, port, user, password);
    }
    
    @Override
    public List<String> storeMultipleFiles(MultipartFile[] files) {
        try {
            // Copy file to the target location (Replacing existing file with the same name)
            return getFtpClient().processStoringFiles(files, this.fileStorageLocation, getSubStringWithCurrentMonth());
        } catch (IOException ex) {
            throw new FileStorageException("Could not store files. Please try again!", ex);
        } catch (Exception e) {
            throw new FileStorageException(e.getMessage());
        }
    }

    @Override
    public String storeFile(MultipartFile file, String fileName) {
        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            return getFtpClient().putFileToPath(file, this.fileStorageLocation, getSubStringWithCurrentMonth(), fileName);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + originalFileName + ". Please try again!", ex);
        }
    }
    
    @Override
    public String deleteFile(String filePath) {
        try {
        	System.err.println("FILE PATH: " + this.fileStorageLocation);
           return getFtpClient().deleteFile(this.fileStorageLocation, filePath);
        } catch (IOException ex) {
            throw new FileStorageException("Could not delete file " + filePath + ". Please try again!", ex);
        }
    }

    @Override
    public List<String> storeMultipleFiles(Map<String, MultipartFile> fileNameMap) {
        return this.storeMultipleFiles(fileNameMap, this.fileStorageLocation);
    }
    
    protected String getSubStringWithCurrentMonth() {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYYMM");
        return formatter.format(new Date()) + "/";
    }

    /**
     * get value of <b>ftpClient</b>.
     * @return the ftpClient
     */
    public FtpClient getFtpClient() {
        return ftpClient;
    }

    @Override
    public List<String> storeMultipleFiles(Map<String, MultipartFile> fileNameMap, String storageLocation) {
        try {
            return getFtpClient().processStoringFiles(fileNameMap, storageLocation, "");
        } catch (IOException ex) {
            throw new FileStorageException("Could not store files. Please try again!", ex);
        } catch (Exception e) {
            throw new FileStorageException(e.getMessage());
        }
    }

    @Override
    public String storFile(String base64String, String storageLocation, String fileName) {
        try {
            String[] data = base64String.split(",");
            String extension = data[0].split(";")[0].split("/")[1];
            if (StringUtils.isEmpty(extension) || !isImageType(extension)) {
                throw new FileStorageException("Could not upload file that is not image file. Please try again!");
            }
            
            System.err.println("Extension: " + extension);
            byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(data[1]);
            System.err.println("Image Size: " + imageBytes.length);
            InputStream is = new ByteArrayInputStream(imageBytes);
            return getFtpClient().processStoringFile(is, storageLocation, "", fileName + "." + extension);
         } catch (Exception ex) {
             throw new FileStorageException("Could not store files. Please try again!", ex);
         }
    }

    /**
     * @param string
     * @return
     */
    private boolean isImageType(String prefixOfBase64String) {
        boolean result = true;
        String type = prefixOfBase64String.split(";")[0];
        if (!type.toUpperCase().endsWith("PNG") && !type.toUpperCase().endsWith("JPG") && !type.toUpperCase().endsWith("JPEG")){
            result = false;
        }
        return result;
    }

	@Override
	public void storFolder(List<String> storageLocations) {
		try {
			for (String location : storageLocations) {
				getFtpClient().processStoringFolder(location);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
}
