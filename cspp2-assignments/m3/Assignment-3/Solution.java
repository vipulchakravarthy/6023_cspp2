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
        Scanner scan = new Scanner(System.in);
        int numberOne = scan.nextInt();
        int numberTwo = scan.nextInt();
        System.out.println(gcd(numberOne, numberTwo));
    }
    /**
    *Need to write the gcd function and print the output.
    *@param numberOne int
    *@param numberTwo int
     *@return int
    */
    public static int gcd(final int numberOne, final int numberTwo) {
        int result = 1;
        for (int i = 1; i <= numberOne && i <= numberTwo; ++i) {
            if (numberOne % i == 0 && numberTwo % i == 0) {
                result = i;
            }
        }
        return result;
    }
}

