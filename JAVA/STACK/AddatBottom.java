package JAVA.STACK;

import java.util.Stack;

public class AddatBottom {
    public void InsertatBottom(Stack<Integer> s,int item){
        if(s.isEmpty()){
            s.push(item);
            return;
        }
        int num=s.pop();
        InsertatBottom(s, item);
        s.push(num);

    }
    public static void main(String[] args) {
        AddatBottom ab=new AddatBottom();
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        ab.InsertatBottom(s, 5);
        System.out.println(s);

    }
    
}
