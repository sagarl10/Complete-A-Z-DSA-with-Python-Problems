package JAVA.STRINGS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Strings {

    public static char[] reverse(String str) {
        char arr[] = str.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        // System.out.println(arr);
        return arr;

    }

    public static boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isValidChar(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    public static String removeSplChar(String str) {
        String ans = "";

        for (int i = 0; i < str.length(); i++) {
            if (isValidChar(str.charAt(i))) {
                ans += str.charAt(i);
            }

        }
        return ans;
    }

    public static char toLower(char c) {
        char ans = (char) (c + 'a' - 'A');
        return ans;
    }

    public static char toUpper(char c) {
        char ans = (char) (c - 'a' + 'A');

        return ans;
    }

    public static String replaceWhiteSpaces(String str) {
        return str.replaceAll(" ", "");
    }

    public static String removeDuplicates(String str) {
        Set<Character> seen = new LinkedHashSet<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            seen.add(c);
        }

        for (Character c : seen) {
            ans.append(c);
        }

        return ans.toString();
    }

    public static char[] sort(String str) {
        char arr[] = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    char temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }

            }
        }
        return arr;
    }

    public static void replaceCharWithOccur(String str){
        char arr[]=str.toCharArray();
        char replace='a';
        int count=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==replace){
                arr[i]=(char) (count+'0');
                count++;
            }


        }
        for (char c : arr) {
            System.out.println(c);
            
        }
    }

    public static void firstNonRepeatedChar(String str){

        Map<Character,Integer> m=new LinkedHashMap<>();

        for(int i=0;i<str.length();i++){
            m.put(str.charAt(i),m.getOrDefault(str.charAt(i),0)+1);
        }

        for(Character c:m.keySet()){
            if(m.get(c)==1){
                System.out.println(c);
                break;
            } 
        }
    }

    public static void longestSubStrWithoutRepChar(String str){
        Map<Character,Integer> m=new HashMap<>();

        String longestSubS="";
        int longestSize=Integer.MIN_VALUE;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);

            if(!m.containsKey(c)){
                m.put(c,i);
            }
            else{
                i=m.get(c);
                m.clear();
            }
            if(m.size()>longestSize){
                longestSize=m.size();
                longestSubS=m.keySet().toString();
            }
        }

        System.out.println(longestSize+" "+longestSubS);
    }

    public static void countChar(String str){
        ArrayList list=new ArrayList<>();

        char arr[]=str.toCharArray();
        
        int count=1;
        char start=arr[0];
        for(int i=1;i<arr.length;i++){

            if(arr[i]==start){
                count++;
            }
            else{
                if(count==1){
                    list.add(start);;

                }
                else{
                    list.add(start);
                    list.add(count);

                }
                start=arr[i];
                count=1;
            }
            if(i==arr.length-1){
                if(count==1){
                    list.add(start);;

                }
                else{
                    list.add(start);
                    list.add(count);

                }
            }


        }

        for (Object c : list) {
            System.out.println(c);
            
        }
    }

    public static void main(String[] args) {

         countChar("abccde");
    }

}