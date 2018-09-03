import java.util.Scanner;
/**the program is to give the roots of a quadratic equation.
*/
public final class Solution {
    /** the class solution is defined to find roots of.
    *equation.
    */
    private Solution() {
        /** the constructor for performing this program.
        */
    }
    /**the function takes the co-efficient a,b and c.
    * prints the roots.
     * @param      numberOne    The number one
     * @param      numberTwo    The number two
     * @param      numberThree  The number three
     */
    public static void roots(final int numberOne,
    final int numberTwo, final int numberThree) {
        int four = 2 * 2;
        double dis = Math.sqrt((numberTwo * numberTwo)
        - (four * numberOne * numberThree));
        double root1 = (-numberTwo + dis) / (2 * numberOne);
        double root2 = (-numberTwo - dis) / (2 * numberOne);
        System.out.println(root1 + " " + root2);
    }
    /** the main program will read the input from the user.
    *calls the function to get the roots of equation.
    *@param args String
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOne = scan.nextInt();
        int numberTwo = scan.nextInt();
        int numberThree = scan.nextInt();
        roots(numberOne, numberTwo, numberThree);
    }
}



