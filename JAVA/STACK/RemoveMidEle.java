package JAVA.STACK;

import java.util.Stack;

public class RemoveMidEle {
    public void remove(Stack<Integer> s,int size,int cnt){
        if(cnt==size/2){
            System.out.println(s.pop());
            return;
        }
        int num=s.pop();
        remove(s, size, cnt+1);
        s.push(num);
    }
    public static void main(String[] args) {
        RemoveMidEle rm=new RemoveMidEle();
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        rm.remove(s, s.size(), 0);
        System.out.println(s.peek());
    }
    
}
