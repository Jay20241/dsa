//Selection Sort Algorithm
public class Main {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        selection_Sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selection_Sort(int[] arr){

        
        for(int i=0; i<arr.length; i++){

            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);

            //swap
            int temp = arr[last];
            arr[last] = arr[maxIndex];
            arr[maxIndex] = temp;
            
        }
    }

    private static int getMaxIndex(int[] arr, int start, int end){
        int max = start;
        for(int i = start; i <= end; i++){
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }
}