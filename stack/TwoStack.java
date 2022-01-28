package DSA.stack;

public class TwoStack {
  
  private int arr[], cap, top1, top2;

  public TwoStack(int n) {
    cap = n;
    top1 = -1;
    top2 = cap;
    arr = new int[n];
  }

  public void push1(int x) {
    if (top1 < top2 - 1) {
      top1++;
      arr[top1] = x;
    }
  }

  public void push2(int x) {
    if (top1 < top2 - 1) {
      top2--;
      arr[top2] = x;
    }
  }

  public int pop1() {
    if (top1 >= 0) {
      int x = arr[top1];
      top1--;
      return x;
    } else { 
      System.out.println("Stack Underflow"); 
      System.exit(1); 
    } 

    return 0;
  }

  public int pop2() {
    if (top2 < cap) {
      int x = arr[top2];
      top2++;
      return x;
    } else {
      System.out.println("Stack Underflow"); 
      System.exit(1); 
    }

    return 0;
  }

  /**
   * @param args
   * 
   * Approach:
   * - Instead of dividing the array in half and insertion elements from left
   *   - Insert element in 1st stack from left
   *   - Insert element in 2nd stack from right
   */

  public static void main(String[] args) {
    TwoStack ts=new TwoStack(5); 
    ts.push1(5); 
    ts.push2(10); 
    ts.push2(15); 
    ts.push1(11); 
    ts.push2(7); 
    System.out.println("Popped element from stack1 is: " + ts.pop1()); 
    ts.push2(40); 
    System.out.println("Popped element from stack2 is: " + ts.pop2());  
  }
}
