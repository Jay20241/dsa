//Quick Sort using Recursion
/*
* In Merge sort, if the array is already sorted, still it goes to the base level to check
* But not in quick sort, Here is the advantage of quick sort, If array is sorted or its subarray is sorted it not goes to base level.  
*/

// Quick sort is not "stable"


// Recurrence relation of quick sort
// T(N) = T(K) + T(N-K-1) + O(N)


/* Hybrid Sorting Alogorithm (TIM Sort) { 

  = Merge Sort + Insersion Sort 
   - Insertion Sort taken because it works well with partially sorted

 Use in-built, internal sorting algorithms
 Java - Collections Framework
 C++  - STL
}*/

public class QuickSort{
    psvm(){

        //Quick Sort
        int[] arr = {5,4,3,2,1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        //Internal Sorting Algorithm
        Arrays.sort(arr); //internally it is using Quick Sort
    }

    static void quickSort(int[] nums, int low, int hi){
        if(low >= hi){
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e - s)/2;
        int pivot = nums[m];

        while(s <= e){

            //If its already sorted it will not swap
            while(nums[s] < pivot){ //good
                s++;
            }
            while(nums[e] > pivot){ //good
                e--;
            }

            if(s <= e){
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        //NOw pivot is at correct index, now sort two halves
        quickSort(nums, low, e);
        quickSort(nums, s, hi);
    }
}