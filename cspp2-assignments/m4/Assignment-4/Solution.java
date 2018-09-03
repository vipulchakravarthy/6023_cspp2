import java.util.Scanner;
/** the program is to perform the reverse operation of a string.
*/
public final class Solution {
        /**this a constructor for this program.
        */
    private Solution() {
    }
    /**
    *the main program is to find the reverse of a string.
    *@param args String
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String reverse = reverseString(string);
        System.out.println(reverse);
    }
    /** the function is to reverse  the string.
    *@param string String is the given input
    *@return reverse of the given string
    */
    public static String reverseString(final String string) {
        String reverse = "";
        for (int i = (string.length() - 1); i >= 0; i--) {
            reverse = reverse + string.charAt(i);
        }
        return reverse;
    }

}
