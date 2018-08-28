import java.util.*;
public class Factorial
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
        System.out.println(fact(number));
	}
	public static int fact(int number)
	{
		if(number == 0||number == 1) return 1;
		else return (number * fact(number-1));
	}
}