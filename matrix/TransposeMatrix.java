package DSA.matrix;

public class TransposeMatrix {

  /*
   * Time Complexity: O(n^2) 
   * Space Complexity: O(n^2)
   */
  public static void transposeMatrix(int mat[][], int n) {
    // Tranpose: transform R -> C and C -> R
    // Transpose can be done in an n X n matrix so we don't need row and col variables
    int temp[][] = new int[n][n];
    
    // Copy the orginal matrix to temp matrix
    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        temp[i][j] = mat[j][i];
      }
    }

    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        System.out.print(temp[i][j] + " ");
      }
      System.out.println();
    }
  }

  /*
   * Time Complexity: O(n^2) 
   * Space Complexity: O(1)
   * 
   * NOTE: In transpose the diagonal element remains the same
   */
  public static void transposeMatrixBetter(int mat[][], int n) {
    for (int i=0; i<n; i++) {
      for (int j=i+1; j<n; j++) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
      }
    }

    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int arr[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    System.out.println("Boundary Traversal in Matrix - Naive");
    transposeMatrix(arr, arr.length);

    int newArr[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    System.out.println("Boundary Traversal in Matrix - Space Efficient");
    transposeMatrixBetter(newArr, newArr.length);
  }
}


/* 
Boundary Traversal in Matrix - Naive
1 5 9 13
2 6 10 14
3 7 11 15
4 8 12 16
Boundary Traversal in Matrix - Space Efficient
1 5 9 13
2 6 10 14
3 7 11 15
4 8 12 16
*/