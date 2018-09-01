import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : 
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
        final int one_fifty =150;
        final int two_hundred = 200;
        final int two_fifty = 250;
        final int three_hundred = 300;
        final int three_fifty = 350;
        final int four_hundred = 400;
        final int four_fifty = 450;
        final int five_hundred = 500;
        final int five_fifty = 550;
	for (int i = 0; i < rows; i++) {
        for (int j = 0; j< columns; j ++) {
            if (a[i][j] <  fifty) {
                a[i][j] = 0;
            }
            if (a[i][j] >fifty && a[i][j] <= one_fifty) {
                a[i][j] = hundred;
            }
            if (a[i][j] > one_fifty && a[i][j] <= two_fifty) {
                a[i][j] = two_hundred;
            }
            if (a[i][j] > two_fifty && a[i][j] <= three_fifty) {
                a[i][j] = three_hundred;
            }
            if (a[i][j] > three_fifty && a[i][j] <= four_fifty) {
                a[i][j] = four_hundred;
            }
            if (a[i][j] > four_fifty && a[i][j] <= five_fifty) {
                a[i][j] = five_hundred;
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
