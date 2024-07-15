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
public class AccountNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7163187913427048079L;

    public AccountNotFoundException() {
        super();
    }

    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(Throwable cause) {
        super(cause);
    }

}
