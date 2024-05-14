public class LinkedStack<T> {
    Node<T> head;
    Node<T> tall;
    int cap;
    int size=0;

    public LinkedStack(int cap) {
        this.cap = cap;
    }

    public void push(T data) {
        Node<T> newNode = new Node<T>(data);

        if(this.size==this.cap)
        {
            throw new StackOverflowError();
        }
        else if(head == null) {
            this.head = newNode;
            this.tall = newNode;
        }else {
            this.head.pre = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    public T pop () {
        if(this.head == null){
            throw new StackOverflowError();
        }
        else {
            T value = head.data;
            this.head = this.head.next;
            this.head.pre = null;
            return value;
        }
    }

    public void look() {
        Node<T> current = this.tall;
        while (current != null) {
            System.out.println(current.data);
            current = current.pre;
        }
    }

    public void traverse() {
        Node<T> current = this.head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
