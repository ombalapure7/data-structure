package DSA.maths;

public class AllDivisors {
  
  
  /* 
  TIME COMPLEXITY: O(n)
  SPACE COMPLEXITY: O(1)
  */
  public static void allDivisorsNaive(int n) {
    for (int i=1; i<=n; i++) {
      if (n % i == 0) {
        System.out.print(i + " ");
      }
    }

    System.out.println();
  }

  /* 
  TIME COMPLEXITY: O(sqrt(n))
  SPACE COMPLEXITY: O(1)
  */
  public static void allDivisorsBetter(int n) {
    // Finding 1 divisor in every pair
    // As divisors are present in pair
    for (int i=1; i*i<=n; i++) {
      if (n % i == 0) {
        System.out.print(i + " ");

        // if n = 25 
        // 1 != 25, so print 25
        if (i != n/i) {
          System.out.print(n/i + " ");
        }
      }
    }

    System.out.println();
  }

  /* 
  TIME COMPLEXITY: O(sqrt(n))
  SPACE COMPLEXITY: O(1)
  */
  public static void allDivisorsBetterSorted(int n) {
    int i = 0;

    // Prints all divisors from 1 (inclusive) to sqrt(n) (exclusive)
    // Prints for i = 1, i = 3
    for (i = 1; i*i<n; i++) {
      if (n % i == 0) {
        System.out.print(i + " ");
      }
    }

    // Prints all divisors from sqrt(n) (inclusive) to n (inclusive)
    // Prints for i = 3, i = 1
    for (; i>=1; i--) {
      if (n % i == 0) {
        System.out.print(n/i + " ");
      } 
    }
  }

  public static void main(String[] args) {
    allDivisorsNaive(6);
    allDivisorsBetter(25);
    allDivisorsBetterSorted(25);
  }
}
