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
    static void AllPaths(String p, int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
    }


}