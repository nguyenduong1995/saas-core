/**
 * FileNotFoundException.java
 * @copyright  Copyright © 2020 Hieu Micro
 * @author     thuy.nguyen
 * @version    1.0.0
 */
package co.ipicorp.saas.core.web.exception;

/**
 * FileNotFoundException. <<< Detail note.
 * 
 * @author thuy.nguyen
 * @access public
 */
public class FileNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1723892026721587718L;

    public FileNotFoundException(String message) {
        super(message);
    }

    public FileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}