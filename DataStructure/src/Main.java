//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(3);
        list.addLast(2);
        list.addLast(0);
        list.addLast(1);
        list.addLast(10);

        list.bubbleSort();
        list.traverse();
    }
}