//Recursion - Level 1

public class Nto1{
    psvm(String[] args){
        fun(5);    // 1 2 3 4 5
        funRev(5); // 5 4 3 2 1
    }

    static void funRev(int n){
        if(n==0){
            return;
        }
        syso(n);
        fun(n-1);
    }


    static void fun(int n){
        if(n==0){
            return;
        }
        fun(n-1);
        syso(n);
    }


    static int factorial(int n){
        if(n <= 1){
            return 1;
        }
        return n * factorial(n-1);
    }


    static int sumOfDigits(int n){
        if(n == 0){
            return 0;
        }
        return sumOfDigits(n%10) + sumOfDigits(n/10);
    }
    static int productOfDigits(int n){
        if(n%10 == n){ //if only one digit is remaining
            return n;
        }
        return productOfDigits(n%10) * productOfDigits(n/10);
    }

//reverse The Number - method 1
    static int rev=0;
    static void reverseTheNumber1(int n){
        //way - 1 
        if(n == 0){
            return;
        }
        int rem = n % 10;
        rev = rev * 10 + rem;
        reverseTheNumber1(n / 10);
    }

//reverse The Number - method 2
    
    static int reverseTheNumber2(int n){
        //way - 2
        //somtimes you might need some additional variables in the argument
        //in that case, make another helper function
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n, digits);
    }
    private static int helper(int n, int digits){
        if(n%10 == n){ //if only one digit is remaining
            return n;
        }
        int rem = n % 10;
        return rem * (int)(Math.pow(10, digits - 1)) + helper(n/10, digits - 1);
    }

    static boolean palindrome(int n){
        return n == reverseTheNumber2(n);
    }

    // (Q.) - Count no. of zeros in a number
    static int count(int n){
        return help(n, 0);
    }
    private static int help(int n, int c){
        if(n == 0){
            return c;
        }
        int rem = n % 10;
        if(rem == 0){
            return help(n / 10, c + 1);
        }else{
            return help(n / 10, c);
        }
    }
}