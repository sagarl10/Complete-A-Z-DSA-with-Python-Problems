package JAVA.STACK;

import java.util.Stack;

public class Max_Area_hist_Stack {
    public int[] next_smallest_right(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = arr.length;
            } else {
                result[i] = s.peek();
            }
            s.push(i);
        }
        return result;
    }

    public int[] next_smallest_left(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = s.peek();
            }
            s.push(i);
        }
        return result;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] next_small = next_smallest_right(heights);
        int[] prev_small = next_smallest_left(heights);

        for (int i = 0; i < heights.length; i++) {
            int width = next_small[i] - prev_small[i]-1;
            int height = heights[i];
            maxArea = Math.max(maxArea, width * height);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Max_Area_hist_Stack ma = new Max_Area_hist_Stack();
        int hist[] = {6, 6, 6, 6, 6, 6};
        int maxArea = ma.largestRectangleArea(hist);
        System.out.println("Largest Rectangle Area: " + maxArea);
    }
}
