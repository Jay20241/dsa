//Merge Sort - Divide & Conquer recursion
// Time - O(N*log2(N))
// Space - O(N)

/*
 * 1. Divide array into 2 parts.
 * 2. Get both the part sorted via recursion.
 * 3. Merge two sorted parts.
 */

public class MergeSort{
    psvm(){
        int[] arr = {5,4,3,2,1};
        arr = mergeSort(arr); //original array is updated.
        syso(Arrays.toString(arr));

        int[] arr2 = {5,4,3,2,1};
        int[] ans = mergeSort(arr2); //original array is not updated.
        syso(Arrays.toString(arr2)); // {5,4,3,2,1}
        syso(Arrays.toString(ans));  // {1,2,3,4,5}


        //In-place
        int[] arrIn = {5,4,3,2,1};
        mergeSortInPlace(arrIn, 0, arrIn.length); //original array is updated.
        syso(Arrays.toString(arrIn));
    }

    static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return mergeArrays(left, right);
    }

    private static int[] mergeArrays(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        //It may be possible that one of the arrays is still remaining
        while(i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }

//Merge Sort in-place
        static void mergeSortInPlace(int[] arr, int s, int e){
            if(e - s == 1){
                return;
            }

            int mid = s + (e-s)/2;

            mergeSortInPlace(arr, s, mid);
            mergeSortInPlace(arr, mid, e);

            mergeArraysInPlace(arr, s, mid, e);
    }

    private static void mergeArraysInPlace(int[] arr, int s, int m, int e){
        int[] mix = new int[e - s];

        int i = s;
        int j = m;
        int k = 0;

        while(i < m && j < e){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        //It may be possible that one of the arrays is still remaining
        while(i < m){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while(j < e){
            mix[k] = arr[j];
            j++;
            k++;
        }
        
        //Now copy the array
        for(int l = 0; l < mix.length; l++){
            arr[s+l] = mix[l]
        }
    }




}