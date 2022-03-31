package DSA.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {

  public static void main(String[] args) {
    List<Point> list = new ArrayList<>();
    list.add(new Point(1, 2));
    list.add(new Point(10, 3));
    list.add(new Point(8, 10));
    list.add(new Point(0, 1));

    Collections.sort(list);

    for (Point pt : list) {
      System.out.println(pt.x + ", " + pt.y);
    }
  }
}

class Point implements Comparable<Point> {
  int x, y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Point p) {
    return this.x - p.x;
  }
}
