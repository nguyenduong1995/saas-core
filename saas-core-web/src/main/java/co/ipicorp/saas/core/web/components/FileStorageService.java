/**
 * FileStorageService.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     thuy.nguyen
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.components;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * FileStorageService.
 * <<< Detail note.
 * @author thuy.nguyen
 * @access public
 */
public interface FileStorageService {
    /**
     * 
     * @param file
     * @param fileName
     * @param subDir
     * @return
     */
    public String storeFile(MultipartFile file, String fileName);
    
    /**
     * 
     * @param filePath
     * @return
     */
    public String deleteFile(String filePath);
    
    /**
     * @param files
     * @param subDir
     * @return
     */
    public List<String> storeMultipleFiles(MultipartFile[] files);

    /**
     * @param fileNameMap map of File name and MultipartFile
     * @param storageLocation MultipartFile
     * @return
     */
    public List<String> storeMultipleFiles(Map<String, MultipartFile> fileNameMap, String string);
    
    /**
     * @param fileNameCombineByIdsMap
     * @param subFolder
     * @return
     */
    public List<String> storeMultipleFiles(Map<String, MultipartFile> fileNameMap);
    
    /**
     * @param base64String
     * @param fileName
     * @return
     */
    public String storFile(String base64String, String storageLocation, String fileName);
    
    /**
     * @param fileName
     * @return
     */
    public void storFolder(List<String> storageLocations);
}
