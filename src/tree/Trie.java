package tree;

import java.util.TreeMap;

public class Trie {
//    trie树每一层的节点数是26^i级别的




    public class Node{
        public boolean isWord;
        public TreeMap<Character,Node> children;  //每个节点包含26个子节点(类型为自身)

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
        }
    }

    private Node root;  //根结点
    private int size;   //单词总数

    public Trie() {
        root=new Node();
        size=0;
    }

    /**
     * 获取存储的单词量
     */
    public int getSize() {
        return size;
    }

    public boolean add(String word){
        return add(this.root,word);
    }



    private boolean add(Node root,String word){
        if(word==null || word.length()==0) return false;
        char[] chs=word.toLowerCase().toCharArray();

        int i=0;
        Node curr=root;
        while(i<chs.length){
            if(!curr.children.containsKey(chs[i])){
                curr.children.put(chs[i],new Node());
            }

        }
    return false;

    }







}
