package DSA.arrays;

import java.util.Arrays;

public class Reverse {
  
  /* 
  Time Complexity: O(n)
  Space Complexity: O(n)
  */
  public static void reverse(int arr[], int n) {
    int newArr[] = new int[n];

    int counter = 0;
    for (int i=arr.length-1; i>=0; i--) {
      newArr[counter++] = arr[i];
    } 

    System.out.println("Reversed Array: " + Arrays.toString(newArr));
  }

  /* 
  Time Complexity: O(n)
  Space Complexity: O(1)

  The loop runs n/2 times, but ignore constant terms hence TC is O(n)
  */
  public static void reverseBetter(int arr[], int n) {
    int low = 0, high = n-1;
    while (low < high) {
      int temp = arr[low];
      arr[low] = arr[high];
      arr[high] = temp;

      low++;
      high--;
    }

    System.out.println("Reversed Array - Efficient: " + Arrays.toString(arr));
  }

  public static void main(String[] args) {
    int arr[] = {10, 5, 7, 30};
    int newArr[] = arr;
    reverse(arr, arr.length);
    reverseBetter(newArr, newArr.length);
  }
}
