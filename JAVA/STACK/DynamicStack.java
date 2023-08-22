package JAVA.STACK;

public class DynamicStack extends CustomStack {
    public DynamicStack(){
        super();
    }
    public DynamicStack(int size){
        super(size);
    } 
    @Override
    public void push(int item){
        if(index==data.length){
            dooublesize();
        }
        data[index]=item;
        index++;

    } 
    public void dooublesize(){
        int[] temp=new int[data.length*2];
        for (int i = 0; i < data.length; i++) {
            temp[i]=data[i];

            
        }
        data=temp;

        }
}
