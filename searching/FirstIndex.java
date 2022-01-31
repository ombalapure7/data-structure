package DSA.searching;

public class FirstIndex {

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static int firstOccurrence(int arr[], int n, int x) {
    for (int i = 0; i < n; i++) {
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
  public static int firstOccurrenceBetterRec(int arr[], int low, int high, int x) {
    if (low > high) {
      return -1;
    }

    int mid = (low + high) / 2;
    if (x > arr[mid]) {
      return firstOccurrenceBetterRec(arr, mid + 1, high, x);
    } else if (x < arr[mid]) {
      return firstOccurrenceBetterRec(arr, low, mid - 1, x);
    } else {
      if (mid == 0 || arr[mid - 1] != arr[mid]) {
        return mid;
      } else {
        // The element just found is not the first occurrence
        return firstOccurrenceBetterRec(arr, low, mid - 1, x);
      }
    }
  }

  /*
   * Time Complexity: O(logn)
   * Space Complexity: O(1)
   */
  public static int firstOccurrenceBetterItr(int arr[], int n, int x) {
    int low = 0, high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] > x) {
        high = mid - 1;
      } else if (arr[mid] < x) {
        low = mid + 1;
      } else {
        if (mid == 0 || arr[mid - 1] != arr[mid]) {
          return mid;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    // int arr[] = {5,10,10,15,15};
    int arr[] = { 5, 10, 10, 20, 20 };
    System.out.println("First occurrence - Naive: " + firstOccurrence(arr, arr.length, 15));
    System.out
        .println("First occurrence - Efficient (Recursive): " + firstOccurrenceBetterRec(arr, 0, arr.length - 1, 15));
    System.out.println("First occurrence - Efficient (Iterative): " + firstOccurrenceBetterItr(arr, arr.length, 20));
  }
}
