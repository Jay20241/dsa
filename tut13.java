//import java.util.Arrays;

public class tut13 {

    public static void main(String[] args) {
        
    int[] nums={2,23,54,56,48,15,23};
    int target=56;
    int ans=linearSearch(nums, target);

    System.out.println(ans);

    String name="Kunal";
    char c = 'u';
    boolean f = searchInString(name, c);
    System.out.println(f);

    }

    static int linearSearch(int[] arr, int target){
        if (arr.length==0) {
            return -1;
        }
        
            for(int i=0; i<arr.length; i++){
                //int element = arr[i];
                if (arr[i] == target) {
                    return i;
                }
            }
        return -1;
        //return Integer.MAX_VALUE; //if you want to return element
        //because -1 can be the element of the array.
    }

    static boolean searchInString(String str, char target){
        if(str.length()==0){
            return false;
        }

        // for(int i=0; i<str.length(); i++){
        //     if(target == str.charAt(i)){
        //         return true;
        //     }
        // }

        for (char ch : str.toCharArray()) {
            if (ch==target) {
                return true;
            }
            
        }
        return false;

    }

    //LEETCODE QUESTION
    //Find the no. of numbers that have even number of digit.
     static int findEvenDigits(int[] arr1){
        int count=0;

        for (int i : arr1) {
            //MAKE THE NEG NO. TO POS
            if (i<0) {
                i = i*(-1);
            }
            if (i==0) {             // why ?
                return 1;           // why ?
            }                       //  why ?
            String s = i+"";
            if (s.length()%2 == 0) {
                count++;
            }
        }
        return count;
     }

     static int findEvenDigits2(int[] arr1){
        int count=0;
        int c=0;

        for (int i : arr1) {
            //MAKE THE NEG NO. TO POS
            if (i<0) {
                i = i*(-1);
            }
            if (i==0) {
                return 1;
            }

            while (i>0) {
                c++;
                i=i/10;
            }
            if (c%2 == 0) {
                count++;
            }
        }
        return count;
     }

     //search in 2D array
     static int[] search2Darray(int[][] arr, int target){
        for (int row=0; row<arr.length; row++){
            for (int col=0; col<arr[row].length; col++){
                if(arr[row][col] == target){
                    return new int[]{row,col};
                }
            }
        }
        return new int[]{-1,-1};
     }

     static int maxIn2D(int[][] arr){
        int max = Integer.MIN_VALUE;
        for(int[] ints : arr){
            for(int i: ints){
                if(i>max){
                    max = i;
                }
            }
        }
        return max;
     }

}



//1295. Find Numbers with Even Number of Digits
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int ele: nums){
            if(even(ele)){
                count++;
            }
        }
        return count;
    }

    //Ways to count the no. of digits in number
    //1. Count the no. of digits simply
    //2. Convert to String -> take length
    public boolean even(int ele){
        int numberOfDigits = shortCutToFindDigits(ele);
        return numberOfDigits%2 == 0;
    }

    public int digits(int num){
        if(num<0){
            num = num * -1;
        }
        if(num == 0){
            return 1;
        }
        int count = 0;
        while(num > 0){
            count++;
            num = num/10;
        }
        return count;
    }

    public int shortCutToFindDigits(int num){
        if(num<0){
            num = num * -1;
        }
        if(num == 0){
            return 1;
        }
        return (int)(Math.log10(num)) + 1;
    }
}