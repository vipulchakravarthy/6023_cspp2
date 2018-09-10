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
    /**the method is to resize the list
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
/**the method is to add an element
*@param item int
*/
 public void add(final int item) {
        if (size == list.length) {
            resize();
        }
        if (!contains(item)) {
           list[size++] = item;
        }
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
    /** Returns​ ​ a ​ ​ view​ ​ of​ ​ the​ ​ portion​ ​ of​ .
     * this​ ​ set whose​ ​ elements​ ​ range​ ​ from​ ​ fromElement,​
     *  inclusive,​ ​ to​ ​ toElement,​ ​ exclusive.
     *@param elementOne int
     *@param elementTwo
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
    /** Returns​ ​ a ​ ​ view​ ​ of​ ​ the​ ​ portion​. ​
     *of​ ​ this​ ​ set​ ​ whose​ ​ elements​ ​ are strictly​
     *less​ ​ than​ ​ toElement.
     *@param item int
     *@return temp int[]
     */
    public int[] headSet(final int item) {
            return subSet(list[0], item);
        }
    /**the method is to give the last element in set
    *@return last element of set
    */
    public int last() {
        return list[size-1];
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
        for ( i = 0; i < size - 1; i++) {
            str += list[i] + ", ";
        }
        str += list[i] + "}";
        return str;
        }
}
/** this is the solution class which contains.
 * main method
 */
public final class Solution {
    /** the empty constructor for the class.
    */
    Solution() {
    }
    /** the main method is to take the.
    *input from user.
    *@param args String[]
    */
    public static void main(final String[] args) {
    SortedSet setObj = new SortedSet();
    Scanner sc = new Scanner(new
        BufferedInputStream(System.in));
    while(sc.hasNext()) {
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
                if ((Integer.parseInt(t1[1])) < (
                    Integer.parseInt(t1[0]))) {
                    System.out.println(
                        "Invalid Arguments to Subset Exception");
                    break;
                }
                else if (setObj.size() == 0) {
                    System.out.println("{}");
                    break;
                }
                else {
                int[] array = setObj.subSet(
                    Integer.parseInt(t1[0]), Integer.parseInt(t1[1]));
                String str = "{";
                int i;
                for ( i = 0; i < array.length - 1; i++) {
                    str += array[i] + ", ";
                }
                str += array[i] + "}";
                System.out.println(str);
                }
                break;
            case "headSet":
            if (Integer.parseInt(tokens[1]) <= setObj.get(0)) {
                System.out.println("{}");
                break;
                }
            else {
                int[] arrayOne = setObj.headSet(
                    Integer.parseInt(tokens[1]));
                String strOne = "{";
                int j;
                for ( j = 0; j < arrayOne.length - 1; j++) {
                    strOne += arrayOne[j] + ", ";
                }
                strOne += arrayOne[j] + "}";
                System.out.println(strOne);
            }
                break;
            case "last":
                if (setObj.size() == 0) {
                    System.out.println("Set Empty Exception");
                    System.out.println("-1");
                    break;
                }
                System.out.println(setObj.last());
                break;
            default: break;
        }
    }
    }
}
