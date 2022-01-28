package DSA.searching;

import java.util.*;
import java.util.Map.Entry;

public class Test {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        // String str = obj.nextLine();
        // permute(str, "");

        // int n = Integer.parseInt(obj.nextLine());
        // String[] str = obj.nextLine().split(" ");
        // int[] arr =
        // Arrays.asList(str).stream().mapToInt(Integer::parseInt).toArray();

        // if (hasQuadrate(arr, n)) {
        // System.out.println("Yes");
        // } else {
        // System.out.println("No");
        // }

        // int n = Integer.parseInt(obj.nextLine());
        // String[] str = obj.nextLine().split(" ");
        // int[] arr =
        // Arrays.asList(str).stream().mapToInt(Integer::parseInt).toArray();
        // leaders(arr, n);

        // String[] size = obj.nextLine().split(" ");
        // int R = Integer.parseInt(size[0]);
        // int C = Integer.parseInt(size[1]);

        // int[][] mat = new int[R][C];
        // for (int i=0; i<R; i++) {
        // String[] str = obj.nextLine().split(" ");
        // int[] arr =
        // Arrays.asList(str).stream().mapToInt(Integer::parseInt).toArray();
        // int count = 0;
        // for (int j=0; j<C; j++) {
        // mat[i][count++] = arr[j];
        // }
        // }

        // for (int[] arr : mat) {
        // for (int x : arr) {
        // System.out.print(x + " ");
        // }

        // System.out.println();
        // }

        // maxSubjects(mat, R, C);

        // int arr[] = { 10, 20, 30, 40, 50, 60 };
        // binarySearch(arr, 50, 0, arr.length - 1);

        int arr[] = { 5, 10, 10, 20, 20 };
        // System.out.println("First index: " + firstIndex(arr, arr.length, 10));
        System.out.println("Last index: " + lastIndex(arr, 0, arr.length-1, 10));
        obj.close();
    }

    public static int lastIndex(int[] arr, int l, int h, int x) {
        if (l > h) {
            return 0;
        }

        int mid = (l+h)/2;
        if (arr[mid] > x) {
            h = mid - 1;
            return lastIndex(arr, l, h, x);
        } else if (arr[mid] < x) {
            l = mid + 1;
            return lastIndex(arr, l, h, x);
        } else {
            if (mid == arr.length - 1 || arr[mid] != arr[mid+1]) {
                return mid;  
            } else {
                l = mid + 1;
                return lastIndex(arr, l, h, x);
            }
        }
    }

    public static int firstIndex(int[] arr, int n, int x) {
        int l = 0, h = n-1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] > x) {
                h = mid - 1;
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                if (mid == 0 || arr[mid-1] != arr[mid]) {
                    return mid;
                } else {
                    h = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void binarySearch(int[] arr, int x, int l, int h) {
        if (l > h) {
            return;
        }

        int mid = (l + h)/2;
        if (arr[mid] == x) {
            System.out.println("ELEMENT FOUND at: " + mid);
            return;
        } else if (arr[mid] < x) {
            binarySearch(arr, x, mid+1, h);
        } else {
            binarySearch(arr, x, l, mid-1);
        }
    }

    public static void maxSubjects(int[][] mat, int R, int C) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < R; i++) {
            int ones = 0;
            for (int j = 0; j < C; j++) {
                if (mat[i][j] == 1) {
                    ones++;
                }
            }

            map.put(i, ones);
        }

        int max = Integer.MIN_VALUE;
        int row = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                row = entry.getKey();
                break;
            }
        }

        System.out.println(row + ":" + max);
    }

    public static void leaders(int[] arr, int n) {
        String res = "";
        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] <= arr[j]) {
                    isLeader = false;
                    break;
                }
            }

            if (isLeader) {
                res += arr[i] + " ";
            }
        }

        System.out.println(res.substring(0, res.length() - 1));
    }

    public static boolean hasQuadrate(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; i < n && i != j; i++) {
                sum += arr[j];
            }

            if (sum == 0) {
                return true;
            }
        }

        return false;
    }

    public static void permute(String str, String ans) {
        if (str.length() == 0) {
            if (isPalindrome(ans)) {
                System.out.println("YES");
                return;
            } else {
                System.out.println("NO");
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String leftSub = str.substring(0, i);
            String rightSub = str.substring(i + 1);
            String res = leftSub + rightSub;
            permute(res, ans + ch);
        }
    }

    public static boolean isPalindrome(String str) {
        int low = 0, high = str.length() - 1;
        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }

            low++;
            high--;
        }

        return true;
    }
}