package JAVA.STACK;

import java.util.Stack;

public class NSR {
    public int[] next_smaller_right(int arr[]){
        Stack<Integer> s=new Stack<>();
        for (int i = arr.length-1; i >=0; i--) {
            int cur=arr[i];
            while(!s.isEmpty() && s.peek()>arr[i]){
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
        NSR nsr=new NSR();
        int arr[]={3,4,2,1,6,4,2,0};
        int ans[]=nsr.next_smaller_right(arr);
        for (int i : ans) {
            System.out.println(i);
            
        }
    }
    
}
