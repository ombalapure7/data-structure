package DSA.searching;

public class LastIndex {

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static int lastOccurrence(int arr[], int n, int x) {
    for (int i = n - 1; i >= 0; i--) {
      if (arr[i] == x) {
        return i;
      }
    }

    return -1;
  }

  /*
   * Time Complexity: O(logn)
   * Space Complexity: O(logn)
   */
  public static int lastOccurrenceBetterRec(int arr[], int low, int high, int x, int n) {
    if (low > high) {
      return -1;
    }

    int mid = (low + high) / 2;
    if (x > arr[mid]) {
      return lastOccurrenceBetterRec(arr, mid + 1, high, x, n);
    } else if (x < arr[mid]) {
      return lastOccurrenceBetterRec(arr, low, mid - 1, x, n);
    } else {
      if (mid == n - 1 || arr[mid] != arr[mid + 1]) {
        return mid;
      } else {
        return lastOccurrenceBetterRec(arr, mid + 1, high, x, n);
      }
    }
  }

  /*
   * Time Complexity: O(logn)
   * Space Complexity: O(1)
   */
  public static int lastOccurrenceBetterItr(int arr[], int n, int x) {
    int low = 0, high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] > x) {
        high = mid - 1;
      } else if (arr[mid] < x) {
        low = mid + 1;
      } else {
        if (mid == n - 1 || arr[mid] != arr[mid + 1]) {
          return mid;
        } else {
          low = mid + 1;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int arr[] = { 5, 10, 10, 10, 20, 20 };
    System.out.println("Last ocurrence - Naive: " + lastOccurrence(arr, arr.length, 10));
    System.out.println(
        "Last ocurrence - Efficient (Recursive): " + lastOccurrenceBetterRec(arr, 0, arr.length - 1, 10, arr.length));
    System.out.println("Last ocurrence - Efficient (Iterative): " + lastOccurrenceBetterItr(arr, arr.length, 20));
  }
}
