package JAVA.STACK;

import java.util.Stack;

public class MinimumEleStack {
    Stack<Integer> s;
    Stack<Integer> ss;

    public MinimumEleStack(){
        this.s=new Stack<>();
        this.ss=new Stack<>();
    }

    public void push(int item){
        s.push(item);
        if(ss.isEmpty() || item<=ss.peek()){
            ss.push(item);
            return;
        }
    }
    public int pop(){
        if(ss.size()==0){
            System.out.println("No elements to pop");
        }
        int ans=s.pop();
        if(ss.peek()==ans){
            ss.pop();
        }
        return ans;
    }
    public int peek(){
        return s.peek();
    }
    public int getMin(){
        int ans=ss.pop();
        return ans;
    }
    public static void main(String[] args) {
        MinimumEleStack me=new MinimumEleStack();
        me.push(1);
        me.push(2);
        me.push(0);
        me.push(3);

        System.out.println(me.pop());
        System.out.println(me.getMin());
    }
    
}
