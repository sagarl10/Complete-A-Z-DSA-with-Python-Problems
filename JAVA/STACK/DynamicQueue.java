package JAVA.STACK;

public class DynamicQueue {
    public int data[];
    public int defaultsize=10;
    public int index=0;

    public DynamicQueue(){
        this.data=new int[defaultsize];
        }
    public DynamicQueue(int size){
        this.data=new int[size];
    }    
    public void insert(int item){
        if(index==data.length){
            doublesize();
        }
        data[index]=item;
        index++;

    }
    public int remove() throws Exception{
        if(index==0){
            throw new Exception("Queue is empty", null);
        }
        int rmdata=data[0];
        for (int i = 1; i < data.length; i++) {
            data[i-1]=data[i];     
        }
        index--;
        return rmdata;
    }
    public void doublesize(){
        int[] temp=new int[data.length*2];
        for (int i = 0; i < data.length; i++) {
            temp[i]=data[i];
        }
        data=temp;
    }
    
    public void display(){
        for (int i = 0; i < index; i++) {
            System.out.print(data[i]+"->");
            
        }
    }

    
}
