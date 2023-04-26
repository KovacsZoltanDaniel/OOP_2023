package lab8_2;

import java.util.ArrayList;

public class StackAggregation {
    private ArrayList<Object> items ;
    private final  int capacity;

    public StackAggregation(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }
    public boolean isFull(){
       return (items.size() == capacity);
    }
    public boolean isEmpty(){
        return (items.size() == 0);
    }
    public void push(Object object){
        if(isFull()){
            return;
        }
        items.add(object);
    }
    public void pop(){
        if(items.isEmpty()){
            return;
        }
        items.remove(items.size() - 1);
    }
    public Object top(){
        if(isEmpty()){
            return null;
        }
        return items.get(items.size() -1);
    }
    public int getSize(){
        return items.size();
    }
}
