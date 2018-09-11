import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedInputStream;
class Set {
	private int[] list;
	private int size;
	Set() {
		list = new int[10];
		size = 0;
	}
	public void add(final int item) {
		list[size++] = item;
	}

	public void add(final int index, final int item) {
       if (index < 0) {
            System.out.println("Negative Index Exception");
        }
        if (index == 0 && size == 0) {
            list[0] = list[item];
            size++;
        }
        if (index > 0) {
        for (int i = size; i > index; i--) {
        list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
        }
	}

	public int size() {
		return size;
	}

	public void resize() {
		list = Arrays.copyOf(list, 2 * list.length);
	}

	public void remove(int index) {
		try {
			for (int i = index; i <= size; i++) {
				list[i] = list[i + 1];
			}
			size--;
		}
		catch(Exception e) {
			System.out.println("Invalid Position Exception");
		}
		}

	public int get(int index){
		for (int i = 0; i < size; i++) {
			if (i == index) {
				return list[i];
			}
		}
		return -1;
	}

	public boolean contains(int item) {
		for (int i = 0; i < size; i++) {
			if (list[i] == item) {
				return true;
			}
		}
		return false;
	}


	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if (list[i] == element) {
				return i;
			}
		}
		return -1;
	}
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
	public String toString() {
		String str = "[";
		int i;
		for (i = 0; i < size - 1; i++) {
			str += list[i] + ",";
		}
		str += list[i] + "]";
		return str;
	}

	public void addAll(int[] newArray) {
		int j = 0;
		for (int i = size; i < size + newArray.length; i++) {
			list[i] = newArray[j];
			j++;
		}
		size += newArray.length;
	}

	public void removeAll(final int[] newArray) {
		for (int i = 0; i < newArray.length; i++) {
			int index = indexOf(newArray[i]);
			while(index != -1) {
				remove(index);
				index = indexOf(newArray[i]);
			}
		}
	}

	public void clear() {
		size = 0;
	}

	public boolean equals(final Set newList) {
		return this.toString().equals(newList.toString());
	}

	public Set subList(final int start, final int end) {
		try {
			Set result = new Set();
			for (int i = start; i < end; i++) {
				result.add(list[i]);
			}
			return result;
		} catch(Exception e) {
			System.out.println("Index Out of Bounds Exception");
			return null;
		}
	}
	}
public class Solution {
	public static void main(String[] args) {
		Set setObj = new Set();
		Scanner scan = new Scanner(
			new BufferedInputStream(System.in));
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
				case "add":
					setObj.add(Integer.parseInt(tokens[1]));
					break;
				case "size":
					System.out.println(setObj.size());
					break;
				case "remove":
					setObj.remove(Integer.parseInt(tokens[1]));
					break;
				case "get":
					setObj.get(Integer.parseInt(tokens[1]));
					break;
				case "print":
					System.out.println(setObj.toString());
					break;
				case "contains":
					System.out.println(setObj.contains(Integer.parseInt(tokens[1])));
					break;
				case "indexOf":
					System.out.println(setObj.indexOf(Integer.parseInt(tokens[1])));
					break;
				case "addAll":
					 if (tokens.length == 2) {
					String[] numbers = tokens[1].split(",");
					int[] temp = new int[numbers.length];
					for (int i = 0; i < numbers.length; i++) {
						temp[i] = Integer.parseInt(numbers[i]);
					}
					setObj.addAll(temp);
				}
					break;
				case "removeAll":
				 if (tokens.length == 2) {
					String[] numbersList = tokens[1].split(",");
					int[]  tempOne = new int[numbersList.length];
					for (int i = 0; i < numbersList.length; i++) {
						 tempOne[i] = Integer.parseInt(numbersList[i]);
					}
					setObj.removeAll( tempOne);
				}
					break;
				case "count":
					System.out.println(setObj.count(Integer.parseInt(tokens[1])));
					break;
				case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        Set listObj = new Set();
                        for (int k = 0; k < lt.length; k++) {
                            listObj.add(Integer.parseInt(lt[k]));
                        }
                        System.out.println(setObj.equals(listObj));
                    }
					break;
				case "subList":
					String[] indices = tokens[1].split(",");
					Set object = setObj.subList(Integer.parseInt(
						indices[0]),Integer.parseInt(indices[1]));
					if (object != null) {
						System.out.println(object);
					}
				case "clear":
					setObj.clear();
					break;
				default: break;
			}
		}
	}
}
