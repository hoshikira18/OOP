import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addNode(9);
        tree.addNode(8);
        tree.addNode(7);
        tree.addNode(6);

        tree.deleteNode(6);
        tree.inorderArray(tree.root);
        for (int i : tree.inorderTreeElement) {
            System.out.println(i);
        }

    }

}