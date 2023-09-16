package ZOHO_INTERVIEW;

import java.util.Set;
import java.util.TreeMap;

public class Zoho {
    public static void print_program(){
        String s="PROGRAM";
        char c[]=s.toCharArray();
        for(int i=0;i<c.length;i++){
            for (int j = 0; j < c.length; j++) {
                if(i==j || j==c.length-i-1){
                    System.out.print(c[i]);
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void weights(){
        int arr[]={10,36,54,81,12};
        TreeMap<Integer,Integer> weights= new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            int sqrt=(int)Math.sqrt(arr[i]);
            if(sqrt*sqrt==arr[i]){
                weights.put(5,arr[i]);
            }
            else if(arr[i]%4==0 && arr[i]%6==0){
                weights.put(4,arr[i]);
            }
            else if(arr[i]%2==0){
                weights.put(3,arr[i]);
            }
        }
        Set<Integer> s=weights.keySet();
        for (Integer integer : s) {
            System.out.println("<"+integer+","+weights.get(integer)+">");
            
        }
    }
    public static void zoho(){
        String s="WELCOMETOZOHOCORPORATION";
        int n=s.length();
        char[][] matrix = {
            {'W', 'E', 'L', 'C', 'O'},
            {'M', 'E', 'T', 'O', 'Z'},
            {'O', 'H', 'O', 'C', 'O'},
            {'R', 'P', 'O', 'R', 'A'},
            {'T', 'I', 'O', 'N', ' '}
        };
        String target="TOO";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j]=='T'){
                    if(matrix[i][j+1]=='O' && matrix[i][j+2]=='O'){
                        System.out.println("<"+i+","+j+">");
                        System.out.println("<"+i+","+j+2+">");

                    }
                    if(i+1<matrix.length && i+2<matrix.length){
                    if(matrix[i+1][j]=='O' && matrix[i+2][j]=='O'){
                        System.out.println("<"+i+","+j+">");
                        System.out.println("<"+(i+2)+","+j+">");

                    }}
                }

            }
        }
      
            
        
        
    }
    public static void main(String[] args) {
        print_program();
        //weights();
        zoho();
    }
    
}
