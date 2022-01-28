package DSA.maths;

import java.util.Arrays;

public class PrimeNoTillN {
  
  /* 
  TIME COMPLEXITY: O(n * sqrt(n))
  SPACE COMPLEXITY: O(1)
  */
  public static void primeNoTillN(int n) {
    for (int i=2; i<=n; i++) {
      if (CheckPrime.isPrimeBetter(i)) {
        System.out.print(i + " ");
      }
    }
    
    System.out.println();
  }

  /* 
  TIME COMPLEXITY: O(n * log(logn))
  SPACE COMPLEXITY: O(1)
  */
  public static void sieve(int n) {
    boolean[] isPrime = new boolean[n + 1];
    // Initializes every index of the array as true
    Arrays.fill(isPrime, true);

    for (int i=2; i*i<=n; i++) {
      if (isPrime[i]) {
        for (int j=2*i; j<=n; j+=i) {
          isPrime[j] = false;
        }
      }
    }

    for (int i=2; i<=n; i++) {
      if (isPrime[i]) {
        System.out.print(i + " ");
      }
    }

    System.out.println();
  }
 
  public static void main(String[] args) {
    primeNoTillN(10);
    sieve(10);
  }
}
