import java.util.*;
public class FirstLast6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int a[] = new int[length];
		for (int i = 0; i < length; i++) {
			a[i] = scan.nextInt(); 
		}
		if ((a[0] == 6) || (a[length-1] == 6)) System.out.println("True");
		else System.out.println("False");
	}
}