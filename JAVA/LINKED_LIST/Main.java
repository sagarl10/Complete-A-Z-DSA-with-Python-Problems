package JAVA.LINKED_LIST;

public class Main {
    public static void main(String[] args) {
        CircularLL cl=new CircularLL();
        cl.insert(1);
        cl.insert(2);
        cl.insert(3);
        cl.delete(2);
        cl.display();
    }
    
}
