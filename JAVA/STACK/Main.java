package JAVA.STACK;

public class Main {
    public static void main(String[] args) throws Exception {
        ImplementQusingstack2 s=new ImplementQusingstack2();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.pop();
        System.out.println(s.empty());
    }
    
}
