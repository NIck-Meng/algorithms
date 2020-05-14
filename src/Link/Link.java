package Link;

public class Link {
    class Node {
        private Object data;
        private Node next; //定义下一个节点

        public Node(Object data) {
            this.data = data;
        }


        public void addNode(Node newNode) {
            if(this.next == null) {
                this.next = newNode;
            } else {
                this.next.addNode(newNode);
            }
        }


        public boolean containsNode(Object obj){
            if(obj==this.data){
                return true;
            } else{
                if(this.next!=null){
                    return this.next.containsNode(obj);
                }
                else{
                    return false;
                }
            }
        }

        public Object getNode(int index){
            if(Link.this.foot++==index)
                return this.data;
             else
                return this.next.getNode(index);
        }

        public void setNode(int index,Object newData){
            if(Link.this.foot++ ==index)
                this.data=newData;
            else{
                if(this.next != null)
                    this.next.setNode(index,newData);
            }


        }


        public void removeNode(Node previous ,Object data){
            if(this.data.equals(data)){
                previous.next=this.next;
            }
            else{
                this.next.removeNode(this,data);
            }
        }


    }

    public int size() {
        return count;
    }


    private int foot=0;//结点的index
    private int count=0;//长度
    private Node root; //定义头结点

    public void add(Object data) { //末尾添加节点
        if(data == null) {
            return;
        }
        Node newNode = new Node(data);
        if(this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
        count++;
    }

    public boolean isEmpty() {
        return this.count==0;
    }
    public Object[] toArray() {
        if(this.count==0){
            return null;
        }
        Object [] array=new Object[this.count];
        int index=0;
        Node curr=this.root;
        while(curr != null){
            array[index++]=curr;
            curr=curr.next;
        }
        return array;
    }

    public boolean contains(Object data) {
       return  this.root.containsNode(data);

    }

    public Object get(int index) {
        if(index>=this.count)
            return null;
//        this.foot=0;
        return this.root.getNode(index);
    }

    public void set(int index,Object newData){
        if(index>=this.count)
            return;
        this.foot=0;
        this.root.setNode(index,newData);
    }


    public void  remove(Object data){
        if(this.contains(data)){
            if(this.root.data.equals(data)){
                this.root=this.root.next;
            } else {
                this.root.next.removeNode(this.root,data);
            }
            count--;
        }
    }



    public void printList(){
        Node curr=this.root;
        while(curr != null){
            System.out.println(curr.data);
            curr=curr.next;

        }



    }



}
