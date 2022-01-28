package DSA.maths;

public class PrimeFactors {
  
  /* 
  TIME COMPLEXITY: O (n^2 * logn)
  */
  public static void primeFactorsNaive(int n) {
    for (int i=2; i<n; i++) {
      if (CheckPrime.isPrime(i)) {
        // Multiple powers of i can divide 'n'
        int x = i;
        while (n % x == 0) {
          System.out.print(i + " ");
          x = x * i;
        }
      }
    }
    System.out.println();
  }

  public static void primeFactorBetter(int n) {
    if (n <= 1) {
      return;
    }

    for (int i=2; i*i<=n; i++) {
      while (n % i == 0) {
        System.out.print(i + " ");
        n /= i;
      }
    }

    if (n > 1) {
      System.out.print(n);
    }

    System.out.println();
  }

  /* 
  TIME COMPLEXITY: O (sqrt(n))
  For composite no. the complexity will be lesser
  */
  public static void primeFactorEvenBetter(int n) {
    if (n <= 1) {
      return;
    }

    while (n % 2 == 0) {
      System.out.print(2 + " ");
      n /= 2;
    }
    
    while (n % 3 == 0) {
      System.out.print(3 + " ");
      n /= 3;
    }

    for (int i=5; i*i<=n; i+=6) {
      while (n % i == 0) {
        System.out.print(i + " ");
        n /= i;
      }

      while (n % (i + 2) == 0) {
        System.out.print(i + " ");
        n /= i;
      }
    }

    if (n > 3) {
      System.out.print(n);
    } 
  }

  public static void main(String[] args) {
    primeFactorsNaive(12);
    primeFactorBetter(12);
    primeFactorEvenBetter(450);
  }
}
