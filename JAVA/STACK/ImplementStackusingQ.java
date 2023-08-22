package JAVA.STACK;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQ {
     Queue<Integer> q1;
     Queue<Integer> q2;


    public  ImplementStackusingQ(){
        this.q1=new LinkedList<>();
        this.q2=new LinkedList<>();
    }
    // Push item to q2 (q2.add())
    // Push items from q1 to q2 (q2.add(q1.remove()))
    // Swap q1 and q2
    public void push(int item){
        q2.add(item);
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        //SWAP
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
    }
    // q1.remove()
    public int pop(){
        return q1.remove();
    }
    //q1.peek();
    public int peek(){
        return q1.peek();
    }
    
}
