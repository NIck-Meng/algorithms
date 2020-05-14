
package tree;
import java.util.Stack;

public class BinarySearchTree implements Tree {
    private Node root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }


    /*
        查找某个节点，我们必须从根节点开始遍历。
        查找值比当前节点值大，则搜索右子树；
        查找值等于当前节点值，停止搜索（终止条件）；
        查找值小于当前节点值，则搜索左子树；*/
    @Override
    public Node find(int key) {
        Node current=root;

        while(current!=null){
            if(current.data>key) current=current.leftChild;  //当前值比查找值大，搜索左子树
            if(current.data<key) current=current.rightChild; //当前值比查找值小，搜索右子树
            else return current;
        }
        return null;  //遍历完整个树没找到，返回null
    }



    @Override
    public boolean insert(int key) {
        Node newNode=new Node(key);
        if(root==null){
            root=newNode;
            return true;
        } else {
            Node current=root;
            Node parentNode=null;
            while(current!=null){
                parentNode=current;
                if(current.data>key) {
                    current = current.leftChild;
                    if (current == null) {
                        parentNode.leftChild = newNode;
                        return true;

                    }
                }
                else{
                    current=current.rightChild;
                    if(current==null){
                        parentNode.rightChild=newNode;
                        return true;
                    }
                }

            }
        }


        return false;
    }

    public Node findMax(){
        Node current=root;
        Node maxNode=current;
        while(current!=null){
            maxNode=current;
           current=current.rightChild;
        }
        return maxNode;
    }

    public Node findMin(){
        Node current=root;
        Node minNode=current;
        while(current!=null){
            minNode=current;
            current=current.leftChild;
        }
        return minNode;
    }


    @Override
    public boolean delete(int key) {

        Node current=root;  //当前结点
        Node parentNode=null; //当前结点的父节点
        boolean isLeftNode=false; //删除结点为左结点还是右结点

        //查找删除值，找不到直接返回false
        while(current.data!=key){
            parentNode=current;
            if(current.data>key){
                current=current.leftChild;
                isLeftNode=true;
            }
            else{
                current=current.rightChild;
                isLeftNode=false;
            }
        }
        if(current==null) return false;

        //如果删除结点是叶结点
        if(current.leftChild==null && current.rightChild==null){
            if(current==root){
                root=null;
            }
            else if(isLeftNode){
                parentNode.leftChild=null;

            } else{
                parentNode.rightChild=null;
            }
            return true;
        }

//        如果删除结点有一个子节点
        if(current.leftChild==null && current.rightChild!=null){
            if(current==root){
                root=current.rightChild;
            }
            else if(isLeftNode){
                parentNode.leftChild=current.rightChild;
            }
            else parentNode.rightChild=current.rightChild;

            return true;
        } else if (current.leftChild!=null && current.rightChild==null){
            if(current==root){
                root=current.leftChild;
            } else if(isLeftNode){
                parentNode.leftChild=current.leftChild;

            } else parentNode.rightChild=current.leftChild;
            return true;
        }
        else{
            //如果删除结点有两个子节点
            Node sucessor=getSuccessor(current);
            if(current==root){
                root=sucessor;
            }
            else if(isLeftNode){
                parentNode.leftChild=sucessor;
            } else{
                parentNode.rightChild=sucessor;
            }
            sucessor.leftChild=current.leftChild;
        }
        return false;
    }






    public void preOrder(Node current){
//  前序遍历:根节点——》左子树——》右子树
        if(current!=null){
            preOrder(current.leftChild);
            preOrder(current.rightChild);
            System.out.print(current.data+",");
        }
    }

    public void inOrder(Node current){
//  中序遍历:左子树——》根节点——》右子树
        if(current!=null) {
            inOrder(current.leftChild);
            System.out.print(current.data + ",");
            inOrder(current.rightChild);
        }
    }

    public void postOrder(Node current){
//  后序遍历:左子树——》右子树——》根节点
        if(current!=null){
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.print(current.data+",");
        }
    }

    public void preOrder2(Node current){
        Stack<Node> stack = new Stack<>();
        while(current!=null || !stack.isEmpty()){
            if(current!=null){
                System.out.print(current.data+",");
                stack.push(current);
                current=current.leftChild;
            }
            else {
                Node node=stack.pop();
                current=node.rightChild;

            }

            }

        }










    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }

    public Node getSuccessor(Node delNode){
//        获取删除结点的中序后继结点
        Node successorParent=null;
        Node successor=null;
        Node current=delNode.rightChild;

        while(current!=null){
            successorParent=successor;
            successor=current;
            current=current.leftChild;//依次顺着左子节点找下去，最后一个左子节点即是后继节点
        }
        if(successor!=delNode.rightChild){
            //后继节点是删除节点的右子节点的左子节点
            successorParent.leftChild=successor.rightChild;
            successor.rightChild=delNode.rightChild;

        }

        return successor;
    }

}
