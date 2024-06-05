import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack <T> {
    ArrayList<T> stack;
    int top;
    int size;
    int cap;

    public Stack(int cap) {
        stack = new ArrayList<T>(cap);
        this.top = 0;
        this.size = 0;
        this.cap = cap;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull () {
        return size == cap;
    }

    public void push(T t) {
        if(isFull()) {
            System.out.println("Stack is full");
            return;
        }
        if(isEmpty()) {
            stack.add(t);
            this.size++;
            return;
        }
        this.top++;
        this.stack.add(this.top, t);
        this.size++;
    }

    public T pop() {
        if(this.isEmpty()) {
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }

        T t = this.stack.remove(this.top);
        this.size--;
        this.top--;
        return t;
    }

    public T peek() {
        if(this.isEmpty()) {
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        return this.stack.get(this.top);
    }

    public void traverse () {
        for (T t : stack) {
            System.out.println(t);
        }
    }
}
