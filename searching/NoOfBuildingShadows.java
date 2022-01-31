package DSA.searching;

public class NoOfBuildingShadows {

  /**
   * @desc Find the no. of buildings on which the sunlight falls during a sunset.
   *       The sun sets from the end of the array
   * @param arr
   * @param n
   */
  public static void noOfShadows(int[] arr, int n) {
    int count = 0;
    for (int i = n - 2; i >= 0; i--) {
      if (arr[i] > arr[n - 1]) {
        count++;
      }
    }

    if (count == 0) {
      System.out.println(1);
    } else {
      System.out.println(count + 1);
    }
  }

  public static void main(String[] args) {
    int[] arr = { 7, 4, 8, 2, 9 };
    // int[] arr = {5, 3, 4, 1};
    noOfShadows(arr, arr.length);
  }
}
