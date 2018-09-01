import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : vipul
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
    final int a = 3;
    for (int i = a; i <= n; i = i + 2) {
        int fact = 0;
        for (int j = 1; j <= i; j++) {
            if (i % j == 0) {
                fact += 1;
            }
        }
        if (fact > 2) {
            System.out.println(i);
        }
    }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}
