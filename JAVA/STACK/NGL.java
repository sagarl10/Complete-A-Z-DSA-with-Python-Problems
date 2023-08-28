package JAVA.STACK;

import java.util.Stack;

public class NGL {
    public int[] next_greater_left(int arr[]){
        Stack<Integer> s=new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int cur=arr[i];
            while(!s.isEmpty() && s.peek()<arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                arr[i]=-1;
            }
            else{
                arr[i]=s.peek();
            }
            s.push(cur);
            
        }
        return arr;
    }
    public static void main(String[] args) {
        NGL ngl=new NGL();
        int arr[]={2,3,1,2,5,1,35,3};
        int ans[]=ngl.next_greater_left(arr);
        for (int i : ans) {
            System.out.println(i);
            
        }
    }
    
}
