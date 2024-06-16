/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author VIET
 * @param <T>
 */
public class Tree<T> {

    Node root;
    int size;

    public Tree() {
        Node root = null;
        this.size = 0;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private boolean isEmpty() {// sub function
        return this.size == 0;
    }

    public void add(Node root, T data) {

        if (root == null) {
            root = new Node(data, 0);
            System.out.println("Add successfully");
            this.size++;
            return;
        }
        if (data.toString().compareTo(root.data.toString()) > 0) {
            root.right.parent = root;
            root = root.right;
            add(root, data);

        } else if (data.toString().compareTo(root.data.toString()) < 0) {
            root.left.parent = root;
            root = root.left;
            add(root, data);

        } else {
            System.out.println("Data existed.");
            return;
        }
        setNodeHeight(this.root);

    }

    private Node findMax(Node root) {// sub function
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public Node remove(Node root, T data) {

        if (root == null) {
            return root;
        } else {
            if (data.toString().compareTo(root.data.toString()) > 0) {
                root = root.right;
                remove(root, data);

            } else if (data.toString().compareTo(root.data.toString()) < 0) {
                root = root.left;
                remove(root, data);

            } else if (data.toString().compareTo(root.data.toString()) == 0) {
                //tien hanh xoa
                if (root.left != null && root.right == null) {
                    root.left.parent = root.parent;
                    root = root.left;
                    this.size--;
                } else if (root.left == null && root.right != null) {
                    root.right.parent = root.parent;
                    root = root.right;
                    this.size--;
                } else if (root.left == null && root.right == null) {
                    root = null;
                    this.size--;
                } else {//xoa node co ca left va right khac null
                    Node max = findMax(root.left);
                    root.data = max.data;
                    remove(root.left, (T) max.data);
                }

            } else {
                System.out.println("Data not found.");
                return root;
            }

        }

        return root;
    }

    private Node rotateLeft(Node root) {// sub function
        Node temp = root;
        root = root.right;
        root.parent = temp.parent;

        temp.right = root.left;
        temp.right.parent = temp;

        root.left = temp;
        temp.parent = root;

        return root;
    }

    private Node rotateRight(Node root) {// sub function
        Node temp = root;
        root = root.left;
        root.parent = temp.parent;

        temp.left = root.right;
        temp.left.parent = temp;

        root.right = temp;
        temp.parent = root;

        return root;
    }

    private Node rotateRightLeft(Node root) {// sub function
        root.right = rotateRight(root.right);
        root = rotateLeft(root);
        return root;
    }

    private Node rotateLeftRight(Node root) {// sub function
        root.left = rotateLeft(root.left);
        root = rotateRight(root);
        return root;
    }

    private int max(int a, int b) {// sub function
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    private int getHeight(Node root) {// sub function
        if (root == null) {
            return -1;
        } else {
            return max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }

    private void setNodeHeight(Node root) {
        if (root == null) {
            return;
        }
        root.height = getHeight(root);

        setNodeHeight(root.left);
        setNodeHeight(root.right);
    }

    private int getDepth(Node node) {
        int depth = 0;
        if (node == null) {
            return -1;
        }
        Node current = node;
        while (current != this.root) {
            depth++;
            current = current.parent;
        }
        return depth;
    }

    // from here is working balance
    private boolean notBalance(Node root) {//check da can bang hay chua // sub function
        return Math.abs(root.left.height - root.right.height) >= 2;
    }

    private void nodeBalance(Node root) {//just work with a node // sub function
        if (notBalance(root)) {
            if (getHeight(root.left) > getHeight(root.right)) {
                if (getHeight(root.left.left) > getHeight(root.left.right)) {
                    rotateRight(root);
                } else {
                    rotateLeftRight(root);
                }
            } else {
                if (getHeight(root.right.right) > getHeight(root.right.left)) {
                    rotateLeft(root);
                } else {
                    rotateRightLeft(root);
                }
            }
        }
    }

    private HashMap<Node, Integer> allNodeLV2 = new HashMap<>();

    private void addHashMapLV2(Node root) {// sub function
        if (root.height < 2) {
        } else if (root.height == 2) {
            this.allNodeLV2.put(root, getDepth(root));
        } else {
            addHashMapLV2(root.left);
            addHashMapLV2(root.right);
        }
    }

    public void treeBalance(Node root) {// main function
        addHashMapLV2(this.root);
        balance(allNodeLV2);
    }

    private void balance(HashMap<Node, Integer> map) {// sub function
        if (map.size() == 1 || map.containsKey(this.root)) {
            return;
        }
        HashMap<Node, Integer> newMap = new HashMap<>();

        // find node max depth in list node
        int maxDepth = 0;
        for (Map.Entry<Node, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxDepth) {
                maxDepth = entry.getValue();
            }
        }
        // do balance
        for (Map.Entry<Node, Integer> entry : map.entrySet()) {

            if (entry.getValue() == maxDepth) {
                nodeBalance(entry.getKey());
                Node newNode = entry.getKey().parent;
                newMap.put(newNode, getDepth(newNode));
            } else {
                newMap.put(entry.getKey(), entry.getValue());
            }

        }
        // call recursive
        balance(newMap);
    }

    public Node<T> getNode(Node root, String nodeID) {
        Node current = root;
        if (root == null) {
            return null;
        }
        if (current.data.toString().contains(nodeID)) {
            return current;
        } else {
            current = getNode(root.left, nodeID);
            if (current == null) {
                current = getNode(root.right, nodeID);
            }
        }
        return current;
    }

}
