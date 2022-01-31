package DSA.maths;

public class PalindromNumber {

    /* Check if the no. is a palindrome */
    public static boolean palindromNumber(int x) {
        // if the no. is -ve find the absolute value
        int temp = x;
        if (x < 0) {
            x = Math.abs(x);
            temp = Math.abs(temp);
        }

        if (temp == reverseNo(x)) {
            return true;
        }

        return false;
    }

    // helper function to reverse a number
    private static int reverseNo(int n) {
        int rev = 0;
        while (n > 0) {
            int dig = n % 10;
            rev = rev * 10 + dig;
            n /= 10;
        }

        return rev;
    }

    public static void main(String[] args) {
        System.out.println("Is no. palindrome: " + palindromNumber(-1331));
    }
}

/*
 * Time complexity: O (d)
 * If "d" is the no. of digits in a no.
 * then the time complexity will be O (d)
 * 
 * Space complexity: O (1)
 */