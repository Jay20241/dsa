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
}