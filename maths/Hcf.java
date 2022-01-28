package DSA.maths;

public class Hcf {
 
    /* Find hcf or gcd of a number - naive */
    // a = 4, b =  6
    // o/p: 2 (largest no. that can divide a and b)
    /* 
    NOTE: If we create a grid of a x b 
    The largest square tile that can fill the whole rectangle is 2 
    Hence the op is => 2 

        1   2   3   4   5   6
       ___  
    1 |   |   |   |   |   |   |     
    2 |___|   |   |   |   |   |   
    3 |   |   |   |   |   |   |    
    4 |___|   |   |   |   |   |   
      
    */
    public static int hcfNaive(int a, int b) {
        // the gcd will not be greater than a 
        // eg: in 100 and 200, gcd cannot be bigger than 100 
        int res = Math.min(a, b);
        while (res > 0) {
            if (a % res == 0 && b % res == 0) {
                break;
            }
            res--;
        }

        return res;
    }

    /* Find hcf or gcd of a number - efficient*/
    // the efficient solution is found using Eculidean algorithm
    /* 
    Let b be smaller than a 
    gcd(a, b) = gcd(a-b, b)

    Let g be HCF of a and b 
    then a = gx and b = gy and HCF(x, y) = 1
    Therefore, (a - b) = g(x - y)
    */
    public static int hcfEuclidean(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        // can return a or b as final result
        return a;
    }

    /* Euclidean algorithm - optimized */
    // Instead of doing repeated subtraction we can do modular division
    public static int hcfEuclideanBetter(int a, int b) {
        if (b == 0) {
            return a;
        }

        return hcfEuclideanBetter(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("HCF of a and b - naive: " + hcfNaive(10, 15));
        System.out.println("HCF of a and b - euclidean: " + hcfEuclidean(10, 15));
        System.out.println("HCF of a and b - euclidean better: " + hcfEuclideanBetter(10, 15));
    }
}

/* 
NAIVE
-----------
Time Complexity: O (min(a, b))
if a = 7 and b = 11
we go from 7,6,...,1
we start from a 

Space complexity: O (1)

##########################################

EFFIECITENT
-----------
Time Complexity: O (log(min(a, b)))
Space complexity: O (1)
*/ 