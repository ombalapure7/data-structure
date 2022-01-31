package DSA.searching;

public class SearchInRotated {

  /**
   * @desc Find an element in a rotated array using Binary Search
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(log(n))
   *         Space: O(1)
   * 
   *         Approach:
   *         - Find if the left half is sorted, check if arr[mid] > arr[low]
   *         - Now check if "x" is in range on the left half i.e. from arr[low] to
   *         arr[mid]
   *         - Do the same for the right half
   */
  public static int findInRotated(int arr[], int n, int x) {
    int low = 0, high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == x) {
        return mid;
      }

      // Check whether left/right half is sorted
      if (arr[low] < arr[mid]) {
        if (x >= arr[low] && x < arr[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        if (x > arr[mid] && x <= arr[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int arr[] = { 10, 20, 40, 60, 5, 8 };
    System.out.println("Search in rotated array: " + findInRotated(arr, arr.length, 5));
  }
}
