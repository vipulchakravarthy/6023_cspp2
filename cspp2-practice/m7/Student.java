import java.util.*;
class StudentDetails {
	static String name; static String rollnumber; static double subject1;
	static double subject2; static double subject3;
	public StudentDetails(String name, String rollnumber, double subject1,
	                      double subject2, double subject3  ) {
		this.name = name;
		this.rollnumber = rollnumber;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
	}
	public void gPa() {
		double average = (subject1 + subject2 + subject3) / 3.0D;
		System.out.format("%.1f %n", average);
	}
}
public class Student {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String studentName = scan.next() ;
		String number = scan.next();
		double grade1 = scan.nextDouble();
		double grade2 = scan.nextDouble();
		double grade3 = scan.nextDouble();
		StudentDetails data = new StudentDetails(studentName, number, grade1, grade2, grade3);
		data.gPa();
	}
}