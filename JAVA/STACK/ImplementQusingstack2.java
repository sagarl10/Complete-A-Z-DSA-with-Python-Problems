package JAVA.STACK;

import java.util.Stack;

public class ImplementQusingstack2 {
    public Stack<Integer> in=new Stack<>();
    public Stack<Integer> op=new Stack<>();
    
    public void push(int item){
        in.push(item);
    }
    public int pop(){
        if(!op.isEmpty()){
            return op.pop();
        }
        while(!in.isEmpty()){
            op.push(in.pop());
        }
        return op.pop();
    }
    public int peek(){
        if(!op.isEmpty()){
            return op.peek();
        }
        while(!in.isEmpty()){
            op.push(in.pop());
        }
        return op.peek();

    }
    public boolean empty(){
        if(in.isEmpty() && op.isEmpty()){
            return true;
        }
        return false;
    }

}
