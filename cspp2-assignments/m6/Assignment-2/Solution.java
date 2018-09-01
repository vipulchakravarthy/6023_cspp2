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
    final int[] multiples = {50, 100, 150, 200, 250, 300, 350, 400, 450, 500, 550};
	for (int i = 0; i < rows; i++) {
        for (int j = 0; j< columns; j ++) {
            if (a[i][j] <  multiples[0]) {
                a[i][j] = 0;
            }
            if (a[i][j] >multiples[0] && a[i][j] <= multiples[2]) {
                a[i][j] = multiples[1];
            }
            if (a[i][j] > multiples[2] && a[i][j] <= multiples[4]) {
                a[i][j] = multiples[3];
            }
            if (a[i][j] > multiples[4] && a[i][j] <= multiples[6]) {
                a[i][j] = multiples[5];
            }
            if (a[i][j] > multiples[6] && a[i][j] <= multiples[8]) {
                a[i][j] = multiples[7];
            }
            if (a[i][j] > multiples[8] && a[i][j] <= multiples[10]) {
                a[i][j] = multiples[9];
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
