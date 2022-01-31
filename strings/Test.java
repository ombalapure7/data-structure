package DSA.strings;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        // String userInput = obj.nextLine();
        // reverseRemove(userInput);
        // reverse(userInput);

        // String[] userInput = obj.nextLine().split(" ");
        // removeSubstringChars(userInput[0], userInput[1]);
        // removeSpaces(userInput);

        // String userInput = obj.next();
        // System.out.println(userInput.charAt(0) +"" +userInput.charAt(2));
        // removeSubstringChars(userInput[0], userInput[1]);

        // String[] userInput = obj.nextLine().split(" ");

        // if (isSubstring(userInput[0], userInput[1])) {
        // System.out.println("yes");
        // } else {
        // System.out.println("no");
        // }

        // if (matchStrings(userInput[0], userInput[1])) {
        // System.out.println("yes");
        // } else {
        // System.out.println("no");
        // }

        // String str = obj.nextLine();
        // swapEvenOdd(str);
        // reverseString(str);

        obj.close();

        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        bubbleSort(arr);
    }

    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        System.out.println(Arrays.toString(arr));
    }

    public static void reverseString(String str) {
        String res = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i) + "-";
        }

        System.out.println(res.substring(0, res.length() - 1));
    }

    public static void swapEvenOdd(String str) {
        StringBuilder res = new StringBuilder(str);

        for (int i = 0; i < str.length() - 1; i += 2) {
            char even = res.charAt(i + 1);
            char odd = res.charAt(i);

            res.setCharAt(i, even);
            res.setCharAt(i + 1, odd);
        }

        System.out.println(res);
    }

    public static boolean matchStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int i = 0, j = 0;
        int m = s2.length(), n = s1.length();

        while (i < n && j < m) {
            if (s1.charAt(i) != s2.charAt(j)) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }

    public static boolean isSubstring(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();
        int j = 0;

        for (int i = 0; i < n && j < m; i++) {
            if (str.charAt(i) == pattern.charAt(j)) {
                j++;
            }
        }

        return m == j;
    }

    public static void removeSpaces(String[] str) {
        String res = "";
        for (String word : str) {
            res += word;
        }

        System.out.println(res);
    }

    public static void removeSubstringChars(String str, String pattern) {
        String res = "";
        int n = str.length();
        int m = pattern.length();
        int j = 0;

        for (int i = 0; i < n && j < m; i++) {
            if (str.charAt(i) == pattern.charAt(j)) {
                j++;
            } else {
                res += str.charAt(i);
            }
        }

        if (res == "") {
            System.out.println("-1");
        } else {
            System.out.println(res);
        }
    }

    public static void reverse(String str) {
        StringBuilder res = new StringBuilder(str);

        int low = 0;
        int high = res.length() - 1;

        while (low < high) {
            char lChar = res.charAt(low);
            char rChar = res.charAt(high);

            res.setCharAt(low, rChar);
            res.setCharAt(high, lChar);

            low++;
            high--;
        }

        System.out.println(res);
    }

    public static void reverseRemove(String str) {
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')) {
                temp += ch;
            }
        }

        StringBuilder res = new StringBuilder(temp);

        int low = 0;
        int high = res.length() - 1;

        while (low < high) {
            char lChar = res.charAt(low);
            char rChar = res.charAt(high);

            res.setCharAt(low, rChar);
            res.setCharAt(high, lChar);

            low++;
            high--;
        }

        System.out.println(res);
    }

    public static void lenOfLongestRepeatSeq(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            int count = 1;
            for (int j=i; j<n-1; j++) {
                if (arr[j] == arr[j+1]) {
                    count++;
                } else {
                    break;
                }
            }
            
            max = Math.max(count, max);
        }
        
        if (max <= 1) {
            System.out.println("-1");
        } else {
            System.out.println(max);
        }
    }
}