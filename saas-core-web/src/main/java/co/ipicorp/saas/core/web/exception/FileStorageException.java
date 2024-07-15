/**
 * FileStorageException.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     thuy.nguyen
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.exception;

/**
 * FileStorageException.
 * <<< Detail note.
 * @author thuy.nguyen
 * @access public
 */
public class FileStorageException extends RuntimeException {
    
    private static final long serialVersionUID = 1723892026721587718L;

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}