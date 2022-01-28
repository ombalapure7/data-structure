package DSA.searching;

public class SearchInfinite {

  /*
   * Time Complexity: O(position) 
   * Space Complexity: O(1)
   */
  public static int searchInInfiniteList(int arr[], int x) {
    int i = 0;

    while (true) {
      if (arr[i] == x) {
        return i;
      }

      // If the current element > x
      // then the element is not present in the array
      if (arr[i] > x) {
        return -1;
      }

      i++;
    }
  }

  /*
   * Time Complexity: O(log(position)) 
   * Space Complexity: O(1)
   */
  public static int searchInInfiniteListBetter(int arr[], int x) {
    if (arr[0] == x) {
      return 0;
    }

    int i = 1;
    while (arr[i] < x) {
      i *= 2;
    }

    if (arr[i] == x) {
      return i;
    }

    return BinarySearch.binarySearchRec(arr, (i / 2) + 1, i, x);
  }

  public static void main(String[] args) {
    int arr[] = { 1, 10, 15, 200 };
    System.out.println("Search element in infinite sized array - Naive: " + searchInInfiniteList(arr, 100));

    int newArr[] = { 1, 10, 15, 20, 40, 60, 80, 100, 200, 500, 1000, 2000, 2001, 2002, 2012, 2013, 3000 , 3156, 6899, 98799,100000 };
    System.out
        .println("Search element in infinite sized array - Efficient: " + searchInInfiniteListBetter(newArr, 500));
  }
}
