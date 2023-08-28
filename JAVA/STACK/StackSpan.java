package JAVA.STACK;

import java.util.Stack;

public class StackSpan {
    public int[] stackspan(int arr[]) {
        int maxspan[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.size() == 0) {
                maxspan[i] = -1;
            } else {
                maxspan[i] = s.peek();
            }
            s.push(i);
        }
        return maxspan;
    }

    public static void main(String[] args) {
        StackSpan ss = new StackSpan();
        int arr[] = {5,4,3,2,1,3,4,5};
        int ans[] = ss.stackspan(arr);
        for (int i : ans) {
            System.out.println(i);
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i]=i-ans[i];
        }
        for (int i : ans) {
            System.out.println(i);
        }
    }

}
