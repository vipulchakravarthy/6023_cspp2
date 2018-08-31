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
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /** the function is to reverse  the string.
    *@param s String
    *@return reverse
    */
    public static String reverseString(final String s) {
        String reverse = "";
        for (int i = (s.length() - 1); i >= 0; i--) {
            reverse = reverse + s.charAt(i);
        }
        return reverse;
    }

}
