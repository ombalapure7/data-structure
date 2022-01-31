package DSA.arrays;

public class Leaders {

  /**
   * @desc Element which has nothing greater on the right side
   * @param arr
   * @param n
   * 
   *            Time Complexity: O(n^2)
   *            Space Complexity: O(1)
   */
  public static void printLeaders(int arr[], int n) {
    for (int i = 0; i < n; i++) {
      boolean isLeader = true;

      for (int j = i + 1; j < n; j++) {
        // Set flag=true if a smaller element is present on the right
        if (arr[i] <= arr[j]) {
          isLeader = false;
          break;
        }
      }

      // Print if a smaller element is present on the right
      if (isLeader) {
        System.out.print(arr[i] + " ");
      }
    }

    System.out.println();
  }

  /*
   * Time Complexity: O(n)
   * Space Complexity: O(n) - if we wish to print the numbers from left to right
   */
  public static void printLeadersBetter(int arr[], int n) {
    // Store the result and print it backwards
    int tempArr[] = new int[n];
    int counter = 0;

    // Last element is always the leader, incase if no leader
    // exists then the last element is the leader itself
    int currentLeader = arr[n - 1];
    tempArr[0] = currentLeader;
    counter++;

    // Start from the 2nd last index
    for (int i = n - 2; i >= 0; i--) {
      if (currentLeader < arr[i]) {
        // New leader found
        currentLeader = arr[i];
        tempArr[counter++] = currentLeader;
      }
    }

    System.out.println();

    // Print the array from index to 0th index
    for (int i = tempArr.length - counter; i >= 0; i--) {
      System.out.print(tempArr[i] + " ");
    }

    System.out.println();
  }

  public static void main(String[] args) {
    int arr[] = { 7, 10, 4, 10, 6, 5, 2 };
    // 10 6 5 2
    printLeaders(arr, arr.length);

    int newArr[] = { 7, 10, 4, 10, 6, 5, 2 };
    // 10 6 5 2
    printLeadersBetter(newArr, newArr.length);
  }
}
