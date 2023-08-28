package JAVA.STACK;

import java.util.Stack;

public class NGR {
    public int[] next_greater_right(int[] arr) {
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int cur=arr[i];
            while (!s.isEmpty() && s.peek() < arr[i]) {
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
        int arr[]={1,2,3,4,5,6};
        NGR ng=new NGR();
        int ans[]=ng.next_greater_right(arr);
        for (int i : ans) {
            System.out.println(i);
        }
    }

}
