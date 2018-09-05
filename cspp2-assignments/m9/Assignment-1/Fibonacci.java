import java.util.Scanner;
/**
 * In the previous module you have created List ADT.
 * ADTs are developed as reusable libraries.
 * i.e., anyone who needs the ADT can use it in their program
 * A program that uses the ADT is called a "client" of the ADT
 * The client typically instantiates an object of the ADT
 * and invokes the public methods on the ADT object.
 *
 * This assignment is to practice the idea of client to the ADT.
 * Client class is Fibonacci and the client needs to use the List ADT
 * to store fibonacci numbers in the List ADT.
 * So, Fibonacci is going to instantiate an object of List ADT
 * generate fibonacci numbers and add them to the list
 * by invoking the add method provided in the List ADT.
 *
 */

public final class Fibonacci {
    /**
     * fib is a static method takes a argument n.
     * n is the count of the fibonacci numbers to be generated.
     * The method returns a List with the n fibonacci numbers.
     *
     * Look for the hint.txt if some of the testcases fail.
     */
    private Fibonacci() {
        /**empty constructor
        */
    }
    /** the fibonacci method takes the number from user.
    *and return the list of fibonacci series upto that number.
    *@param n int
    *@return l list
    */
    public static List fib(final int n) {
        List l = new List(n);
        l.add(0);
        l.add(1);
        int numberOne = 0;
        int numberTwo = 1;
        for (int i = 1; i < n - 1; i++) {
            int sum = numberOne + numberTwo;
            numberOne = numberTwo;
            numberTwo = sum;
            l.add(sum);
        }
        return l;
    }
    /** the main program is to print the fibonacci series in
    * a list upto a given term.
    *@param args String
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fib(n));
    }
}