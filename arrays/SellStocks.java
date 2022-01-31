package DSA.arrays;

public class SellStocks {

  /**
   * @desc Buy and sell stocks to get max profit
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n^2)
   *         Space: O(n)
   */
  public static int maxProfitNaive(int[] price, int start, int end) {
    if (end <= start) {
      return 0;
    }

    int profit = 0;

    for (int i = start; i < end; i++) {
      for (int j = i + 1; j <= end; j++) {
        if (price[j] > price[i]) {
          int currProfit = price[j] - price[i] + maxProfitNaive(price, start, i - 1)
              + maxProfitNaive(price, j + 1, end);

          profit = Math.max(currProfit, profit);
        }
      }
    }

    return profit;
  }

  /**
   * @desc Buy and sell stocks to get max profit
   * @param arr
   * @param n
   * @return
   * 
   *         COMPLEXITY
   *         Time: O(n)
   *         Space: O(1)
   */
  public static int maxProfitBetter(int[] price, int n) {
    int profit = 0;

    for (int i = 0; i < n - 1; i++) {
      if (price[i + 1] > price[i]) {
        profit += price[i + 1] - price[i];
      }
    }

    return profit;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 5, 3, 8, 12 };
    // op: 13
    System.out.println("Stock buy/sell - Naive: " + maxProfitNaive(arr, 0, arr.length - 1));
    System.out.println("Stock buy/sell - Better: " + maxProfitBetter(arr, arr.length));
  }
}
