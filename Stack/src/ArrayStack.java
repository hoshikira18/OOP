public class ArrayStack {
    int[] array;
    int top;
    int size;
    int cap;

    public ArrayStack( int cap) {
        this.array = new int[cap];
        this.cap = cap;
    }

    public void look () {
        for ( int i = this.size; i > 0; i-- ) {
            System.out.println(array[i]);
        }
    }

    public void push(int value) {
        if(this.size == this.cap) {
            System.out.println("Stack is full");
        }
        else {
            this.array[this.top] = value;
            this.top++;
            this.size++;
        }
    }

    public int pop() {
        if(this.top == -1) {
            throw new RuntimeException("Stack is empty");
        }
        else {
            int value = this.array[this.top];
            this.top--;
            return value;
        }
    }

    public int top () {
        if(this.top == -1) {
            throw new RuntimeException("Stack is empty");
        }
        return this.array[this.top];
    }

    public void clear() {
        this.top = -1;
        for(int i = 0; i < cap; i++) {
            this.array[i] = Integer.MIN_VALUE;
        }
        this.size = 0;
    }
}
