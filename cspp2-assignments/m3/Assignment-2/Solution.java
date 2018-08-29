import java.util.Scanner;
/**
Do not modify this main function.
*/
public final class Solution {
/**Fill the main function to print the number of 7's between 1 to n
*/
	private Solution() {
	/** this is a constructor.
	*/
	}
	/**
	 * the program is to print the count of 7 in given range.
	 * @param args  The arguments
	 */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);      
        int n = s.nextInt();
        final int a = 7;
        final int b = 10;
        int count = 0;
        int temp;
        for (int i = 1; i <= n; i++) {
        	temp = i;
        	while (temp != 0) {
        		if (temp % b == a) {
        			count += 1;
        		}
        		temp = temp / b;
        	}
        }
        System.out.println(count);
    }
}