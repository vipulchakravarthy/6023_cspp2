import java.util.Scanner;
/** the program checks whether the given text is valid or not.
 * this class takes the input and returns true if it has minimum
 * of length six or else false.
 */
class InputValidator {
    /**
     * the instance variables are declared with private specifier.
     */
    private String input;
    /** the instnace varaible is declared with private specifier.
    */
    private String text;
    /**
     * the constructor is to initialize the input given.
     * @param      input  given text input
     */
    public InputValidator(final String input) {
        this.input = input;
    }
    /**
     *the validateData method is to either it is valid or not.
     *if it is valid return true or else false.
     * @return  boolean either true or false.
     */
    public boolean validateData() {
        int length = this.input.length();
        final int six = 6;
        if (length >= six) {
            return true;
        }
        return false;
    }
}
/**
 * this solution class is to write the main program.
 */
public final class Solution {
    /** this is a empty constructor.
    */
    private Solution() {
    }
    /**
     * In this main program it reads the input from the user and creates
     * an object and call the method called ValidateData.
     * @param args String
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        InputValidator text = new InputValidator(input);        
        System.out.println(text.validateData());
    }
}
