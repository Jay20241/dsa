import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//String is immutable.
//int[] arr = [1,2,3,4,5]
//syso(Arrays.toString(arr))

//overloading - same name, different args

//learn StringBuilder


public class basic {
    int c;
    public static void main(String[] args) {
        //sum();

        for(int i = 100; i < 1000; i++){
            if (isArmStrong(i)) {
                System.out.print(i + " ");
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        //int[] arr = new int[5];
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        System.out.println(arr); //Garbage value.

        System.out.println(list);

        /*
         * if array is empty use
         * int max = Integer.MIN_VALUE;
         * 
         * //FOR INDEX\\
         * int start = 0;
         * int end = arr.length - 1;
         */

        //Integer:
        /*
         * generics in Java
         * int v/s Integer
         * Wrapper classes in Java: are used to treat primitive data-types as object
         */
    }

    static void sum(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a:");
        int num1 = in.nextInt();//5
        System.out.print("Enter b:");
        int num2 = in.nextInt();//6
        int sum = num1+num2;
        System.out.println("Sum is: "+ sum); //11
        System.out.println("Sum is: "+ num1+num2);//56
    }


    static boolean isPrime(int n){
        if (n<=1) {
            return false;
        }
        int c=2;
        while (c*c <= n) {
            if (n%c == 0) {
                return false;
            }
            c++;
        }
        return c*c > n;
    }

    static boolean isArmStrong(int n){
        int original = n;
        int sum = 0;

        while (n>0) {
            int rem = n % 10;
            n = n / 10;
            sum += rem*rem*rem;
        }
            return sum == original;   
    }

    static void multiArgs(String a, String b, int ...v){//when we do not know how many args to give.
        System.out.println(Arrays.toString(v));

        //(String b, String ...a, int ...v) - not possible.
    }
}