//Recursion - arrays 

/* LEARN
 * Linear Search using Recursion
 * Binary Search using Recursion
 */

//No pass by reference in JAVA
// (Q1.) Find whether the array is sorted or not ?

public class tut28 {

    public static void main(String[] args) {
        int[] arr = {2,3,1,4,4,5};
        syso(findAllIndexLS(arr, 4, 0, new ArrayList<>())); // [3,4]
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

    static ArrayList<Integer> findAllIndexLS(int[] arr, int target, int index, ArrayList<Integer> list){
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return findAllIndexLS(arr, target, index+1, list);
        
    }

    //VVI (VERY IMPORTANT) CONCEPT - Return the list without passing in arguments
    static ArrayList<Integer> findAllIndexLS2(int[] arr, int target, int index){
        
        ArrayList<Integer> list = new ArrayList<>();
        
        if (index == arr.length) {
            return list;
        }
        
        //this will contain answer for that particular function call only
        if (arr[index] == target) {
            list.add(index);
        }
        ArrayList<Integer> answerFromBelowCalls = findAllIndexLS2(arr, target, index+1);
        
        list.addAll(answerFromBelowCalls);
        return list;
    }

    //BS in Rotated Sorted Array 
    static int search_BS_Rotated(int[] arr, int target, int s, int e){
        if(s > e){
            return -1;
        }

        int m = s + (e-s)/2;
        if(arr[m] == target){
            return m;
        }

        //case 1
        if(arr[s] <= arr[m]){
            if(target >= arr[s] && target <= arr[m]){
                return search_BS_Rotated(arr, target, s, m - 1);
            }else{
                return search_BS_Rotated(arr, target, m + 1, e);
            }
        }

        //case 2
        if(target >= arr[m] && target <= arr[s]){
            return search_BS_Rotated(arr, target, m + 1, e);
        }

        //case 3
        return search_BS_Rotated(arr, target, s, m - 1);

    }


}