package DSA.arrays;

public class Majority {

  /**
   * @desc  If x appears > n/2 times then it is a Majority Element
   * @param arr
   * @param n
   * @return
   * 
   * Time Complexity: O(n^2) 
   * Space Complexity: O(1)
   */
  public static int majorityElement(int arr[], int n) {
    for (int i = 0; i < n; i++) {
      int count = 1;
      for (int j = i + 1; j < n; j++) {
        if (arr[i] == arr[j]) {
          count++;
        }
      }

      if (count > 2) {
        return arr[i];
      }
    }

    return -1;
  }

  /**
   * @param arr
   * @param n
   * @return
   * 
   * Time Complexity: O(n) + O(n) =~ O(n) 
   * Space Complexity: O(1)
   * 
   * Moores voting algorithm - works in 2 phase 
   * Phase 1 - finds candidate element
   * Phase 2 - checks if the candidate is a majority element 
   *    (Check if a majority element is present actually)
   */
  public static int majorityElementBetter(int arr[], int n) {
    int res = 0, count = 1;

    // Find a candidate element
    for (int i = 1; i < n; i++) {
      if (arr[res] == arr[i]) {
        count++;
      } else {
        count--;
      }

      if (count == 0) {
        count = 1;
        res = i;
      }
    }

    // Find the majority element
    count = 0;
    for (int i = 0; i < n; i++) {
      if (arr[res] == arr[i]) {
        count++;
      }
    }

    if (count <= n / 2) {
      return -1;
    }

    return arr[res];
  }

  public static void main(String[] args) {
    int arr[] = { 8, 7, 6, 8, 6, 6, 6, 6 };
    System.out.println("Majority Element - Naive: " + majorityElement(arr, arr.length));
    System.out.println("Majority Element - Efficient: " + majorityElementBetter(arr, arr.length));
  }
  
}
