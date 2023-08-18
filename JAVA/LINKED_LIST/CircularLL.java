package JAVA.LINKED_LIST;

public class CircularLL {
    public Node head;
    public Node tail;
    public int size=0;

    public CircularLL(){
        this.size=0;
    }
    private class Node{
        public int data;
        public Node next;

        public Node(int data){
            this.data=data;
        }

    }
    public void display(){
        Node temp=head;
        do{
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        while(temp!=head);
    }
    public int find(int data){
        int index=0;
        Node temp=head;
        do{
            if (temp.data==data){
                break;
            }
            temp=temp.next;
            index++;
        }
        while (temp!=head);
        return index;

    }

    public void insert(int data){
        Node node=new Node(data);
        if (head==null){
            head=node;
            tail=node;
            size++;
            return;
        }
        tail.next=node;
        node.next=head;
        tail=node;
        size++;
    }
    public void delete(int data){
        if (head==null){
            return;
        }
        Node temp=head;
        do{
            if
        }

        return;
    }
    
}
