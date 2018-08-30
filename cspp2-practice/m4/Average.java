import java.util.*;
public class Average {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int sum = 0, avg;
		int a[] = new int[length];
		for (int i = 0; i < length; i++) {
			a[i] = scan.nextInt();
		}
		for(int element: a) {
			sum += element;
		}
		avg = (sum / length);
		System.out.println(avg);
	} 
}