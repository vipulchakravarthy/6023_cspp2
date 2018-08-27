import java.util.Scanner;
public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double degreesCelsius = scan.nextDouble();
		double fahrenheit = ((degreesCelsius*1.8)+32);
		System.out.println(fahrenheit);
	}
}