package es.brouse.stack;

/**
 * Exception that will be thrown if the stack has any problem
 */
public class StackException extends RuntimeException {
    /**
     * Create
     *
     * @param message stack message
     */
    public StackException(String message) {
        super(message);
    }
}
