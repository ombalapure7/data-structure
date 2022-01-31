package DSA.searching;

public class CountOccurrence {

  /*
   * Time Complexity: O(logn)
   * Space Complexity: O(1)
   */
  public static int countOccurrences(int arr[], int n, int x) {
    // NOTE: We can't just use Binary search to solve the problem in logn time,
    // it won't work in case the x is present in the entire array
    // Eg: x appears n times then we have O(logn + n) =~ O(n)
    int first = FirstIndex.firstOccurrenceBetterItr(arr, n, x);
    if (first == -1) {
      return 0;
    } else {
      // 1 3
      // [ 10,20,20,20,40,40 ]
      // Ans: 3 - 1 + 1
      return LastIndex.lastOccurrenceBetterItr(arr, n, x) - first + 1;
    }
  }

  /*
   * Time Complexity: O(logn)
   * Space Complexity: O(1)
   */
  public static int countOnesBetter(int arr[], int n) {
    int low = 0, high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == 0) {
        low = mid + 1;
      } else {
        if (mid == 0 || arr[mid - 1] == 0) {
          return n - mid;
        } else {
          high = mid - 1;
        }
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    // int arr[] = {10,10,10,10,10};
    int arr[] = { 10, 20, 20, 20, 40, 40 };
    System.out.println("Count occurrences - Efficient: " + countOccurrences(arr, arr.length, 20));

    int newArr[] = { 0, 0, 0, 1, 1, 1, 1, 1 };
    System.out.println("Count 1s - Efficient: " + countOnesBetter(newArr, newArr.length));
  }
}
