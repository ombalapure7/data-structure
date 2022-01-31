package DSA.arrays;

public class IsSorted {

  /*
   * Time Complexity: O(n^2) 
   * Space Complexity: O(1)
   */
  public static boolean isSorted(int arr[], int n) {
    if (n == 1) {
      return true;
    }

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[i]) {
          return false;
        }
      }
    }

    return true;
  }

  /*
   * Time Complexity: O(n) 
   * Space Complexity: O(1)
   */
  public static boolean isSortedBetter(int arr[], int n) {
    if (n == 1) {
      return true;
    }

    for (int i = 1; i < n; i++) {
      if (arr[i] < arr[i - 1]) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5};
    System.out.println("Is array sorted - naive: " + isSorted(arr, arr.length));

    int newArr[] = {2, 5, 1, 8, 100};
    System.out.println("Is array sorted - efficient: " + isSortedBetter(newArr, newArr.length));
  }
}
