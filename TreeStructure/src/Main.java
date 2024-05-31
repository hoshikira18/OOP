//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addNode(2);
        tree.addNode(1);
        tree.addNode(3);

        System.out.println(tree.root.right.key);
    }
}