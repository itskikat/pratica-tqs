package stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TQSstack<T> {

    private ArrayList<T> myStack;
    private Integer max_size;

    public TQSstack() {
        this.myStack = new ArrayList<>();
    }

    public TQSstack(int max_size) {
        this.myStack = new ArrayList<>();
        this.max_size = max_size;
    }

    public boolean isEmpty() {
        return this.myStack.size() == 0;
    }

    public int size() {
        return this.myStack.size();
    }

    public void push(T element){
        if(this.max_size != null && this.myStack.size() == this.max_size) {
            throw new IllegalStateException();
        }
        this.myStack.add(element);
    }

    public T pop() {
        if (this.myStack.size() == 0){
            throw new NoSuchElementException();
        } else {
            int last = this.myStack.size()-1;
            return this.myStack.remove(last);
        }
    }

    public T peek() {
        if (this.myStack.size() == 0) {
            throw new NoSuchElementException();
        } else {
            int last = this.myStack.size()-1;
            return this.myStack.get(last);
        }

    }

}
