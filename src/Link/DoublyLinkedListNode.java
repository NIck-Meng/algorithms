package Link;

class DoublyLinkedListNode extends Node{
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;



    DoublyLinkedListNode(int data) {
        super(data);

    }


    @Override
    public String toString() {
        return "DoublyLinkedListNode{" +
                "prev=" + prev +
                ", next=" + next +
                '}';
    }
}
