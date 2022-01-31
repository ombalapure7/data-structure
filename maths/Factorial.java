package DSA.maths;

public class Factorial {
    
    /* Factorial of a no. - iterative*/
    public static int factorialItr(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int fact = 1;
        for (int i=2; i<=n; i++) {
            fact *= i;
        }

        return fact; 
    }

    /* Factorial of a no. - iterative*/
    public static int factorialRec(int n) {
        // base case 
        if (n == 0) {
            return 1;
        }        

        return n * factorialRec(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Factorial of a number - iterative: " + factorialItr(5));
        System.out.println("Factorial of a number - recursive: " + factorialRec(5));
    }
}

/* 
ITERATIVE 
-----------
Time complexity: O (n)
The loop runs for n-1 times 

Space complexity: O (1)

##########################################

RECURSIVE
-----------
Time complexity: O (n)
The loop runs for n-1 times 

Recurrence exp => T (n) = T (n-1) + O (1)

Space complexity: O (n)
*/
