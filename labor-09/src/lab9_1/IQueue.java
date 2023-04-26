package lab9_1;

public interface IQueue {
    boolean isEmpty();
    boolean isFull();
    void enQueue(Object object);
    Object deQueue();
    void printQueue();
}
