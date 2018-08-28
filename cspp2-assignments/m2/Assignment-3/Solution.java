import java.util.Scanner;

public class Solution {
	/**
	Do not modify this main function.
	*/
	private Solution () {
		/* this is the class constructor.
		*/
	}
	/**this is the main function.
	*@param args String
	*/ 
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        int result = power(base,exponent);
        System.out.println(result);
	}
	/**the function is to find the power and print the output.
	*@param base int
	*@param exponent int
	*/
	public static int power(int base, int exponent) {
		if (exponent == 0) return 1;
		else return base * power(base, exponent - 1);
	}
}
