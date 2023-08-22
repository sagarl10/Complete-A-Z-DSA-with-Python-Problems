package JAVA.STACK;

public class CyclicQueue {
    public int data[];
    public int defualtsize=10;
    public int size=0;
    public int front;
    public int end;

    public CyclicQueue(){
        this.data=new int[defualtsize];
    }
    public CyclicQueue(int size){
        this.data=new int[size];
    }
    public void push(int item){
        if (size==data.length){
            System.out.println("Size is full");
            return;
        }
        data[end++]=item;
        end=(end)%data.length;
        size++;
    }
    public int pop() throws Exception{
        if(size==0){
            throw new Exception("Queue is empty", null);
        }
        int pop=data[front];
        front++;
        front=front%data.length;
        size--;
        return pop;

    }
    public int peek(){
        int top=data[front];
        return top;

    }

    
}
