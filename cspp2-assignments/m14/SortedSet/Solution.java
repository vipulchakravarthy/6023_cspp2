import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
class SortedSet {
	private int[] list;
	private int size;

	SortedSet() {
		list = new int[10];
		size = 0;
	}
	public int get(int index) {
		for (int i = 0; i < size; i++) {
			if (i == index) {
				return list[i];
			}
		}
		return -1;
	}
    private void resize() {
        list = Arrays.copyOf(list, 2 * list.length);
    }
    public boolean contains(final int item) {
        for (int element: list) {
            if (element == item) {
                return true;
            }
        }
    return false;
}
 public void add(final int item) {
        if (size == list.length) {
            resize();
        }
        if (!contains(item)) {
           list[size++] = item;
        }
 }

	public void addAll(final int[] newArray) {
		if (size + newArray.length > 10) {
			resize();
		}
		for (int i = 0; i < newArray.length; i++) {
			add(newArray[i]);
		}
		Arrays.sort(list, 0, size);
		}

	public int[] subSet(final int elementOne, final int elementTwo) {
		int[] resultSet = new int[10];
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

	public int[] headSet(final int item) {
			return subSet(list[0], item);
		}
	public int last() {
		return list[size-1];
	}

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

public class Solution {
	/** the empty constructor for the class.
	*/
	Solution() {

	}
	public static void main(String[] args) {
	SortedSet setObj = new SortedSet();
	Scanner sc = new Scanner(new BufferedInputStream(System.in));
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
				if ((Integer.parseInt(t1[1])) < (Integer.parseInt(t1[0]))) {
					System.out.println("Invalid Arguments to Subset Exception");
				}
				else {
				int[] array = setObj.subSet(Integer.parseInt(t1[0]), Integer.parseInt(t1[1]));
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
			if (Integer.parseInt(tokens[1]) < setObj.get(0)) {
				System.out.println("{}");
				}
			else {
				int[] arrayOne = setObj.headSet(Integer.parseInt(tokens[1]));
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
				System.out.println(setObj.last());
				break;
			default: break;
		}
	}
	}
}
