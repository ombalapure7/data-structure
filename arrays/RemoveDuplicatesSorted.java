package DSA.arrays;

public class RemoveDuplicatesSorted {

  /**
   * @desc Remove duplicates from a sorted array
   * @param arr
   * @param n
   * 
   * Time Complexity: O(n) 
   * Space Complexity: O(n)
   */
  public static void removeDuplicates(int arr[], int n) {
    int temp[] = new int[n];
    temp[0] = arr[0];
    int res = 1;

    for (int i=1; i<n; i++) {
      if (temp[res-1] !=  arr[i]) {
        temp[res++] = arr[i];
      }
    }

    // Print the result
    for (int i=0; i<res; i++) {
      System.out.print(temp[i] + " ");
    }

    System.out.println();
  }

  /*
   * Time Complexity: O(n) 
   * Space Complexity: O(1)
   */
  public static void removeDuplicatesBetter(int arr[], int n) {
    int res = 1;
    for (int i=1; i<n; i++) {
      if (arr[i] != arr[res-1]) {
        arr[res] = arr[i];
        res++;
      }
    }

    // Print the result
    for (int i=0; i<res; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void main(String[] args) {
    int arr[] = {10, 20, 20, 30, 30, 30, 40, 50, 60, 60};
    removeDuplicates(arr, arr.length);

    int newArr[] = {10, 20, 20, 30, 30, 30, 40, 50};
    removeDuplicates(newArr, newArr.length);
  }
}