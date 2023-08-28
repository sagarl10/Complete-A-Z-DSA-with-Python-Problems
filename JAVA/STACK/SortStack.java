package JAVA.STACK;

import java.util.Stack;

public class SortStack {
    
   

    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(3);
        s.push(1);
        s.push(4);
        s.push(0);
        sort(s);
        System.out.println(s);
    }
    public static void sort(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int num=s.pop();  
        sort(s);
        InseratBot(s,num);

    }
     public static void InseratBot(Stack<Integer> s,int item){
        if(s.isEmpty() || s.peek()<=item){
            s.push(item);
            return;
        }
        int num=s.pop();  
        InseratBot(s,item);
        s.push(num);
    }
    
}
