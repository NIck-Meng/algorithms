package Link;

class LinkList {

    class Node{

        private String name;
        private Node next;
        public Node(String name){
            this.name=name;
        }
        public String getName(){
            return this.name;
        }

        //to add a node
        public void addNode(Node newNode){
            if(this.next==null){
                this.next=newNode;
            }else{
                this.next.addNode(newNode);//recursive call.it'll keep searching until finding a Node which doesn't have next node
            }
        }

        //to print these nodes
        public void printNode(){
            System.out.print(this.name+"-->");
            if(this.next!=null){
                this.next.printNode();
            }
        }
        //searching for a node
        public boolean searchNode(String name){
            if(this.name.equals(name)){
                return true;
            }else{
                if(this.next!=null){
                    return this.next.searchNode(name);
                }else{
                    return false;
                }
            }
        }

        //to delete a node
        public void deleteNode(Node preNode,String name){
            if(this.name.equals(name)){
                preNode.next = this.next ;
            }else{
                this.next.deleteNode(this,name) ;
            }
        }
    }


    private Node root;//root node

    //add
    public void add(String name){
        Node newNode = new Node(name);
        if(this.root==null){
            this.root = newNode;
        }
        else{
            this.root.addNode(newNode);
        }
    }

    //print
    public void print(){
        if(this.root!=null){
            this.root.printNode();
        }
    }

    //search
    public boolean search(String name){
        if(this.root!=null){
            return root.searchNode(name);
        }
        else{
            return false;
        }
    }

    //delete
    public void delete(String name){
        if(this.search(name)){//if the node exists
            if(this.root.name.equals(name)){
                if(this.root.next!=null){
                    this.root = this.root.next ;
                }else{
                    this.root = null ;
                }
            }else{
                if(this.root.next!=null){
                    this.root.next.deleteNode(root,name) ;
                }
            }
        }

    }

}
