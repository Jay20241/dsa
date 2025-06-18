public class Triangle{
    psvm(){
        triangle(4, 0);
        triangle2(4, 0);

        int[] arr = {4,3,2,1};
        bubble(arr, arr.length - 1, 0);
        selection(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    /*
     **** 
     *** 
     **
     *
     */
    static void triangle(int row, int col){
        if(row == 0){
            return;
        }

        if(col < row){
            System.out.print("*");
            triangle(row, col+1);
        }
        else{
            System.out.println();
            triangle(row-1, 0);
        }
    }


    //Normal Triangle
    static void triangle2(int row, int col){
        if(row == 0){
            return;
        }

        if(col < row){
            triangle2(row, col+1);
            System.out.print("*");
        }
        else{
            triangle2(row-1, 0);
            System.out.println();
        }
    }



    //Bubble sort
    static void bubble(int[] arr, int r, int c){
        if(r == 0){
            return;
        }

        if(c < r){

            if(arr[c] > arr[c+1]){
                //swap
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            bubble(r, c+1);
        }
        else{
            bubble(r-1, 0);
        }
    }


    //Selection Sort
    static void selection(int[] arr, int r, int c, int max){
        if(r == 0){
            return;
        }

        if(c < r){

            if(arr[c] > arr[max]){
                selection(arr, r, c+1, c);
            }else{
                selection(arr, r, c+1, max);
            }
        }
        else{
            int temp = arr[max];
            arr[max] = arr[r-1];
            arr[r-1] = temp;
            selection(arr, r-1, 0, 0);
        }
    }


}