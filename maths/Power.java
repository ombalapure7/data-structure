package DSA.maths;

public class Power {

  /* 
  TIME COMPLEXITY: O(n)
  SPACE COMPLEXITY: O(1)
  */
  public static int powerNaive(int x, int n) {
    int res = 1;
    for (int i=0; i<n; i++) {
      res *= x;
    }

    return res;
  }

  /* 
  TIME COMPLEXITY: O(logn)
  SPACE COMPLEXITY: O(1)

  Recurrence equation: T(n) = T(n/2) + O(1)
  Height of the tree will be log(n) and at each level constant work is being done
  So, TC is O(logn)
  */
  public static int powerRecursive(int x, int n) {
    if (n == 0) {
      return 1;
    }

    int temp = powerRecursive(x, n/2);
    temp = temp * temp;

    if (n % 2 == 0) {
      return temp;
    } else {
      return temp * x;
    }
  }

  public static void main(String[] args) {
    System.out.println("Power - naive: " + powerNaive(2, 3));
    System.out.println("Power - recursive: " + powerRecursive(2, 3));
  }
}
