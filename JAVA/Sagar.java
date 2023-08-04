package JAVA;

public class Sagar {
    int age;
    String name;
    String job;
    public Sagar(int age,String name,String job){
        this.age=age;
        this.name=name;
        this.job=job;
    System.out.println("HI HOW ARE YOU "+name); 

    }
    public static void main(String[] args) {
        System.out.println("Hello Sagar");
        Sagar first=new Sagar(24,"Sagar","ADA");
        System.out.println(first.name);
    }
    
}
