import java.util.*;
public class Bigger_equal_smaller
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int varA = scan.nextInt();
		int varB = scan.nextInt();
		if(varA > varB) System.out.println("Bigger");
		if(varA == varB) System.out.println("equal");
		else System.out.println("smaller");
	}
}
