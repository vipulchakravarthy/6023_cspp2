import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**Implement all the methods mentioned to build a ListADT.
*/
public final class List extends Exception {
    /**
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, assume we are only going to have ints in the list
     * We need to create an array of ints to store the items
     * added to the list.
     *
     * Create a variable of the type int[]
     * Use the private access specifier
     * Why private access specifier and why not public?
     * Well, we don't want the array to be manipulated by
     * methods that are outside the List class.
     * If you allow methods outside the List class to manipulate
     * the array then there is a possibility of having a corrupted
     * list i.e., a list with incorrect items.
     * This is not desirable and so having private access specifer
     * will protect the array such corruption.
     * This is a hard concept to understand. Discuss with your mentor.
     *
    */
    private int[] list;
    /** the size varaible is declared with private specifier.
    */
    private int size;
    // declare a private int[]
    // don't create the array yet using new
    // that's the job of the List constructor

    /**
     * What are the other class variables needed for creating a list?
     * How about keeping track of the size of the list?
     * If you add 2 items to the list then the size should be 2.
     * Let's think about the size of the list by comparing it to the
     * length of the array. Do they mean the same?
     * No, Array length signifies the maximum number of items
     * you can store in the list. Whereas, the size of the list
     * denotes the number of items in the list. Makes sense?
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * The length of the array is 10 and size is 3.
     * This means you can store 10 items in the list and
     * currently it has 3 items.
     * So, to keep track of the size we need a variable called size
     * Again, we use private as we don't want that size variable
     * to be accessed by the methods that are outside of the List class.
     *
     */
    // declare a private int size
    // again, don't initialize it here
    // variable initialization should be done in the constructor
    /**
     * The purpose of the constructor is to initialize.
     * the class variables with
     * some default values.
     */
    public List() {
        final int ten = 10;
        list = new int[ten];
        size = 0;
    }
    /**
     * The add method does what the name suggests. Add an int item to the list.
     * The assumption is to store the item at the end of the list What is the
     * end of the list? Is it the same as the end of the array? Think about how
     * you can use the size variable to add item to the list.
     *@param item int
     * The method returns void (nothing)
     */
    public void add(final int item) {
    list[size++] = item;
    }
    /**
     * The size method returns the value of the size.
     * The purpose of the method
     * is to announce the size of the list to the objects outside the list
     * The method returns an int. Empty list should return 0.
     *@return size
     */
    public int size() {
        return size;
    }
    /**
     * the method is to resize the list.
     */
     public void resize() {
        list = Arrays.copyOf(list, 2 * list.length);
     }
    /**
     * The remove method does what the name suggests. Removes an int item,
     * specified by the index argument, from the list It also does an additional
     * step. Think about what happens when an item is removed from the middle of
     * the list It creates a hole in the list, right? This would mean, all the
     * items that are to the right side of the removed item should be moved to
     * the left by one position. Here is an example: array =
     * [1,2,3,0,0,0,0,0,0,0] remove(1) would remove the item 2 which is at index
     * position 1. But how do you remove the item from an array? Well, the way
     * to remove it is to move all the items, that are to the right of the
     * removed item, to the left So, the new array looks like this. array =
     * [1,3,0,0,0,0,0,0,0,0] The method returns void (nothing)
     *@param index int
     */
    public void remove(final int index) {
        try {
            if (index >= 0 && index < size) {
                for (int i = index; i <= size; i++) {
                    list[i] = list[i + 1];
                }
                size--;
            } else {
                throw new Exception("Invalid Position Exception");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Get method has to return the items that is at the index position passed
     * as an argument to the method. If the item doesn't exist then return a -1
     * to indicate that there is no element at that index. How can an element
     * not be there at a given position? Well, if the position is greater than
     * the number of items in the list then that would mean the item doesn't
     * exist. How do we check if the position is greater than the number of
     * items in the list? Would size variable be useful?
     * @param index int
     * @return list[i] int
     */
    public int get(final int index) {
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return list[i];
            }
        }
        return -1;
    }
    /**
     * What happens when you print an object using println? Java provides a
     * method named toString that is internally invoked when an object variable
     * is used in println. For example: List l = new List();
     * System.out.println(l); This statement is a shortcut for
     * System.out.println(l.toString());
     *
     * So, implement the toString method to display the items in the list in the
     * square brackets notation. i.e., if the list has numbers 1, 2, 3 return
     * the string [1,2,3] Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0] toString should only return the items in
     * the list and not all the elements of the array.
     * @return str string
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String str = "[";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str += list[i] + ",";
        }
        str += list[i] + "]";
        return str;
    }
    /**
     * Contains return true if the list has the item passed
     * as an argument to.
     * the method So, iterate through the list and return
     * true if the item
     * exists and otherwise false
     * @param item int
     * @return boolean
     */
    public boolean contains(final int item) {
        for (int element: list) {
            if (element == item) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     * @param item int
     * @return index
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }
    /**
     * the method gives the frequency of.
     * number in the list
     * @param      item  int
     *
     * @return countOf int
     */
    public int count(final int item) {
        int countOf = 0;
        for (int element: list) {
            if (element == item) {
                countOf += 1;
            }
        }
        if (countOf > 0) {
            return countOf;
        }
        return countOf;
    }
    /**
    *Inserts all the elements of specified int array to the end of list.
    *@param newArray int[]
    */
    public void addAll(final int[] newArray) {
        final int ten = 10;
        if (size + newArray.length > ten) {
            resize();
        }
        int j = 0;
        for (int i = size; i < size + newArray.length; i++) {
            list[i] = newArray[j];
            j++;
        }
        size = size + newArray.length;
    }
    /**
    *Removes all of its elements that are contained in the specified int
    *array.
    *@param newArray int[]
    */
    public void removeAll(final int[] newArray) {
    for (int i = 0; i < newArray.length; i++) {
        int index = indexOf(newArray[i]);
        while (index != -1) {
             remove(index);
             index = indexOf(newArray[i]);
            }
        }
    }
    /**
    *Returns a list object containing elements, including startIndex and
    *excluding endIndex. The first parameter indicates the startIndex and the
    *second parameter indicates the endIndex. Returns null and print
    *"Index Out of Bounds Exception" if any of values start and end are negative
    *and also if start is greater than end.
    *@param start integer
    *@param end integer
    *@return resultList
    */
    public List subList(final int start, final int end) {
        List resultList = new List();
        for (int i = start; i < end; i++) {
                   resultList.add(list[i]);
        }
        return resultList;
    }
    /**
    *Returns a boolean indicating whether the parameter i.e a List object is.
    *exactly matching with the given list or not.
    *@param listOne List
    *@return boolean
    */
    public boolean equals(final List listOne) {
    return this.toString().equals(listOne.toString());
    }
    /**
    * Removes all the elements from list.
    * Think about this case and make the method
    * the simpler.
    */
    public void clear() {
        size = 0;
        }
        /** the main method is to get the inputs from user.
         * @param args String[]
        */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        List l = new List();
        // code to read the test cases input file
        Scanner stdin = new Scanner(
            new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corres
            //ponding method
            switch (tokens[0]) {
                case "add":
                    if (tokens.length == 2) {
                        String[] t = tokens[1].split(",");
                        if (t.length == 1) {
                            l.add(Integer.parseInt(tokens[1]));
                        }
                    }
                break;
                case "size":
                    System.out.println(l.size());
                break;
                case "print":
                    System.out.println(l);
                break;
                case "remove":
                    if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "get":
                    if (tokens.length == 2) {
                        System.out.println(l.get(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "contains":
                    if (tokens.length == 2) {
                        System.out.println(l.contains(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        int[] temp = new int[t1.length];
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = Integer.parseInt(t1[i]);
                        }
                        l.addAll(temp);
                    }
                break;
                case "removeAll":
                    if (tokens.length == 2) {
                        String[] t2 = tokens[1].split(",");
                        int[] a = new int[t2.length];
                        for (int i = 0; i < t2.length; i++) {
                            a[i] = Integer.parseInt(t2[i]);
                        }
                        l.removeAll(a);
                    }
                break;
                case "subList":
                    String[] arrstring3 = tokens[1].split(",");
                    if (tokens.length != 2) {
                        break;
                    }
                    int start = Integer.parseInt(arrstring3[0]);
                    int end = Integer.parseInt(arrstring3[1]);
                    int length = l.size();
                    try {
                    if (!((start < 0) || (end < 0) || (start > length)
                        || (end > length) || (length == 0))) {
                    List object = l.subList(Integer.parseInt(arrstring3[0]),
                            Integer.parseInt(arrstring3[1]));
                    if (object != null) {
                        System.out.println(object);
                    }
                    } else {
                        throw new Exception("Index Out of Bounds Exception");
                    }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        List l2 = new List();
                        for (int k = 0; k < lt.length; k++) {
                            l2.add(Integer.parseInt(lt[k]));
                        }
                        System.out.println(l.equals(l2));
                    }
                break;
                case "clear":
                    l.clear();
                break;
                case "count":
                    System.out.println(l.count(
                        Integer.parseInt(tokens[1])));
                    break;

                default:
                break;
            }
        }
    }
}
