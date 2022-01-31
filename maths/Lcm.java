package DSA.maths;

public class Lcm {

    /* LCM of two numbers - naive */
    // smallest no. that can divide a and b 
    // a = 4 and b = 6, LCM => 12 
    // when a can divide b then the LCM is b
    // a = 2 and b = 8, LCM => 8
    // if 2 no. dont have a common factor, they are co prime
    // their lcm is product of a and b
    // a = 3 and b = 7, LCM => 21
    public static int lcmNaive(int a, int b) {
        // lcm will be the larger no. or greater than the larger no.
        // in best it will be the larger no.
        int res = Math.max(a, b);

        while (true) {
            if (res % a == 0 && res % b == 0) {
                return res;
            }
            res++;
        }  
    }

    /* LCM of two numbers - efficient */
    // a = 4, b = 6, HCF => 2 
    // LCM = (4 * 6) / 2 = 12
    // a * b = GCD(a, b) * LCM(a, b)
    public static int lcmEfficient(int a, int b) {
        return (a * b) / Hcf.hcfEuclidean(a, b);
    }

    public static void main(String[] args) {
        System.out.println("LCM of a and b - naive: " + lcmNaive(4, 6));
        System.out.println("LCM of a and b - efficient: " + lcmEfficient(4, 6));
    }
}

/*
NAIVE
-----------
Time Complexity: O (a * b - Max(a, b))
Space complexity: O (1)

##########################################

EFFIECITENT
-----------
Time Complexity: O (log(min(a * b)))  
Space complexity: O (1)
*/