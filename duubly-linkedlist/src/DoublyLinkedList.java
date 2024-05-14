public class DoublyLinkedList {
    private int size;
    Node head;
    Node tall;

    public DoublyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tall = null;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst (int data) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            this.head = this.tall = newNode;
        }
        else {
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void removeFist () {
        if(isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        if(this.size == 1) {
            this.head = null;
            this.tall = null;
            return;
        }
        this.head = this.head.next;
        this.head.previous = null;

        this.size--;

    }

    public void addLast (int data) {
        Node newNode = new Node(data);
        if(this.isEmpty()) {
            this.head = this.tall = newNode;
        }
        else {
            newNode.previous = this.tall;
            this.tall.next = newNode;
            this.tall = newNode;
        }
        this.size++;
    }

    public void removeLast () {
        if(isEmpty()) {
            System.out.println("List is empty");
        }

        if(this.size == 1) {
            this.head = null;
            this.tall = null;
            return;
        }

        this.tall = this.tall.previous;
        this.tall.next = null;

    }

    public void add(int data, int index){
        Node newNode = new Node(data);
        Node current = this.head;

        if(index == 0 ) {
            this.addFirst(data);
            return;
        }
        if(index > size) {
            System.out.println("Invalid index!");
        }

        if(index == size) {
            this.addLast(data);
            return;
        }

        int count = 0;
        while(current != null) {
             if(count == index) {
                 newNode.previous = current;
                 newNode.next = current.next;
                 current.next.previous = newNode;
                 current.next = newNode;
                 this.size++;
                 break;
             }
             count++;
            current = current.next;
        }

    }

    public int getByIndex(int index) throws Exception {
        if(isEmpty()) {
            throw new Exception("Index out of range");
        }

        if(index >= size) {
            System.out.println("Invalid index!");
            throw new Exception("Index out of range");
        }
        else {
            int count = 0;
            Node current = this.head;
            while (current != null) {
                if(count == index) {
                    return current.data;
                }
                count++;
                current = current.next;
            }
        }

        throw new Exception("Index out of range");
    }

    public void swap(int index1, int index2) {
        if(isEmpty() || index1 >= this.size || index2 >= this.size) {
            System.out.println("Invalid index!");
        }
        if(index1 == index2) {
            return;
        }

        int curPos1 = 0;
        int curPos2 = 0;
        Node currentNode1 = this.head;
        Node currentNode2 = this.head;

        while(curPos1 != index1) {
            currentNode1 = currentNode1.next;
            curPos1++;
        }
        while(curPos2 != index2) {
            currentNode2 = currentNode2.next;
            curPos2++;
        }

        int temp = currentNode1.data;
        currentNode1.data = currentNode2.data;
        currentNode2.data = temp;
    }

    public void traverse () {
        for(Node current = this.head; current != null; current = current.next) {
                System.out.println("current data: " + current.data);
        }
    }
}
