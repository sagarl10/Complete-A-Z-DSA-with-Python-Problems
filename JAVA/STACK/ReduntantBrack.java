package JAVA.STACK;

import java.util.Stack;

public class ReduntantBrack {
    public boolean reduntant(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                s.push(ch);
            } else {
        
                if (ch == ')') {
                    boolean reduntant = true;
                    while (s.peek() != '(') {
                        if (s.peek() == '+' || s.peek() == '-' || s.peek() == '*' || s.peek() == '/') {
                            reduntant = false;
                            
                        }
                        s.pop();
                    }
                 
                    if (reduntant == true) {
                        return true;
                    }
                       s.pop();

                }
            }

        }

        if (s.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ReduntantBrack rb = new ReduntantBrack();
        System.out.println(rb.reduntant("((a+b))"));

    }

}
