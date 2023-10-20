package JAVA.MATRIX;

public class Matrix {

    public static void spiralMatrix(int arr[][]) {
        int rowstart = 0;
        int rowend = arr.length - 1;

        int colstart = 0;
        int colend = arr[0].length - 1;

        while (rowstart < rowend && colstart < colend) {

            for (int i = colstart; i <= colend; i++) {
                System.out.print(arr[rowstart][i] + " ");
            }
            rowstart++;

            for (int i = rowstart; i <= rowend; i++) {
                System.out.print(arr[i][colend] + " ");
            }
            colend--;
            for (int i = colend; i >= colstart; i--) {
                System.out.println(arr[rowend][i] + " ");
            }
            rowend--;
            for (int i = rowend; i >= rowstart; i--) {
                System.out.println(arr[i][colstart] + " ");
            }
            colstart++;

        }
    }

    public static void snake(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.println(arr[i][j]);
                }
            } else {
                for (int j = arr.length - 1; j >= 0; j--) {
                    System.out.println(arr[i][j]);
                }

            }

        }
    }

    public static void snakeTopDown(int arr[][]) {
        for (int col = 0; col < arr.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < arr.length; row++) {
                    System.out.println(arr[row][col]);
                }
            } else {
                for (int row = arr.length - 1; row >= 0; row--) {
                    System.out.println(arr[row][col]);
                }

            }

        }
    }

    public static void reverse(int arr[]){
        int start=0;
        int end=arr.length-1;

        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void rotate90(int arr[][]){

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }

        for(int i=0;i<arr.length;i++){
            reverse(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[i][j]);
                
            }
            
        }
    }

    public static void main(String[] args) {

        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // [1,2,3]           [7,4,1]
        // [4,5,6]  -- >     [8,5,2]
        // [7,8,9]           [9,6,3]
        rotate90(arr);

    }

}
