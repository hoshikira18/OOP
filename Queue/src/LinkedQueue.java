public class LinkedQueue <T> {
    Node <T> rear;
    Node <T> front;
    int size;
    int cap;

    public LinkedQueue(int cap) {
        this.size = 0;
        this.cap = cap;
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.cap;
    }

    public void enqueue(T value) {
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }
        Node<T> newNode = new Node<T>(value);

        if(isEmpty()) {
            this.rear = newNode;
            this.front = newNode;
            this.size++;
            return;
        }

        newNode.next = this.rear;
        this.rear.pre = newNode;
        this.rear = newNode;
        this.size++;
    }

    public T dequeue () {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            throw new RuntimeException("Queue is empty");
        }
        if(this.size == 1) {
            T value = this.rear.data;
            this.rear = null;
            this.front = null;
            this.size--;
            return value;
        }

        T value = this.front.data;
        this.front = this.front.pre;
        this.front.next = null;
        this.size--;

        return value;
    }

    public T peek () {
        if(isEmpty()) {
            System.out.println("Queue is empty");
        }
        return this.front.data;
    }

    public void traverse () {
        if(this.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node <T> current = this.rear;
        System.out.print("REAR(IN) [ -> ");
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("] FRONT(OUT)");
    }
}
