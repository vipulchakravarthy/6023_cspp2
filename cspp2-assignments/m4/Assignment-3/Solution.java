import java.util.Scanner;
/**
 *Given an String, Write a java method that returns the
 *decimal value for the given binary string.
 */
public final class Solution {
	/**
	this is class constructor.
	*/
	private Solution() {
	}
	/**
	*the main function is sto convert the binary to string.
	*@param args String
	*/
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			String res = binaryToDecimal(s);
			System.out.println(res);
		}
	}
	/**
	 * the function is to return the decimal value of the given
	 * binary string.
	 *@param s String
	 *@return Str string
	 */
	public static String binaryToDecimal(final String s) {
		int sum = 0;
		int unit = s.length() - 1;
		for (int i = 0; i <= unit; i++) {
			if (s.charAt(i) == '1') {
				sum += Math.pow(2, unit - i);
			}
		}
		String str = sum + "";
		return str;
	}
}
