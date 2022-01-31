package DSA.hashing.hash;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHash {
  int BUCKET;
  ArrayList<LinkedList<Integer>> table;

  MyHash(int b) {
    BUCKET = b;
    table = new ArrayList<LinkedList<Integer>>();

    for (int i = 0; i < b; i++) {
      table.add(new LinkedList<>());
    }
  }

  /**
   * @desc Insert a key in hash table
   * 
   *       COMPLEXITY
   *       Time: O(1)
   *       Space:
   */
  public void insert(int key) {
    int index = key % BUCKET;
    table.get(index).add(key);
  }

  /**
   * @desc Search key in hash table
   * 
   *       COMPLEXITY
   *       Time: O(1)
   *       Space:
   */
  public boolean search(int key) {
    int index = key % BUCKET;
    return table.get(index).contains(key);
  }

  /**
   * @desc Remove a key from hash table
   * 
   *       COMPLEXITY
   *       Time: O(1)
   *       Space:
   */
  public void remove(int key) {
    int index = key % BUCKET;
    table.remove(index);
  }

  public static void main(String[] args) {
    MyHash mh = new MyHash(7);
    mh.insert(10);
    mh.insert(20);
    mh.insert(15);
    mh.insert(7);
    System.out.println("Is key present: " + mh.search(10));
    mh.remove(15);
    System.out.println("Is key present: " + mh.search(15));
  }
}