package es.brouse.stack;

/**
 * Stack implementation that uses dynamic arrays to allocate elements in
 * memory.
 *
 * @apiNote This stack won't have a limit of elements
 * @param <E> element type of the stack
 */
public class DynamicStack<E> implements Stack<E> {
    private final int NODE_SIZE;
    private Node<E> topNode;
    private int size = 0;

    /**
     * Main class constructor used to create a new {@link DynamicStack}
     * instance. This constructor will allocate memory in segments of
     * {@link Stack<E>.DEFAULT_ELEMENTS}.
     */
    public DynamicStack() {
        NODE_SIZE = Stack.DEFAULT_ELEMENTS;
        topNode = new Node<>(NODE_SIZE, null, null);
    }

    /**
     * Main class constructor used to create a new {@link DynamicStack}
     * instance. This constructor will allocate memory in segments of
     * {@param nodeSize}.
     */
    public DynamicStack(int nodeSize) {
        NODE_SIZE = nodeSize;
        topNode = new Node<>(NODE_SIZE, null, null);
    }

    @Override
    public boolean push(E element) {
        //If the last node is not full, add the element
        if (!topNode.isFull()) {
            size++;
            return topNode.push(element);
        }

        //Update the top node
        Node<E> prevNode = topNode;
        topNode = new Node<>(NODE_SIZE, prevNode, null);
        prevNode.update(prevNode.getPrevious(), topNode);

        //Push the element in the created node
        return push(element);
    }

    @Override
    public boolean pop() {
        //If the stack is not empty, pop the element
        if (topNode.getSize() != 0) {
            size--;
            return topNode.pop();
        }

        //The stack is empty
        if (topNode.getPrevious() == null)
            throw new StackException("Stack is empty");

        //Update the top node
        topNode = topNode.getPrevious();
        topNode.update(topNode.getPrevious(), null);

        //Pop the last element
        return pop();
    }

    @Override
    public E last() {
        return topNode.last();
    }

    /**
     * Return always true cause to dynamic stacks doesn't have max
     * size.
     *
     * @return true
     */
    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * Class that represents a segment of data from the {@link DynamicStack}
     * This class will handle next and previous nodes from the stack.
     *
     * @param <E> type of the element
     */
    private static class Node<E> extends StaticStack<E> {
        private Node<E> previous;
        private Node<E> following;

        /**
         * Main class constructor used to create new {@link Node<E>}
         * instances. If the node hasn't got next of following, set
         * it to null.
         *
         * @param nodeSize size of the node
         * @param previous previos node
         * @param following following node
         */
        public Node(int nodeSize, Node<E> previous, Node<E> following) {
            //Use the given node size
            super(nodeSize);

            this.previous = previous;
            this.following = following;
        }

        /**
         * Get the previous node or null if it doesn't exist.
         *
         * @return the previous node
         */
        public Node<E> getPrevious() {
            return previous;
        }

        /**
         * Update the previous and following nodes references.
         *
         * @param previous previous node
         * @param following following node
         */
        public void update(Node<E> previous, Node<E> following) {
            this.previous = previous;
            this.following = following;
        }
    }
}
