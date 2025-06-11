//Recursion - Function that call itself.
public class NumbersExample{
    psvm(String[] args){
        printFunction(1);
    }

    static void printFunction(int n){
        if(n==5){ //Base condition
            syso(5);
            return;
        }
        syso(n);
        //this is "tail-recursion", this is the last function call
        printFunction(n + 1); //every function call takes seperate memory in stack. Even it is same function.
    }
    //space complexity is not constant.
    //You can convert any recursive solution into iterations(loops) & vice-versa.

    static int fibonacci(int n){
        //base condition
        if(n < 2){
            return n;
        }

        //here "adding" & "returning" is the extra steps, so it is not a tail-recursion.
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    //BS using recursion.
    //relation :- F(N) = O(1) + F(N/2)
    //O(1) means 1 comparision every time we divide by 2.
    static int binarySearchRecursion(int[] arr, int target, int s, int e){
        if(s > e){
            return -1;
        }

        int mid = s + (e - s) / 2;
        if(arr[mid] == target){
            return mid;
        }
        if(target < arr[mid]){
            //"[return] is IMPORTANT here"
            return binarySearchRecursion(arr, target, s, mid - 1);
        }
        return binarySearchRecursion(arr, target, s + 1, e);  
    }
}