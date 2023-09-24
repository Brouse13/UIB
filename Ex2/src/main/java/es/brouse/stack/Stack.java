package es.brouse.stack;

/**
 * Generic definition of operation that a stack must
 * provide.
 *
 * @param <E> type of the stack
 */
public interface Stack<E> {
    /**
     * Default elements that a stack will have if the size is not set.
     */
    int DEFAULT_ELEMENTS = 10;

    /**
     * Push a new element into the stack. If the stack is
     * full, it will throw a {@link StackException}.
     *
     * @param element element to add
     * @return the operation status
     * @apiNote
     */
    boolean push(E element);

    /**
     * Remove from the stack the last element. If the stack is
     * empty, it will throw a {@link StackException}.
     *
     * @return the operation status
     */
    boolean pop();

    /**
     * Get the last element from the stack. If the stack is empty
     * it will return null.
     *
     * @return the last element
     */
    E last();

    /**
     * Return the size of the stack.
     *
     * @return the stack size
     */
    int getSize();

    /**
     * Return if the stack is completely full.
     *
     * @return if the stack is full
     */
    boolean isFull();
}
