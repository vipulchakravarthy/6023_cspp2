import java.util.Scanner;
import java.lang.*;
public class Solution 
{
	public static void rootsOfQuadraticEquation(int a, int b, int c)
	{
		double x = (-b + (Math.sqrt((b*b) - (4*a*c)))) / (2*a);
		double y = (-b - (Math.sqrt((b*b) - (4*a*c)))) / (2*a);
		System.out.println(x+" "+y);
	}
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}

}
