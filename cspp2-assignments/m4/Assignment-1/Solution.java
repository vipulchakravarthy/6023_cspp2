import java.util.Scanner;
/** the program is to print the max of given array.
*/
public final class Solution {
    /**
    *Fill this main function to print maximum of given array.
    */
    private Solution() {
    /**
    * this is the constructor class.
    */
    }
    /** the main function which will read the array elements.
    *@param args String
    */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        int max = 0;
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = sc.nextInt();
        }
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        System.out.println(max);
    }
}
