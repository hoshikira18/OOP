//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>(5);
        stack.push("1a");
        stack.push("2b");
        stack.push("3c");
        stack.look();
    }
}