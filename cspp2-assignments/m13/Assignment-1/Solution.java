import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for set.
 * @author :vipul chakravarthy
 */
class Set {
	/** the list is declared with the private.
	*access specifier
	*/
	private int[] list;
	/** the size is declared to get.
	*number of elements in array
	*/
	private int size;
	/**this is a constructor
	*/
	public Set() {
		list = new int[10];
		size = 0;
	}
	/** this method gives the size of.
	*the set
	*@return size int
	*/
	public int size() {
		return size;
	}
	/** this is to resize the set
	*/
	private void resize() {
		list = Arrays.copyOf(list, 2*list.length);
	}
	/** the method is check the element is present.
	*or not
	 *@param item int
	 *@return boolean
	*/
	public boolean contains(final int item) {
		for(int element: list) {
			if(element == item) {
				return true;
			}
		}
		return false;
	}
	/** the method is to add the item.
	*to the set.
	*@param item int
	*/
	public void add(final int item) {
		if (contains(item) == false) {
				list[size++] = item;
			}
	}
	/** the methos is to add an array.
	*to the set
	 *@param newArray int
	*/
	public void add(final int[] newArray) {
		if (size + newArray.length > 10) {
			resize();
		}
		for (int element: newArray) {
			add(element);
		}
	}
	/** the method is to print the  set.
	*@return str String
	*/
	public String toString() {
		if (size == 0) {
			return "{}";
		}
		String str = "{";
		for (int i = 0; i < size-1; i++) {
			str += list[i] + ", ";
		}
		str += list[size-1] + "}";
		return str;
	}
	/** the method is to give the intesection.
	*@param newSet Set
	*@return resultSet Set
	*/
	public Set intersection(final Set newSet) {
		Set resultSet = new Set();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < newSet.size(); j++) {
				if (newSet.contains(list[i])) {
					resultSet.add(list[i]);
				}
			}
		}
		return resultSet;
	}
	/** this method to perform retainAll on sets
	*@param newArray int[]
	*@return resultSet Set
	*/
	public Set retainAll(final int[] newArray) {
		Set resultSet = new Set();
	for (int j = 0; j < size; j++) {
		for (int i = 0; i < newArray.length; i++) {
				if (newArray[i] == list[j]) {
					resultSet.add(list[j]);
				}
			}
		}
		return resultSet;
	}
	/** the method is to return an array with.
	* the cartesian product of two sets
	*@param otherSet Set
	@return output int[][]
	*/
	public int[][] cartesianProduct(final Set otherSet) {
		int[][] output = new int[15][2];
		if (size == 0 || otherSet.size() == 0) {
			System.out.println("null");
			return null;
		}
        return output;
}
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
