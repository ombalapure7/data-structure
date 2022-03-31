package DSA.recursion;

public class Basics {

  public static void fun1(int n) {
    if (n == 0) {
      return;
    }

    /* This statement is straight forward i.e. 3 2 1 */
    System.out.println(n);
    /* Recursive call */
    fun1(n - 1);
    /* 
      Here the o/p will be 1 2 3
      The callstack will look like this
      - fun1(1)
      - fun1(2)
      - fun1(3)
      So, when the base case condition is satisfied stack
      unwinding will take place and the fun1ctions will be called
      in FILO/LIFO manner hence the o/p => 1 2 3 
    */
    System.out.println(n);
  }

  public static void fun2(int n) {
    if (n == 0) {
      return;
    }

    System.out.println(n);
    fun2(n - 1);
    System.out.println(n);
  }

  public static void main(String[] args) {
    fun1(3);
    System.out.println("####################################");
    fun2(3);
  }
}