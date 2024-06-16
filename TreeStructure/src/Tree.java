import java.util.ArrayList;

public class Tree {
    public Node root = null;
    ArrayList<Integer> inorderTreeElement = new ArrayList<>();
    ArrayList<Integer> preorderTreeElement = new ArrayList<>();
    ArrayList<Integer> postorderTreeElement = new ArrayList<>();
    ArrayList<Integer> levelorderTreeElement = new ArrayList<>();

    public Node addRecursively(Node current, int val) {
        if(current == null) {
            return new Node(val);
        }
        if(current.key < val) {
            current.right = addRecursively(current.right, val);
        } else if(current.key > val) {
            current.left = addRecursively(current.left, val);
        } else {
            System.out.println("Duplicate key!");
        }
        return current;
    }

    public void addNode(int val) {
        root = addRecursively(root, val);
    }

    public Node deleteRecursively(Node current, int val) {
        if(current == null) {
            System.out.println("The tree is empty!");
            return null;
        }
        if(current.key > val) {
            current.left = deleteRecursively(current.left, val);
        }
        else if(current.key < val) {
            current.right = deleteRecursively(current.right, val);
        }
        else {
            if(current.left == null) {
                return current.right;
            } else if(current.right == null) {
                return current.left;
            }

            current.key = minValue(current.right);
            if(current.right == null) {
                System.out.println("null");
            }

            current.right = deleteRecursively(current.right, current.key);

        }
        return current;
    }

    public int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public void deleteNode(int val) {
        this.root = deleteRecursively(root, val);
    }

    public void inorderArray(Node root) {
        if(root == null) {
            return;
        }

        inorderArray(root.left);
        inorderTreeElement.add(root.key);
        inorderArray(root.right);
    }

    public void preorderArray(Node root) {
        if(root == null) {
            return;
        }

        preorderTreeElement.add(root.key);
        preorderArray(root.left);
        preorderArray(root.right);
    }

    public void postorderArray(Node root) {
        if(root == null) {
            return;
        }

        postorderArray(root.left);
        postorderArray(root.right);
        postorderTreeElement.add(root.key);

    }

    public void levelorderArray(ArrayList<Node> list1) {
        if(list1 == null) {
            return;
        }

        ArrayList<Node> newList = new ArrayList<>();
        for(Node node : list1) {
            if(root.left != null) {
                levelorderTreeElement.add(root.left.key);
                newList.add(root.left);
            }
            if(root.right != null) {
                levelorderTreeElement.add(root.right.key);
                newList.add(root.right);
            }
        }

        levelorderArray(newList);
    }

}
