import java.util.*;
public class SumOfNNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		int sum = 0;
		for(int i = 0; i <= number;i++) {
			sum = sum +number;
		}
		System.out.println(sum/2);
	}
}