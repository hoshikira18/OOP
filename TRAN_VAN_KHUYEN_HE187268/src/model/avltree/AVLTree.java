package model.avltree;

import model.entities.Employee;
import model.entities.IceCream;

import java.util.List;

public class AVLTree<T extends Comparable<T>>  {
    public AVLNode<T> root;

    public void insert(T data) {
        root = insert(root, data, null);
    }

    private AVLNode<T> insert(AVLNode<T> root, T data, AVLNode<T> parent) {
        if (root == null) {
            AVLNode<T> newNode = new AVLNode<>(data);
            newNode.parent = parent;
            return newNode;
        }

        if (data.compareTo(this.root.data) < 0) {
            root.left = insert(root.left, data, root);
        } else {
            root.right = insert(root.right, data, root);
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));
        return balance(root);
    }

    private AVLNode<T> balance(AVLNode<T> node) {
        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) < 0) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }

        if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) > 0) {
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }

        return node;
    }

    private AVLNode<T> leftRotate(AVLNode<T> node) {
        AVLNode<T> newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));

        return newRoot;
    }

    private AVLNode<T> rightRotate(AVLNode<T> node) {
        AVLNode<T> newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));

        return newRoot;
    }

    private int height(AVLNode<T> node) {
        return node == null ? 0 : node.height;
    }

    private int getBalanceFactor(AVLNode<T> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    public AVLNode<T> deleteRecursively(AVLNode<T> root, T val) {
        if(root == null) {
            System.out.println("The tree is empty!");
            return null;
        }
        int comparison = root.data.compareTo(val);
        if(comparison > 0) {
            root.left = deleteRecursively(root.left, val);
        }
        else if(comparison < 0) {
            root.right = deleteRecursively(root.right, val);
        }
        else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            if(root.right == null) {
                System.out.println("null");
            }

            root.right = deleteRecursively(root.right, root.data);

        }
        return balance(root);
    }

    public T minValue(AVLNode<T> root) {
        T minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public void deleteNode(T val) {
        this.root = deleteRecursively(root, val);
    }

    public void searchEmployeeByName(AVLNode<Employee> root, String name, List<Employee> results) {
        if (root == null) {
            return;
        }
        if(root.data.getEmpName().contains(name)) {
            results.add(root.data);
        }
        searchEmployeeByName(root.left, name, results);
        searchEmployeeByName(root.right, name, results);
    }

    public void searchIceCreamByName(AVLNode<IceCream> root, String name, List<IceCream> results) {
        if (root == null) {
            return;
        }
        if(root.data.getIceCreamName().contains(name)) {
            results.add(root.data);
        }
        searchIceCreamByName(root.left, name, results);
        searchIceCreamByName(root.right, name, results);
    }

    public T getNode (AVLNode<T> root, T data) {
        if (root == null) {
            return null;
        }
        if(root.data.compareTo(data) == 0) {
            return root.data;
        }
        getNode(root.left, data);
        getNode(root.right, data);
        return root.data;
    }

    public boolean isNodeExisted (T data) {
        return this.getNode(this.root, data) != null;
    }

}
