//Bubble Sort Algorithm
public class Main {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        bubble_Sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble_Sort(int[] arr){

        boolean isSwap_in_one_step;
        //run the steps n-1 times

        for(int i=0; i<arr.length; i++){
            isSwap_in_one_step = false;
            for(int j=1; j < arr.length - i; j++){
                if(arr[j] < arr[j-1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    isSwap_in_one_step = true;
                }
            }
            if(!isSwap_in_one_step){
                break; //no need to check furthur.
            }
        }
    }
}