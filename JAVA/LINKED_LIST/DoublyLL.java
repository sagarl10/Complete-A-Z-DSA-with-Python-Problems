package JAVA.LINKED_LIST;

public class DoublyLL {
    private Node head;
    private Node tail;
    private int size=0;
    
    public DoublyLL(){
        this.size=0;

    }

    private class Node{
        private int data;
        private Node prev;
        private Node next;

        public Node(int data){
            this.data=data;
        }
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
    }
    public void reverse(){
        Node temp=tail;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.prev;
        }
    }
    public Node get(int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }
    public void addFirst(int data){
        Node node=new Node(data);
        node.next=head;
        if(head!=null){
            head.prev=node;
        }
        head=node;
        if (tail==null){
            tail=head;
        }
        size++; 
    }
    public void addLast(int data){
        if (tail==null){
            addFirst(data);
            return;
        }
        Node node=new Node(data);
        node.prev=tail;
        tail=node;
        tail.next=null;
        size++;

    }
    public void insert(int index,int data){
        if(index==0){
            addFirst(data);
            return;

        }
        if (index==size){
            addLast(data);
            return;
        }
        Node temp=get(index-1);
        Node node=new Node(data);
        Node temp2=temp.next;
        node.next=temp2;
        node.prev=temp;
        temp.next=node;
        temp2.prev=node;

        size++;
    }
    public int deleteFirst(){
        if (tail==null){
            tail=head;
        }
        int ans=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return ans;
    }
    public int deleteLast(){
        if (tail==null){
            return deleteFirst();

        }
        int ans=tail.data;
        tail=tail.prev;
        tail.next=null;
        size--;
        return ans;
    }
    public int delete(int index){
        if (index==0){
            return deleteFirst();
        }
        if (index==size-1){
            return deleteLast();
        }
        Node temp=get(index-1);
        int ans=temp.next.data;
        temp.next=temp.next.next;
        temp.next.prev=temp;
        size--;
        return ans;
    }
    
}
