public class LinkedList {
    Node head;
    Node tall;

    public int size;

    public LinkedList() {
        this.head = null;
        this.tall = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (this.size == 0) {
            this.head = newNode;
            this.tall = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    public void addAfter(int data, int index) {

        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }

        Node newNode = new Node(data);
        int count = 0;
        Node current = this.head;
        while (current != null) {
            if (count == index) {
                newNode.next = current.next;
                current.next = newNode;
                this.size++;
            }
            current = current.next;
            count++;
        }
    }

    public Node removeFirst() {
        if (this.size == 0) {
            System.out.println("Can't remove first");
            return null;
        }

        Node temp = this.head;
        this.head = this.head.next;
        this.size--;
        return temp;
    }

    public Node removeLast() {
        if(this.size == 0) {
            System.out.println("Can't remove last");
        }

        if(this.size == 1) {
            this.head = null;
            this.tall = null;
            this.size = 0;
            return null;
        }

        Node current = this.head;
        while (current.next.next != null) {
                this.tall = current;
                this.size--;
            current = current.next;
        }

        return tall;
    }



    public void traverse() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
