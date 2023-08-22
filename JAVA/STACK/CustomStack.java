package JAVA.STACK;

public class CustomStack{
    public int data[];
    public int defaultsize=10;
    public int size;
    public int index=0;

    public CustomStack(){
        this.data=new int[defaultsize];
    }
    public CustomStack(int size){
        this.size=size;
        this.data=new int[size];
    }
    public void push(int item) throws Exception{
        if (index==size){
            throw new Exception("Stack is full!");
        }
        data[index]=item;
        index++;
    }
    public int pop() throws Exception{
        if (index==0){
            throw new Exception("No elements to pop from stack");
        }
        int pop=data[index-1];
        index--;
        return pop;
    }
    public void display(){
        for (int i = 0; i < index; i++) {
            System.out.print(data[i]+" ");
            
        }
    }

}