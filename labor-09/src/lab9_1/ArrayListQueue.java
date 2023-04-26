package lab9_1;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListQueue implements IQueue {
    private ArrayList<Object> items;
    private final int capacity;

    public ArrayListQueue(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return (items.size() == 0);
    }

    @Override
    public boolean isFull() {
        return (items.size() == capacity);
    }

    @Override
    public void enQueue(Object object) {
        if(isFull()){
            return;
        }
        items.add(object);
    }

    @Override
    public Object deQueue() {
        if(isEmpty()){
            return null;
        }
        return items.remove(items.size() -1);
    }

    @Override
    public void printQueue() {
        for (Object item : items) {
            System.out.println(item);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListQueue that = (ArrayListQueue) o;
        return  Objects.equals(items, that.items);
    }

}
