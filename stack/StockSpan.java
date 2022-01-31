package DSA.stack;

import java.util.Stack;

public class StockSpan {
  
  // Stock span: when the price of the stock was less than or equal to the price on this specific day.

  /**
   * 
   * @desc    Stock span
   * @param   arr
   * @param   n
   * 
   * COMPLEXITY
   * Time: O(n ^ 2)
   * Space: O(1)
   * 
   * NOTE: The complexity is worst in case the array is sorted
   *    or the stock span kept increasing
   * 
   */
  public static void stockSpan(int arr[], int n) {
    for (int i=0; i<n; i++) {
      // Initially span for every element is 1
      int span = 1;
      // Go from ith to 0th index for each iteration
      for (int j=i-1; j>=0 && arr[j] <= arr[i]; j--) { 
        // If the span/element kept on increasing 
        // Increment the span value
        span++;
      }

      System.out.print(span + " ");
    }
  }

  /**
   * 
   * @desc    Stock span
   * @param   arr
   * @param   n
   * 
   * COMPLEXITY
   * Time: O(n)
   * Space: O(n)
   * 
   */
  public static void stockSpanBetter(int arr[], int n) {
    Stack<Integer> s = new Stack<>() ;
    
    // Process 1st element
    // We are pushing the index of the elemnt
    //    as stock span deals with index rather than the actual array value
    s.add(0);
    System.out.print(1 + " ");

    for(int i=1;i<n;i++){
      while(s.isEmpty() == false && arr[s.peek()] <= arr[i]) {
        // Only greater element's index will be on the stack
        // Pop the top element's index if the current element is smaller
        s.pop();
      }
      
      // If all previous elements are smaller then stock span is: (curr element index + 1)
      // Else the stock span is: (curr element index - prev greater element index)
      int span = s.isEmpty() ? i + 1 : i - s.peek();
      System.out.print(span + " ");
      s.push(i);
    }    
  }

  public static void main(String[] args) {
    int[] arr = new int[]{18,12,13,14,11,16};
    // 1 1 2 3 1 5 
    stockSpan(arr, arr.length);
    System.out.println();
    stockSpanBetter(arr, arr.length);
  }
}
