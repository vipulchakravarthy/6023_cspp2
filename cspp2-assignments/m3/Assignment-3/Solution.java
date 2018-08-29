import java.util.Scanner;
/**
*Do not modify this main function.
*the program is to fin the gcd of two numbers.
*/
public final class Solution {
    /** this is a constructor.
    */
    private Solution() {
    }
    /** the main program is find the gcd of given two numbers.
     * @param args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(gcd(n1, n2));
    }
    /**
    *Need to write the gcd function and print the output.
    *@param n1 int
    *@param n2 int
     *@return int
    */
    public static int gcd(final int n1, final int n2) {
        int result = 1;
        for (int i = 1; i <= n1 && i <= n2; ++i) {
            if (n1 % i == 0 && n2 % i == 0) {
                result = i;
            }
        }
        return result;
    }
}

