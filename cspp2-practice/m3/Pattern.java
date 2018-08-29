import java.util.*;
public class Pattern {
	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		int number = 5;
		for(int i=0;i<number;i++) 
		{
			int k = 1;
			for (int j = 0; j<= i; j++)
			{
			  System.out.print(k + " ");
			  k++;
		    }
		    System.out.println();
		}
	}
}