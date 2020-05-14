package Link;

class Node {
    int data;
    Node next; //定义下一个节点

    Node(){}

    Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}


