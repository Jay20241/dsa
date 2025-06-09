//Cyclic Sort Algorithm - When range of 1 to N numbers is given. 
public class Main {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        cyclic_Sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclic_Sort(int[] arr){

        int i = 0;
        while(i < arr.length){

            int correctIndex = arr[i] - 1;
            if(arr[i] != arr[correctIndex]){
                swap(arr, i, correctIndex);
            }else{
                i++;
            }
        }
    }

    private static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}