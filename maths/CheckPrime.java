package DSA.maths;

public class CheckPrime {
    
    /* Check if n is prime - naive */
    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        
        for (int i=2; i<n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /* Check if n is prime - efficient */
    // divisor always appear in pair 
    // 30: (1, 30) (2, 15) (3, 10)
    // 65: (1, 65) (5, 13)
    // 25: (1, 25) (5, 5)
    /* 
    If (x, y) is a pair 
    x * y = n
    And if x <= y
    x * x <= n
    x <= Math.sqrt(2)
    */
    public static boolean isPrimeBetter(int n) {
        if (n == 1) {
            return false;
        }
        
        // Finding 1 divisor in every pair
        for (int i=2; i*i<=n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /* Check if n is prime - more efficient */
    public static boolean isPrimeEvenBetter(int n) {
        if (n == 1) {
            return false;
        }

        if (n == 2 || n == 3) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i=5; i*i<=n; i+=6) {
            if (n % i == 0 || n % (i+2) == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Is n a prime - naive: " + isPrime(2));
        System.out.println("Is n a prime - efficient: " + isPrimeBetter(4)); 
        System.out.println("Is n a prime - more efficient: " + isPrimeEvenBetter(2));
    }
}

/*
NAIVE
-----------
Time Complexity: O (n)
Space complexity: O (1)

##########################################

EFFIECITENT
-------------
Time Complexity: O (Math.sqrt(n))
Space complexity: O (1)

##########################################

MORE EFFIECITENT
------------------
Time Complexity: O (log base 6 (n))
Three times faster than efficient
Space complexity: O (1)

*/