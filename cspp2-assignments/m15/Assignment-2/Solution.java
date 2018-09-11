import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
/**the below class is to perform the set operation.
*/
class SortedSet {
    /**the list is the array created with private specifier.
    */
    private int[] list;
    /**the size is an array variable.
    */
    private int size;
    /** the below is constructor.
     *@param items int[]
    */
    SortedSet(final int[] items) {
        final int ten = 10;
        list = new int[ten];
        size = 0;
        addAll(items);
    }
    /** the constructor for the class.
    */
    SortedSet() {
        final int ten = 10;
        list = new int[ten];
        size = 0;
    }
    /**
     * the method is to determine the size of.
     *an array.
     *@return size int
     */
    public int size() {
        return size;
    }
    /**
     * the method is to get the element at index.
     * @param      index  int
     *
     * @return  element at that index
     */
    public int get(final int index) {
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return list[i];
            }
        }
        return -1;
    }
    /**the method is to resize the list.
    */
    private void resize() {
        list = Arrays.copyOf(list, 2 * list.length);
    }
    /**the method is to give whether the.
    *element is present or not.
    *@param item int
    *@return boolean
    */
    public boolean contains(final int item) {
        for (int element: list) {
            if (element == item) {
                return true;
            }
        }
    return false;
}
/**the method is to add an element.
*@param item int
*/
 public void add(final int item) {
        if (size == list.length) {
            resize();
        }
        if (!contains(item)) {
           list[size++] = item;
        }
        Arrays.sort(list, 0, size);
 }
    /** the methos is to add an array.
    *to the set
     *@param newArray int
    */
    public void add(final int[] newArray) {
        final int tenDecimal = 10;
        if (size + newArray.length > tenDecimal) {
            resize();
        }
        for (int element: newArray) {
            add(element);
        }
        Arrays.sort(list, 0, size);
    }
    /** the method is to add array to set.
    *@param newArray int[]
    */
    public void addAll(final int[] newArray) {
        final int tenOne = 10;
        if (size + newArray.length > tenOne) {
            resize();
        }
        for (int i = 0; i < newArray.length; i++) {
            add(newArray[i]);
        }
        Arrays.sort(list, 0, size);
        }
    /** Returns​ a​ view ​of​ the​ portion​ ​of​ .
     * this​ ​ set whose​ ​ elements​ ​ range​ ​ from​ ​
     * fromElement,​
     *  inclusive,​ ​ to​ ​ toElement,​ ​ exclusive.
     *@param elementOne int
     *@param elementTwo int
     *@return temp
     */
    public int[] subSet(final int elementOne, final int elementTwo) {
        final int tenDecimal = 10;
        int[] resultSet = new int[tenDecimal];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (list[i] >= elementOne && list[i] < elementTwo) {
                resultSet[count] = list[i];
                count++;
            }
        }
        int[] temp = Arrays.copyOfRange(resultSet, 0, count);
        return temp;
        }
    /**Returns​ a ​view​ of​ the​ portion​. ​
     *of​ ​ this​ ​ set​ ​ whose​ elements​ are
     *strictly​
     *less​ ​ than​ ​ toElement.
     *@param item int
     *@return temp int[]
     */
    public int[] headSet(final int item) {
            return subSet(list[0], item);
        }
    /**the method is to give the last element in set.
    *@return last element of set
    */
    public int last() {
        return list[size - 1];
    }
    /**
     * Finds the intersection of the two sets.
     * @param  other as set 2.
     * @return the result that contains the common
     * elements of the two sets.
     */
    public SortedSet intersection(final SortedSet other) {
        SortedSet result = new SortedSet();
        for (int i = 0; i < this.size; i++) {
            if (other.contains(this.get(i))) {
                result.add(this.get(i));
            }
        }
        return result;
    }
    /**
     * retains all the elements from the set.
     * @param  arr is a form of set2.
     * @return the set that contains all the elements
     * of this set.
     */
    public SortedSet retainAll(final int[] arr) {
        SortedSet other = new SortedSet();
        for (int item : arr) {
            other.add(item);
        }
        return intersection(other);
    }
    /** this method is to print the set.
    *@return str String
    */
    public String print() {
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str += list[i] + ", ";
        }
        str += list[i] + "}";
        return str;
        }
}
/** this is the solution class which contains.
 * main method
 */
public final class Solution extends Exception {
    /** the empty constructor for the class.
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
    /** the main method is to take the.
    *input from user.
    *@param args String[]
    */
    public static void main(final String[] args) {
    SortedSet setObj = new SortedSet();
    SortedSet s = new SortedSet();
    Scanner sc = new Scanner(new
        BufferedInputStream(System.in));
    while (sc.hasNext()) {
        String line = sc.nextLine();
        String[] tokens  = line.split(" ");
        switch (tokens[0]) {
            case "print":
                System.out.println(setObj.print());
                break;
            case "addAll":
                if (tokens.length == 2) {
                String[] t1 = tokens[1].split(",");
                int[] temp = new int[t1.length];
                for (int i = 0; i < temp.length; i++) {
                       temp[i] = Integer.parseInt(t1[i]);
                }
                setObj.addAll(temp);
                }
                break;
            case "subSet":
                String[] t1 = tokens[1].split(",");
                try {
                     if ((Integer.parseInt(t1[1])) < (
                        Integer.parseInt(t1[0]))) {
                        throw new Exception(
                        "Invalid Arguments to Subset Exception");
                    }
                    if ((setObj.size() == 0)) {
                        System.out.println("{}");
                        break;
                    } else {
                    int[] array = setObj.subSet(
                    Integer.parseInt(t1[0]), Integer.parseInt(t1[1]));
                    String str = "{";
                    int i;
                    for (i = 0; i < array.length - 1; i++) {
                        str += array[i] + ", ";
                    }
                    str += array[i] + "}";
                    System.out.println(str);
                    }
                } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
            case "headSet":
                try {
                    if (Integer.parseInt(tokens[1]) <= setObj.get(0)) {
                        throw new Exception("Set Empty Exception");
                    } else {
                        int[] arrayOne = setObj.headSet(
                        Integer.parseInt(tokens[1]));
                        String strOne = "{";
                        int j;
                        for (j = 0; j < arrayOne.length - 1; j++) {
                        strOne += arrayOne[j] + ", ";
                        }
                        strOne += arrayOne[j] + "}";
                        System.out.println(strOne);
                    }
                    } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
            case "last":
            try {
                if (setObj.size() == 0) {
                    throw new Exception("Set Empty Exception");
                } else {
                System.out.println(setObj.last());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
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
            s = new SortedSet();
            SortedSet t = new SortedSet();
            intArray = intArray(tokens[1]);
            s.add(intArray);
            intArray = intArray(tokens[2]);
            t.add(intArray);
            System.out.println(s.intersection(t).print());
            break;
            case "retainAll":
            s = new SortedSet();
            intArray = intArray(tokens[1]);
            s.add(intArray);
            intArray = intArray(tokens[2]);
            System.out.println(s.retainAll(intArray).print());
            break;

            default: break;
        }
    }
    }
}
