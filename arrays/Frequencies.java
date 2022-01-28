package DSA.arrays;

public class Frequencies {

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static void frequencyOfElements(int arr[], int n) {
    int freq = 1, i = 1;

    while (i < n) {
      while (i < n && arr[i] == arr[i - 1]) {
        freq++;
        i++;
      }

      System.out.println(arr[i - 1] + " -> " + freq);
      i++;
      freq = 1;
    }

    // NOTE: We compare (i-1)th with ith element
    // In case last element (n-1) is not same as (n-2), such element won't be
    // processed/printed
    if (n == 1 || arr[n - 2] != arr[n - 1]) {
      System.out.println(arr[n - 1] + " -> " + freq);
    }
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static void frequencyOfElementsOther(int[] arr, int n) {
    int freq = 1;

    for (int i = 0; i < n - 1; i++) {
      if (arr[i] == arr[i + 1]) {
        freq++;
      } else {
        System.out.println(arr[i] + " -> " + freq);
        freq = 1;
      }
    }

    if (arr[arr.length - 1] == arr[arr.length - 2]) {
      System.out.println(arr[arr.length - 1] + " -> " + freq);
    }

    if (arr[arr.length - 1] != arr[arr.length - 2]) {
      System.out.println(arr[arr.length - 1] + " -> " + freq);
    }
  }

  public static void main(String[] args) {
    // int arr[] = { 10, 10, 10, 25, 30, 30, 30, 40 };
    int arr[] = { 40, 40, 40, 50, 50 };
    frequencyOfElements(arr, arr.length);
    System.out.println("********************");
    frequencyOfElementsOther(arr, arr.length);
  }
}
