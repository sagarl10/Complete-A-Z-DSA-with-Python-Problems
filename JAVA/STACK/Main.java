package JAVA.STACK;

public class Main {
    public static void main(String[] args) throws Exception {
        ImpleStckusing1queue s=new ImpleStckusing1queue();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
    
}
