import java.util.Scanner;
/** the program is to perform addition of two matrices.
*/
public final class Solution {
    /**
    *Fill the main function to print resultant of addition of matrices.
    */
    private Solution() {
        /** this is the constructor.
        */
    }
    /** the main program is to perform the addition of two matrices.
    *@param args string
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix1 = readmatrix(scan);
        int[][] matrix2 = readmatrix(scan);
        int[][] result = new int[matrix1.length][matrix1[0].length];
    if ((matrix1.length == matrix2.length)
     && (matrix1[0].length == matrix2[0].length)) {
            result = add(matrix1, matrix2);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length - 1; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println(result[i][result[0].length - 1]);
             }
        } else {
            System.out.println("not possible");
        }
    }
    /** the function is to read the matrices.
    *@param scan object of scanner
    *@return array
    */
    public static int[][] readmatrix(final Scanner scan) {
        int m, n;
        m = scan.nextInt();
        n = scan.nextInt();
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scan.nextInt();
            }
       }
        return array;
    }
    /** the function is two add two matrices.
    *@param matrix1 array
    *@param matrix2 array
    *@return result array
    */
    public static int[][] add(final int[][] matrix1, final int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
    }