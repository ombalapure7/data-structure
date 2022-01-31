package DSA.maths;

public class CountDigits {

    /* Count no. of digits in the a number - iterative */
    public static int countDigitsItr(int x) {
        // if the no. is -ve find the absolute value
        if (x < 0) {
            x = Math.abs(x);
        }

        int res = 0;
        while (x > 0) {
            x = x / 10;
            res++;
        }

        return res;
    }

    /* Count no. of digits in the a number - recursive */
    public static int countDigitsRec(int x) {
        // if the no. is -ve find the absolute value
        if (x < 0) {
            x = Math.abs(x);
        }

        if (x < 0) {
            return x;
        }

        return 1 + countDigitsRec(x / 10);
    }

    public static void main(String[] args) {
        System.out.println("No. of digits: " + countDigitsItr(-321));
        System.out.println("No. of digits: " + countDigitsRec(-231));
    }
}

/*
 * Time complexity: O (d) If "d" is the no. of digits in a number then the time
 * complexity will be O (d)
 * 
 * Space complexity: O (1)
 */