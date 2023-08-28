package JAVA.STACK;

import java.util.Stack;

class Next_Greater_Element {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        
        for (int i = (n * 2) - 1; i >= 0; i--) {
            int cur = nums[i % n];
            
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                result[i % n] = -1;
            } else {
                result[i % n] = s.peek();
            }
            
            s.push(cur);
        }
        
        return result;
    }
    public static void main(String[] args) {
        Next_Greater_Element nge=new Next_Greater_Element();
        int arr[]={1,2,3,4,5,4};
        int ans[]=nge.nextGreaterElements(arr);
        for (int i : ans) {
            System.out.println(i);
        }

    }
}
