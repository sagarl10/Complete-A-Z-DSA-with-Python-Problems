package JAVA.STACK;

import java.util.Stack;

public class ValidParanthesis {
    public boolean valid(String str){
        Stack<Character> s =new Stack<>();
        if(str.length()<=1){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                s.push(ch);
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                if(ch==')' && s.peek()=='(' || ch=='}' && s.peek()=='{' || ch==']' && s.peek()=='['){
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ValidParanthesis vp=new ValidParanthesis();
        System.out.println(vp.valid("(){}{[]}"));
        System.out.println(vp.valid("()]"));
    }
    
}
