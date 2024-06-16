package model.avltree;

public class AVLNode<T> {
    public T data;
    public AVLNode<T> left;
    public AVLNode<T> right;
    public AVLNode<T> parent;
    public int height;

    public AVLNode(T data) {
        this.data = data;
        this.height = 0;
    }
}
