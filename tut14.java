/*
 * Java have
 * Class, Interface, Record, Enum, Annotation
 */
public class BinarySearch{
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 5, 25, 50, 100};
        int target = 50;
        int ans = binarySearch(arr, target);
        System.out.println(ans);
    }

    //return index
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        //for order-Agnostic array:
        boolean isAsc;
        if (arr[start] < arr[end]) {
            isAsc = true;
        }else{
            isAsc = false;
        }
        //boolean isAsc = arr[start] < arr[end];

        while (start <= end) {

            //becuase integer have fixed range in java, we cannot execced the range
            int mid = start + ((end - start)/2); 

            if (target < arr[mid]) {
                end = mid - 1;
            }else if (target > arr[mid]) {
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }


    //BS in Infinite array
    static int ans(int[] arr, int target){
        int start = 0;
        int end = 1;

        while(target > arr[end]){
            int temp = end + 1;
            end = end + (end - start + 1)*2;
            start = temp;
        }

        return BSInInfinite(arr, target, start, end);
    }
    static int BSInInfinite(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + ((end - start)/2);
            if(target < arr[mid]){
                end = mid - 1;
            }else if(target > arr[mid]){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}

