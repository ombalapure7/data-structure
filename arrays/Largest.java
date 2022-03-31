package DSA.arrays;

public class Largest {

  /*
   * Time Complexity: O(n) 
   * Space Complexity: O(1)
   */
  public static int largestElementIndex(int arr[], int n) {
    int max = Integer.MIN_VALUE;
    int maxIndex = 0;

    for (int i = 0; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
        maxIndex = i;
      }
    }

    return maxIndex;
  }

  /*
   * Time Complexity: O(n) 
   * Space Complexity: O(1)
   * 
   * Considered as naive approach as we have to traverse the array twice
   */
  public static int secondLargestElementIndex(int arr[], int n) {
    int largestIndex = largestElementIndex(arr, n);
    int res = -1;

    for (int i = 0; i < n; i++) {
      if (arr[i] != arr[largestIndex]) {
        if (res == -1) {
          res = i;
        } else if (arr[i] > arr[res]) {
          res = i;
        }
      }
    } 

    return res; 
  }

  public static int secondLargestSimpler(int arr[], int n) {
    int largest = largestElementIndex(arr, n);
    int secondLargest = Integer.MIN_VALUE;

    for (int i=0; i<n; i++) {
      if (arr[i] > secondLargest && arr[i] != arr[largest]) {
        secondLargest = arr[i];
      }
    }

    return secondLargest;
  }

  /**
   * 
   * @param arr
   * @param n
   * @return
   * 
   * Keep track of the greatest and 2nd greatest in each iteration
   */
  public static int secondLargestSimplerBetter(int arr[], int n) {
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    for (int i=0; i<n; i++) {
      if (arr[i] > largest) {
        secondLargest = largest;
        largest = arr[i];
      }

      if (arr[i] != largest && arr[i] > secondLargest) {
        secondLargest = arr[i];
      }
    }

    return secondLargest;
  }

  /*
   * Time Complexity: O(n) 
   * Space Complexity: O(1)
   * 
   * The TC is same, only difference is that it does single traversal of the array
   */
  public static int secondLargestElementIndexBetter(int arr[], int n) {
    int res = -1, largestIndex = 0;

    for (int i = 1; i < n; i++) {
      if (arr[i] > arr[largestIndex]) {
        res = largestIndex;
        largestIndex = i;
      } else if (arr[i] != arr[largestIndex]) {
        if (res == -1 || arr[i] > arr[res]) {
          res = i;
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int arr[] = { 5, 8, 20, 10 };
    System.out.println("Largest element index: " + largestElementIndex(arr, arr.length));
    System.out.println("Second Largest element index - Naive: " + secondLargestElementIndex(arr, arr.length));
    System.out.println("Second Largest element index - Single pass: " + secondLargestElementIndexBetter(arr, arr.length));
    System.out.println("Second Largest element index - Naive - Simple logic: " + secondLargestSimpler(arr, arr.length));
    System.out.println("Second Largest element index - Better - Simple logic: " + secondLargestSimplerBetter(arr, arr.length));
  }
}
