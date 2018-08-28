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
    *@param a int
    *@param b int
    *@param c int
    */
    public static void roots(final int a, final int b, final int c) {
        int four = 2 * 2;
        double dis = Math.sqrt((b * b) - (four * a * c));
        double root1 = (-b + dis) / (2 * a);
        double root2 = (-b - dis) / (2 * a);
        System.out.println(root1 + " " + root2);
    }
    /** the main program will read the input from the user.
    *calls the function to get the roots of equation.
    *@param args String
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        roots(a, b, c);
    }
}



