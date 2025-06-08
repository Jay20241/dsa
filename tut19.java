//Insertion Sort Algorithm
public class Main {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        insertion_Sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void insertion_Sort(int[] arr){

        for(int i = 0; i <= arr.length - 2; i++){
           
            for(int j = i + 1; j > 0; j--){

                if(arr[j] < arr[j-1]){

                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;

                }
                else{
                    break;
                }
            }  
        }
    }
}