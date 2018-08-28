import java.util.*;
import java.lang.Math;
public class Area_of_Circle
{
	public static void main(String[] args)
	{
		// double pi = 3.1457;
		Scanner scan = new Scanner(System.in);
		int radius = scan.nextInt();
		System.out.println(area(radius));
	}
	public static double area(int radius)
	{
		return pi()*radius*radius;
	}
	public static double pi()
	{
		return Math.PI;
	}
}