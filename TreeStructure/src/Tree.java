public class Tree {
    public Node root;

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

}
