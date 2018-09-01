import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : vipul.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a, final int rows, final int columns) {
        final int fifty = 50;
        final int hundred = 100;
        final int oneFifty =150;
        final int twoHundred = 200;
        final int twoFifty = 250;
        final int threeHundred = 300;
        final int threeFifty = 350;
        final int fourHundred = 400;
        final int fourFifty = 450;
        final int fiveHundred = 500;
        final int fiveFifty = 550;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j< columns; j ++) {
            if (a[i][j] <  fifty) {
                a[i][j] = 0;
            }
            if (a[i][j] >fifty && a[i][j] <= oneFifty) {
                a[i][j] = hundred;
            }
            if (a[i][j] > oneFifty && a[i][j] <= twoFifty) {
                a[i][j] = twoHundred;
            }
            if (a[i][j] > twoFifty && a[i][j] <= threeFifty) {
                a[i][j] = threeHundred;
            }
            if (a[i][j] > threeFifty && a[i][j] <= fourFifty) {
                a[i][j] = fourHundred;
            }
            if (a[i][j] > fourFifty && a[i][j] <= fiveFifty) {
                a[i][j] = fiveHundred;
            }
        }
    }
    return a;
    
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
