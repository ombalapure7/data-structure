package DSA.matrix;

public class SearchRowColSorted {

  /**
   * A naive approach will be traversing the matrix row by row
   * Time Complexity: O(R*C) 
   * Space Complexity: O(1)
   */

  /*
   * Time Complexity: O(R + C) 
   * Space Complexity: O(1)
   * 
   * Efficient approach: 
   * - Begin from top right corner
   * - If x is found print it
   * - If x is small move to left (row wise search)
   * - If x is greater move down (column wise search)
   */
  public static void searchInSortedRowCol(int mat[][], int R, int C, int x) {
    int i=0, j=C-1;
    
    while (i < R && j >= 0) {
      if (mat[i][j] == x) {
        System.out.println("Element " + x + " found at (" + i +", " + j + ")");
        return;
      } else if (mat[i][j] > x) {
        j--;
      } else {
        i++;
      }
    }

    System.out.println("Element " + x + " no found!");
  }
 
  public static void main(String[] args) {
    int arr[][] = {{10,20,30,40}, {15,25,35,45}, {27,29,37,48}, {32,33,39,50}};
    searchInSortedRowCol(arr, arr.length, arr[0].length, 29);
  }

}
