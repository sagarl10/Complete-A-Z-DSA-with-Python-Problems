package JAVA.STACK;

import java.util.Stack;

public class ImplementQusingstack {
    public Stack<Integer> s1=new Stack<>();
    public Stack<Integer> s2=new Stack<>();
    
    public ImplementQusingstack(){
    }
    public void push(int item){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s2.push(item);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }

    }
    public int pop(){
        return s1.pop();

    }
    public int peek(){
        return s1.peek();

    }
    public boolean empty(){
        if(s1.isEmpty()){
            return true;
        }
        return false;

    }
}
