package tree;

public class RBNode<T extends Comparable<T>> {
    boolean isRed;
    T data;
    RBNode<T> leftChild;
    RBNode<T> rightChild;
    RBNode<T> parent;

    public RBNode(T data) {
        this.data = data;
    }

    public RBNode(boolean isRed, T data, RBNode<T> leftChild, RBNode<T> rightChild, RBNode<T> parent) {
        this.isRed = isRed;
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.parent = parent;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return ""+data+(isRed?"R":"B");
    }
}
