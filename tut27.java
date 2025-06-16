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
}