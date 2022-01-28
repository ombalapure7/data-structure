package DSA.arrays;

public class Test {

  public static void maxDiff(int arr[], int n) {
    int maxDiff = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int currDiff = arr[j] - arr[i];
        if (currDiff > maxDiff) {
          maxDiff = currDiff;
        }
      }
    }

    System.out.println("MAX DIFF: " + maxDiff);
  }

  public static void maxDiffBetter(int arr[], int n) {
    int maxDiff = arr[1] - arr[0], min = arr[0];
    for (int i = 1; i < n; i++) {
      maxDiff = Math.max(maxDiff, arr[i] - min);
      min = Math.min(min, arr[i]);
    }

    System.out.println("MAX DIFF - BETTER: " + maxDiff);
  }

  public static void freq(int[] arr, int n) {
    int freq = 1, i = 1;

    while (i < n) {
      while (i < n && arr[i] == arr[i - 1]) {
        freq++;
        i++;
      }

      System.out.println(arr[i - 1] + " -> " + freq);
      freq = 1;
      i++;
    }
  }

  public static void maxOnes(int[] arr, int n) {
    int count = 0;

    for (int i = 0; i < n; i++) {
      int currCount = 0;

      for (int j = i; j < n; j++) {
        if (arr[j] == 1) {
          currCount++;
        } else {
          break;
        }
      }

      count = Math.max(count, currCount);
    }

    System.out.println("MAX 1s IN ROW - NAIVE: " + count);
  }

  public static void maxOnesBetter(int[] arr, int n) {
    int count = 0, currCount = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) {
        currCount = 0;
      } else {
        currCount++;
        count = Math.max(count, currCount);
      }
    }

    System.out.println("MAX 1s IN ROW - BETTER: " + count);
  }

  public static void main(String[] args) {
    // int arr[] = { 2, 3, 10, 6, 4, 8, 1 };
    // maxDiff(arr, arr.length);
    // maxDiffBetter(arr, arr.length);

    // int newArr[] = {40, 40, 40, 50};
    // freq(newArr, newArr.length);

    int arr[] = { 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1 };
    maxOnes(arr, arr.length);
    maxOnesBetter(arr, arr.length);

    int water[] = { 5, 0, 6, 2, 3 };
    trapWater(water, water.length);
    trapWaterBetter(water, water.length);
  }

  public static void trapWaterBetter(int[] arr, int n) {
    int quant = 0;

    // left max
    int[] left = new int[n];
    left[0] = arr[0];
    for (int i = 1; i < n; i++) {
      left[i] = Math.max(arr[i], left[i - 1]);
    }

    // right max
    int[] right = new int[n];
    right[n - 1] = arr[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      right[i] = Math.max(arr[i], right[i + 1]);
    }

    for (int i=1; i<n-1; i++) {
      quant += Math.min(left[i], right[i]) - arr[i];
    }

    System.out.println("WATER QUANT: " + quant);
  }

  public static void trapWater(int[] arr, int n) {
    int quant = 0;

    for (int i = 1; i < n - 1; i++) {
      int leftMax = arr[i];
      for (int j = 0; j < i; j++) {
        leftMax = Math.max(leftMax, arr[j]);
      }

      int rightMax = arr[i];
      for (int j = i + 1; j < n; j++) {
        rightMax = Math.max(rightMax, arr[j]);
      }

      quant += Math.min(leftMax, rightMax) - arr[i];
    }

    System.out.println("TRAPPED WATER UNITS: " + quant);
  }
}
