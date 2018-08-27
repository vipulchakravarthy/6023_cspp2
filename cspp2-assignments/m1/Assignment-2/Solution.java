import java.util.Scanner;
public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int base = scan.nextInt();
		int height = scan.nextInt();
		double area = (0.5*base*height);
		System.out.println(area);
	}
}