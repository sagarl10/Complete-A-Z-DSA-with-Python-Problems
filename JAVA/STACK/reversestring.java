package JAVA.STACK;

import java.util.Stack;

public class reversestring {
    public String reverse(String str){
        Stack<Character> s=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        String reverse="";
        while(!s.isEmpty()){
            reverse=reverse+s.pop();
        }
        return reverse;
    }
    public static void main(String[] args) {
        reversestring rs=new reversestring();
        System.out.println(rs.reverse("mango"));
    }
    
}
