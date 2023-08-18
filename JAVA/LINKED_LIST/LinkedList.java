package JAVA.LINKED_LIST;

import java.util.ArrayList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size=0;

    public class Node{
        private int data;
        private Node next;
         public Node(){ 
    }
   
}
public LinkedList(){
    this.size=0;
}
public void display(){
    Node temp=head;
    while (temp!=null){
        System.out.print(temp.data+" ->");
        temp=temp.next;

    }
}
public Node get(int index){
    Node temp=head;
    for(int i=0;i<index;i++){
        temp=temp.next;
    }
    return temp;
}
public int find(int value){
    Node temp=head;
    int index=0;
    while (temp!=null){
        if (temp.data==value){
            break;
        }
        temp=temp.next;
        index++;   

    }
    return index;

}
public void addFirst(int data){
    Node node=new Node();
    node.data=data;
    node.next=head;
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
    Node node=new Node();
    node.data=data;
    tail.next=node;
    tail=node;
    size++;
}
public void insert(int data,int index){
    if (index==0){
        addFirst(data);
        return;
    }
    if (index==size){
        addLast(data);
        return;
    }
    Node temp=head;
    for(int i=1;i<index;i++){
        temp=temp.next;
    }
    Node node=new Node();
    node.data=data;
    node.next=temp.next;
    temp.next=node;
    size++;

}
public int deleteFirst(){
    int temp=head.data;
    head=head.next;
    if (head==null){
        tail=null;
    }
    size--;
    return temp ;
    
}
public int deleteLast(){
    if (size<=1){
        int a=deleteFirst();
        return a;
    }

    int ans=tail.data;
    Node temp=get(size-2);
    tail=temp;
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
    return ans;
}
public void insertRec(int data,int index){
    if(index==0){
        addFirst(data);
        return;
    }
    if (index==size){
        addLast(data);
        return;
    }
    helper(data, index, head);
    
}
public void helper(int data,int index,Node temp){
    if(index==1){
        Node node=new Node();
        node.data=data;
        node.next=temp.next;
        temp.next=node;
        return;
    }
    helper(data, index-1, temp.next);

    }

public void duplicates(){
    Node temp=head;

    while (temp.next!=null){
       if (temp.data==temp.next.data){
        temp.next=temp.next.next;
       }
       else{
         temp=temp.next;

       }
    }
    tail=temp;
    tail.next=null;
} 
public static LinkedList merge(LinkedList l1,LinkedList l2){
    Node temp1=l1.head;
    Node temp2=l2.head;
    LinkedList ll=new LinkedList();
    while (temp1!=null && temp2!=null){
        if (temp1.data<temp2.data){
            ll.addLast(temp1.data);
            temp1=temp1.next;
        }
        else{
            ll.addLast(temp2.data);
            temp2=temp2.next;
        }

    }
    while (temp1!=null){
        ll.addLast(temp1.data);
        temp1=temp1.next;
    }
      while (temp2!=null){
        ll.addLast(temp2.data);
        temp2=temp2.next;
    }
    return ll;
}  
//VVVVVVVVIIMMMMPPPPPP
public static void reversal(LinkedList ll){
    Node temp=ll.head;
    Node prev=null;
    while (temp!=null){
        Node forw=temp.next;
        temp.next=prev;
        prev=temp;
        temp=forw;
    }
    ll.head=prev;
} 
public static void reversalRec(LinkedList ll,Node temp,Node prev){
     if(temp==null){
        ll.head=prev;
        return;
     }
     Node forw=temp.next;
     temp.next=prev;
     prev=temp;
     temp=forw;
     reversalRec(ll, temp, prev);
} 

public static void main(String[] args) {
    LinkedList ll=new LinkedList();
    ll.addLast(1);
    ll.addLast(2);
    ll.addLast(3);
    ll.addLast(3);
    LinkedList.reversalRec(ll, ll.head, null);
    ll.display();

   

}

}