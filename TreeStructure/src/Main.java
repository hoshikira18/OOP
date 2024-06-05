import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addNode(9);
        tree.addNode(5);
        tree.addNode(20);
        tree.addNode(3);
        tree.addNode(7);
        tree.addNode(13);
        tree.addNode(21);
        tree.addNode(1);
        tree.addNode(4);
        tree.addNode(6);
        tree.addNode(8);
        tree.addNode(11);
        tree.addNode(15);
        tree.addNode(0);
        tree.addNode(2);
        tree.addNode(10);
        tree.addNode(12);
        tree.addNode(14);
        tree.addNode(17);
        tree.addNode(19);


        tree.levelorderTreeElement.add(tree.root.key);

        ArrayList<Node> list= new ArrayList<>();
        list.add(tree.root);
        tree.levelorderArray(list);

        for (Integer integer : tree.levelorderTreeElement) {
            System.out.print(integer + " ");
        }

    }

}