package DSA.linkedlist;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    System.out.println(line);

    String line2 = sc.nextLine();
    String lines[] = line2.split(" ");
    System.out.println(Arrays.toString(lines));

    sc.close();
  }
}
