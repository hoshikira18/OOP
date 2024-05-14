//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(1);
        dll.addLast(3);
        dll.add(5, 2);
        dll.swap(0, 1);
        try {
            System.out.println(dll.getByIndex(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        dll.traverse();
    }
}