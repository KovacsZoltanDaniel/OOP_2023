package lab9_1;

import java.util.Arrays;
import java.util.Objects;

public class CircularQueue implements IQueue {
    private final int capacity;
    private Object[] items;
    private int front;
    private int rear;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        front = -1;
        rear = -1;
        items = new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return (front == -1);
    }

    @Override
    public boolean isFull() {
        return (front == 0 && rear == capacity - 1 || front == rear + 1);
    }

    @Override
    public void enQueue(Object object) {
        if (isFull()) {
            System.out.println("Queue is full!");
        }
        else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % capacity;
            items[rear] = object;
            System.out.println("Inserted " + object);
        }
    }

    @Override
    public Object deQueue() {
        if(isEmpty()){
            System.out.println("Queue is empty!");
            return null;
        }
        else {
            Object element;
            element = items[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            return element;
        }
    }

    @Override
    public void printQueue() {
        int i;
        if(isEmpty()){
            System.out.println("The queue is empty!");
        }
        else {
            System.out.println("Front -> " + front);
            System.out.println("Items -> ");
            for (i = front; i != rear; i = (i + 1) % capacity)
                System.out.print(items[i] + " ");
            System.out.println(items[i]);
            System.out.println("Rear -> " + rear);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircularQueue that = (CircularQueue) o;
        if (this.items.length == (that).items.length) {
            int i, j;
            for (i = this.front, j = (that).front; i != this.rear && j != (that).rear; i = (i + 1) % capacity, j = (j + 1) % (that).items.length) {
                if (this.items[i] != (that).items[j]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
