//Maths for DSA

//Please refer: 
//https://www.geeksforgeeks.org/java/java-program-to-find-lcm-of-two-numbers/

static boolean prime(int n){
    if(n<2){
        return false;
    }
    int c = 2;
    while(c*c <= n){
        if(n % c == 0){
            return false;
        }
        c++;
    }
    return true;
}

//==================================================================================================================
//Find all prime numbers till number n.
//SIEVE METHOD
/**
 * in main make - boolean[] primes = new boolean[n+1]; intialy when we don't intialize it, all values are "false" in this array
 */

//now false in array means number is prime
static void sieve(int n, boolean[] primes){
    for(int i = 2; i*i <= n; i++){
        if(!prime[i]){
            for(int j = i*2; j<=n; j+=i){
                prime[j] = true;
            }
        }
    }
    for(int i = 2; i<=n; i++){
        if(!prime[i]){
            syso(i + " ");
        }
    }
}
//==================================================================================================================


// Square Root of a number using Binary Search
in_main(){
    int n = 40;
    int precision = 3; //till 3 decimal points
    syso(sqrt(n, precision));

    //for pretty printing
    System.out.printf("%.3f", sqrt(n, precision));
}

//Time: O(log(n))
static double sqrt(int n, int precision){
    int s = 0;
    int e = n;

    double root = 0.0;
    
    while(s <= e){
        int m = s + (e-s)/2;

        if(m*m == n){
            return m;
        }
        if(m*m > n){
            e = m - 1;
        }else{
            s = m + 1;
        }
    }

    double incr = 0.1;
    for(int i = 0; i < p; i++){

        while(root*root <= n){
            root += incr;
        }

        root -= incr;
        incr /= 10;
    }


    return root;
}

//SQRT using Newton - Raphson formula:
static double sqrt_NR(double n){
    double x = n;
    double root;
    while(true){
        root = 0.5 * (x + (n/x));

        if(Math.abs(root - x) < 0.5){
            break;
        }

        x = root;
    }
    return root;
}

//Factors:
//both time and space : O(sqrt(n))
static double factors(int n){

    ArrayList<Integer> list = new ArrayList<>();

    for(int i = 1; i <= Math.sqrt(n); i++){
        if(n%i == 0){
            if(n/i == i){
                syso(i + " ");
            }else{
                syso(i + " ");
                list.add(n/i);
            }
        }
    }
    for(int i = list.size() - 1; i >= 0; i--){
        syso(list.get(i) + " ");
    }
}

//GCD / HCF using Euclidian Algo
static int gcd(int a, int b){
    if(a == 0){
        return b;
    }
    return gcd(b % a, a);
}

//LCM
static int lcm(int a, int b){
    return (a * b) / gcd(a, b);
}

// a * b = gcd(a, b) * lcm(a, b) ] - always