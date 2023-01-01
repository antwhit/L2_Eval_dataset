import com.ibm.JikesRVM.*;

/**
 * Exception for BootMap:  thrown for methods that are native, so no bytecode exists
 * @author Ton Ngo
 */
class BcNativeException extends Exception {

    public BcNativeException() {
        super("native method, no symbolic information");
    }
}
