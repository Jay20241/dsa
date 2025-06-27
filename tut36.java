public class NQuestions {
    psvm(){
        int n = 4;
        boolean[][] board = new boolean[n][n];
        queens(board, 0);
        System.out.println(queens(board, 0)); //2

        boolean[][] board2 = new boolean[n][n];
        knight(board2, 0, 0, 4);
    }

//======================================================================
//                        N - Queens Problem 
//======================================================================
    static int queens(boolean[][] board, int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        //placing the queen and checking for every row and column
        for(int col = 0; col < board.length; col++){
            // place the queen if it is safe
            if(isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col){
        // check vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]) {
                return false;
            }
        }
        // diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]) {
                return false;
            }
        }
        return true;
    }

    static void display(boolean[][] board){
        for(boolean[] row : board){
            for(boolean[] element : row){
                if(element){
                    System.out.print("Q");
                }
                else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }


//======================================================================
//                        N - Knights Problem 
//======================================================================

    static void knight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        if (row == board.length - 1 && col == board.length) {
            return;
        } //For - OUT OF BOUND 

        if (col == board.length) {
            knight(board, row + 1, 0, knights);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        knight(board, row, col + 1, knights);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        return true;
    }
    // do not repeat yourself, hence created this function
    static boolean isValid(boolean[][] board, int row, int col) { //This function is only checking for "OUT OF BOUND" conditions
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board) {
            for(boolean element : row) {
                if (element) {
                    System.out.print("K");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

//======================================================================
//                    37. Sudoku Solver (Leetcode) 
//======================================================================

//Note: When a choice can affect future answers, use Back-Trecking.

}