/**
 * UserNotFoundException.java
 * @author     hieumicro
 * @version    1.0.0
 */

package co.ipicorp.saas.core.service.exception;

/**
 * UserNotFoundException.
 * This exception will be thrown in case user not found.
 * 
 * @author hieumicro
 * @access public
 */
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7163187913427048079L;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

}
