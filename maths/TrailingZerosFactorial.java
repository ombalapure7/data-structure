package DSA.maths;

public class TrailingZerosFactorial {

    /* Find trailing zeros in a factorial of a no. - naive */
    public static int trailingZerosFactorial(int n) {
        // get factorial of n
        int fact = Factorial.factorialItr(n);
        int zeros = 0;

        // increase counter until no. is divisible by 10
        while (fact % 10 == 0) {
            zeros++;
            fact /= 10;
        }

        return zeros;
    }
    /*
     * NOTE:The issue with this solution is that factorial of 2 digit nos. are huge
     * and such a large no. cannot be stored in an "int" data type.
     * In simple terms - there will be an OVERFLOW issue
     */

    /* Find trailing zeros in a factorial of a no. - efficient */
    public static int trailingZerosFactorialBetter(int n) {
        // If there is a 0 that means there will be a pair of (2, 5)
        // 1 x 2 x 3 x 4 x {5} x ... x {10}
        // NOTE: the no. of 5s will be less than 2s in case of factorial
        // Trailing 0s formula: [n/5] + [n/25] + [n/125] + ...
        int zeros = 0;
        for (int i = 5; i <= n; i *= 5) {
            zeros += zeros + n / i;
        }

        return zeros;
    }

    public static void main(String[] args) {
        System.out.println("No. of trailing zeros - naive: " + trailingZerosFactorial(10));
        System.out.println("No. of trailing zeros - efficient: " + trailingZerosFactorialBetter(100));
    }
}

/*
 * NAIVE
 * -----------
 * Time Complexity: O (n)
 * Space complexity: O (1)
 * 
 * ##########################################
 * 
 * EFFIECITENT
 * -----------
 * Time Complexity: O (log base 5 (n))
 * 5 ^ k <= n
 * k <= log base 5 (n)
 * 
 * Space complexity: O (1)
 */