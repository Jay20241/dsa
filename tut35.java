// Maze and BackTracking

public class Maze{
    psvm(){

    }

    //1. Count the number of possible paths to reach from one to another end
    static int count(int r, int c){
        if(r == 1 || c == 1){ //Border conditions
            return 1;
        }

        int down = count(r-1, c);
        int right = count(r, c-1);

        return down + right;
    }

    //2. Print all the possible paths to reach from one to another end
    static void allPaths(String p, int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r > 1){
            allPaths(p + 'D', r-1, c);
        }
        if(c > 1){
            allPaths(p + 'R', r, c-1);
        }
    }

    static ArrayList<String> allPaths_return(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if(r > 1){
            list.addAll(allPaths_return(p + 'D', r-1, c));
        }
        if(c > 1){
            list.addAll(allPaths_return(p + 'R', r, c-1));
        }

        return list;
    }

    //3. Also include diagonal paths
    static ArrayList<String> allPathsDiagonal_return(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if(r > 1 && c > 1){
            list.addAll(allPathsDiagonal_return(p + 'D', r-1, c-1));//Diagonal
        }
        if(r > 1){
            list.addAll(allPathsDiagonal_return(p + 'V', r-1, c));//Vertical
        }
        if(c > 1){
            list.addAll(allPathsDiagonal_return(p + 'H', r, c-1));//Horizontal
        }
        return list;
    }


    //4. Maze with Obstacles
    //maze is starting from (0,0)
    static void paths_with_restrictions(String p, boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        if(maze[r][c] == false){ //obstacle
            return;
        }

        if(r < maze.length - 1){
            paths_with_restrictions(p + 'D', maze, r+1, c);
        }
        if(c < maze[0].length - 1){
            paths_with_restrictions(p + 'R', maze, r, c+1);
        }
    }

    // All Paths : Left, Right, Up, Down - all directions are allowed :-

    //It will cause infinite recursion => Stack Overflow
    //Solution - DO NOT MOVE TO THE SAME PATH FROM WHERE WE ARRIVED
    //Solution - All the cells that are visited, mark as false. => So it will treat like obstacle.

    //But there is also an issue with this solution.
    //The maze cells marked as false will be false for future recursion calls. Because 2D or normal Array is mutuable.
    //So, solution is => while moving back, restore the maze as it was.
    //This is known as "BACK-TRECKING".

    /* static void paths_with_allDirections(String p, boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        if(maze[r][c] == false){ //obstacle
            return;
        }

        
        if(r < maze.length - 1){
            paths_with_allDirections(p + 'D', maze, r+1, c);
        }
        if(c < maze[0].length - 1){
            paths_with_allDirections(p + 'R', maze, r, c+1);
        }

        if(r > 0){
            paths_with_allDirections(p + 'U', maze, r-1, c);
        }
        if(c > 0){
            paths_with_allDirections(p + 'L', maze, r, c-1);
        }
    }*/

   //Back-Trecking :-
   static void paths_with_allDirections(String p, boolean[][] maze, int r, int c){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        if(maze[r][c] == false){ //obstacle
            return;
        }

        //I am considering this block in my path
        maze[r][c] = false; //mark as false
        
        if(r < maze.length - 1){
            paths_with_allDirections(p + 'D', maze, r+1, c);
        }
        if(c < maze[0].length - 1){
            paths_with_allDirections(p + 'R', maze, r, c+1);
        }

        if(r > 0){
            paths_with_allDirections(p + 'U', maze, r-1, c);
        }
        if(c > 0){
            paths_with_allDirections(p + 'L', maze, r, c-1);
        }
        
        //This line execute when the function will be over
        // restore the changes 
        maze[r][c] = true;

        //back-treking - Make the change & reverse that change when work is done
    }

    // 6. Print Matrix and Paths
    static void matrix_paths_with_allDirections(String p, boolean[][] maze, int r, int c, int[][] path, int step){
        if(r == maze.length - 1 && c == maze[0].length - 1){
            
            path[r][c] = step; //last step reached

            for(int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(maze[r][c] == false){ //obstacle
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;

        if(r < maze.length - 1){
            matrix_paths_with_allDirections(p + 'D', maze, r+1, c, path, step + 1);
        }
        if(c < maze[0].length - 1){
            matrix_paths_with_allDirections(p + 'R', maze, r, c+1, path, step + 1);
        }

        if(r > 0){
            matrix_paths_with_allDirections(p + 'U', maze, r-1, c, path, step + 1);
        }
        if(c > 0){
            matrix_paths_with_allDirections(p + 'L', maze, r, c-1, path, step + 1);
        }
        
        maze[r][c] = true;
        path[r][c] = 0;

    }
}