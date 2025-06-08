//2D ARRAYS

public class RowColMatrix {
    public static void main(String[] args){
        int[][] arr = {
            {10,20,30},
            {15,30,45}
        };
        System.out.println(Arrays.toString(searchIn2D(arr,30)));
    }

    static int[] searchIn2D(int[][] matrix, int target){
        int r = 0;
        int c = matrix.length - 1;

        while(r < matrix.length && c >= 0){
            if(matrix[r][c] == target){
                return new int[]{r, c};
            }
            if(matrix[r][c] > target){
                c--;
            }else{
                r++;
            }
        }
        return new int[]{-1, -1};
    }






    //strict 
    static int[] searchIn2D_Strictly_Sorted(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length; //check is matrix is empty or not ?

        if(rows == 1){
            return simpleBS(matrix, 0, 0, cols-1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;
        //run the loop till the 2 rows are remaining
        while(rStart < (rEnd - 1)){ //while this is true, we have more than 2 rows
            int mid = rStart + (rEnd-rStart)/2;
            if(matrix[mid][cMid] == target){
                return new int[]{mid, cMid};
            }
            if(matrix[mid][cMid] < target){
                rStart = mid;
            }else{
                rEnd = mid;
            }
        }

        //now we have 2 rows
        if(matrix[rStart][cMid] == target){
            return new int[]{rStart, cMid};
        }
        if(matrix[rStart + 1][cMid] == target){
            return new int[]{rStart + 1, cMid};
        }


        //now search in 1st half
        if(target <= matrix[rStart][cMid - 1]){
            simpleBS(matrix, rStart, 0, cMid - 1, target);
        }
        //now search in 2nd half
        if(target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]){
            simpleBS(matrix, rStart, cMid + 1, cols - 1, target);
        }
        //now search in 3rd half
        if(target <= matrix[rStart + 1][cMid - 1]){
            simpleBS(matrix, rStart + 1, 0, cMid - 1, target);
        }
        //now search in 4th half
        else{
            simpleBS(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }

        return new int[]{-1, -1};
    }

    static int[] simpleBS(int[][] matrix, int row, int cStart, int cEnd ,int target){
        while(cStart <= cEnd){
            int mid = cStart + (cEnd-cStart)/2;

            if(matrix[row][mid] == target){
                return new int[]{row, mid};
            }
            if(matrix[row][mid] > target){
                cEnd = mid - 1;
            }else{
                cStart = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}