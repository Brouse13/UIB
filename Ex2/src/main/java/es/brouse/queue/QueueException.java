package es.brouse.queue;

public class QueueException extends RuntimeException {
    public QueueException() {
        super();
    }

    public QueueException(String message) {
        super(message);
    }
}
