package DSA.bst;

public class MinMax {
  
  public static int maxValue(Node root) {
    if (root == null)
      return Integer.MIN_VALUE;

    int res = root.key;
    int lres = maxValue(root.left);
    int rres = maxValue(root.right);
    if (lres > res)
      res = lres;
    if (rres > res)
      res = rres;
    return res;
  }

  public static int minValue(Node root) {
    if (root == null)
      return Integer.MAX_VALUE;

    int res = root.key;
    int lres = minValue(root.left);
    int rres = minValue(root.right);
    if (lres < res)
      res = lres;
    if (rres < res)
      res = rres;
    return res;
  }
}
