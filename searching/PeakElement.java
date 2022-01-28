package DSA.searching;

public class PeakElement {

  /**
   * @desc Find a peak element - i.e. element bigger that it's neighbours
   * @param arr
   * @param n
   * @return
   * 
   *         Time Complexity: O(n)
   *         Space Complexity: O(1)
   */
  public static int peakElement(int arr[], int n) {
    if (n == 1) {
      return arr[0];
    }

    // 1st element greater than 2nd one is a peak element
    if (arr[0] >= arr[1]) {
      return arr[0];
    }

    // (n-1)th element greater than (n-2)th element is a peak element
    if (arr[n - 1] >= arr[n - 2]) {
      return arr[n - 1];
    }

    for (int i = 1; i < n - 1; i++) {
      if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
        return arr[i];
      }
    }

    return 1;
  }

  /**
   * @desc Find a peak element - i.e. element bigger that it's neighbours
   * @param arr
   * @param n
   * @return
   * 
   *         Time Complexity: O(log(n))
   *         Space Complexity: O(1)
   * 
   *         Approach:
   *         - Find a mid and check if the element before/after are greater
   *         - If element on left is bigger then search in the left half
   *         - If element on rigth is bigger then search in the right half
   */
  public static int peakElementBetter(int arr[], int n) {
    int low = 0, high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if ((mid == 0 || arr[mid - 1] <= arr[mid])
          && (mid == n - 1 || arr[mid] >= arr[mid + 1])) {
        return arr[mid];
      }

      if (mid > 0 && arr[mid - 1] >= arr[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int arr[] = {5, 10, 11, 12, 20, 12};
    System.out.println("Peak element in an array - Naive: " + peakElement(arr, arr.length));
    System.out.println("Peak element in an array - Better: " + peakElementBetter(arr, arr.length));
  }
}
