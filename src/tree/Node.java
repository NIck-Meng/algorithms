package tree;

public class Node implements Comparable<Node>{
    int data;
    Node leftChild;
    Node rightChild;
    boolean isDelete;//表示节点是否被删除

    int bf=-1;//平衡因子，普通二叉排序树并不需要用到该字段

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }


    @Override
    public int compareTo(Node node) {
        if(this.data<node.data) return -1;
        else if(this.data>node.data) return 1;
        else return 0;
    }
}
