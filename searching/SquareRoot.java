package DSA.searching;

public class SquareRoot {

  /*
   * Time Complexity: O(sqrt(x))
   * Space Complexity: O(1)
   */
  public static int squareRoot(int x) {
    int i = 1;

    while (i * i <= x) {
      i++;
    }

    return i - 1;
  }

  /*
   * Time Complexity: O(log(x))
   * Space Complexity: O(1)
   */
  public static int squareRootBetter(int x) {
    int low = 1, high = x, ans = -1;

    while (low <= high) {
      int mid = (low + high) / 2;
      int midSq = mid * mid;

      if (midSq == x) {
        return mid;
      } else if (midSq > x) {
        high = mid - 1;
      } else {
        low = mid + 1;
        ans = mid;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println("Square Root: " + squareRoot(26));
    System.out.println("Square Root - Efficient: " + squareRootBetter(9));
  }
}
