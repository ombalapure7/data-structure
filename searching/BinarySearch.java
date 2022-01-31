package DSA.searching;

public class BinarySearch {

  /*
   * Time Complexity: O(logn)
   * Space Complexity: O(1)
   */
  public static int binarySearchItr(int arr[], int n, int x) {
    int low = 0, high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == x) {
        return mid;
      } else if (arr[mid] > x) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return -1;
  }

  /*
   * Time Complexity: O(logn)
   * Space Complexity: O(logn)
   */
  public static int binarySearchRec(int arr[], int low, int high, int x) {
    if (low > high) {
      return -1;
    }

    int mid = (low + high) / 2;
    if (arr[mid] == x) {
      return mid;
    } else if (arr[mid] > x) {
      return binarySearchRec(arr, low, mid - 1, x);
    } else {
      return binarySearchRec(arr, mid + 1, high, x);
    }
  }

  public static void main(String[] args) {
    int arr[] = { 10, 20, 30, 40, 50, 60 };
    System.out.println("Binary search index - Iterative: " + binarySearchItr(arr, arr.length, 50));
    System.out.println("Binary search index - Recursive: " + binarySearchRec(arr, 0, arr.length - 1, 50));
  }
}
