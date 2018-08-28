import java.util.Scanner;
/**the program is to find the power of given number.
*/
public final class Solution {
    /**
    Do not modify this main function.
    */
    private Solution() {
        /* this is the class constructor.
        */
    }
    /**this is the main function.
    *@param args String
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        long base = s.nextLong();
        long exponent = s.nextLong();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**the function is to find the power and print the output.
    *@param base long
    *@param exponent long
    *@return
    */
    public static long power(final long base, final long exponent) {
        if (exponent == 0) {
         return 1;
        }
        else {
         return base * power(base, exponent - 1);
        }
    }
}
