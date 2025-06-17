//Recursion - arrays 

/* LEARN
 * Linear Search using Recursion
 * Binary Search using Recursion
 */

//No pass by reference in JAVA
// (Q1.) Find whether the array is sorted or not ?

public class tut28 {

    public static void main(String[] args) {
        
    }

    static boolean sortedORNot(int[] arr, int index){
        if (index == arr.length - 1) {
            return true;
        }

        return (arr[index] < arr[index+1]) && (sortedORNot(arr, index+1));
    }

//NOTE: If you modify the array during any recursion call, the furthur calls also have that modifies array.

//(Q2.) LS:

    static boolean lSearch(int[] arr, int target, int index){
        if (index == arr.length) {
            return false;
        }

        return (arr[index] == target) || (lSearch(arr, target, index+1));
    }

    static int findIndexLS(int[] arr, int target, int index){
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }else{
            return findIndexLS(arr, target, index+1);
        }
    }





}