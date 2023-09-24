package es.brouse.stack;

/**
 * Stack implementation that used the static array storage. This stack
 * will have a max capacity and won't be able to increase it.
 *
 * @param <E>
 */
public class StaticStack<E> implements Stack<E> {
    private final E[] elements;
    private int index = 0;

    /**
     * Default class constructor used to create new {@link StaticStack}
     * instances.
     *
     * @apiNote This stack will have the default number elements {@link StaticStack<E>.MIN_ELEMENTS}.
     */
    public StaticStack() {
        this(Stack.DEFAULT_ELEMENTS);
    }

    public StaticStack(int size) {
        this.elements = (E[]) new Object[size];
    }

    @Override
    public boolean push(E element) {
        if (isFull()) throw new StackException("Stack is full");
        elements[index++] = element;
        return true;
    }
    @Override
    public boolean pop() {
        //If last element is not null, remove
        final E last = last();
        if (last == null)
            throw new StackException("No elements to pop");
        index--;
        return true;
    }

    @Override
    public E last() {
        if (index == 0) return null;
        return elements[index - 1];
    }

    @Override
    public int getSize() {
        return index;
    }

    @Override
    public boolean isFull() {
        return elements.length == index;
    }
}
