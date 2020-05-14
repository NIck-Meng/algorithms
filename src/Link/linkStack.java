package Link;

public class linkStack implements Stack {
    private Node headNode=new Node();
    private int size;

    linkStack(){}


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return headNode==null;
    }

    @Override
    public void push(int ele) {
        Node newNode=new Node(ele);

        if(isEmpty()){
            headNode=newNode;
        }
        else {
            newNode.next=headNode;
            headNode = newNode;
        }
        size++;

    }

    @Override
    public int pop() {
        if(size==0){
            System.out.println("栈为空");
            return 0;

        }
        //出栈(返回栈顶的值，并且删除)
        return 0;
    }

    @Override
    public int getHead() {
        return 0;
    }


    @Override
    public boolean isFull() {
        return false;
    }
}
