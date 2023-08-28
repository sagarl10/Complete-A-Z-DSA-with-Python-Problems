package JAVA.STACK;

public class Max_Area_Hist {
    public static int maxahist(int hist[]){
        int maxArea=0;
        for (int i = 0; i < hist.length; i++) {
            int left=i-1;
            int right=i+1;
             while(left>=0 && hist[left]>=hist[i]){
                left--;
             }
             while(right<hist.length && hist[right]>=hist[i]){
                right++;
             }
             int width=Math.abs(right-left-1);
             maxArea=Math.max(maxArea, hist[i]*width);
            
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int hist[]={2,1,2};
        System.out.println(maxahist(hist));
    }
    
}
