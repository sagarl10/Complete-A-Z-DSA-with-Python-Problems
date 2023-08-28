package JAVA.STACK;

import java.util.Stack;

public class ReverseStack {
    public void insertatbot(Stack<Integer> s,int item){
        if(s.isEmpty()){
            s.push(item);
            return;
        }
        int num=s.pop();
        insertatbot(s, item);
        s.push(num); 
    }
    public void reverse(Stack<Integer> s){
         if(s.isEmpty()){
            return;
        }
        int num=s.pop();
        reverse(s);
        insertatbot(s, num);


    }
    public static void main(String[] args) {
        ReverseStack rs=new ReverseStack();
        Stack<Integer> s=new Stack<>();
        s.push(3);
        s.push(1);
        s.push(4);
        s.push(0);
        rs.reverse(s);
        System.out.println(s);
       // rs.reverse(null);
        
    }
    
}
