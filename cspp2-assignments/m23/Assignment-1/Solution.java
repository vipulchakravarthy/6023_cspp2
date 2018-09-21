import java.util.*;
import java.lang.*;
import java.io.*;
class Data {
	Data() {
	}
	public static String toText(File file) {
		String str = "";
		try {
			Scanner input = new Scanner(new FileReader(file));
			StringBuilder text = new StringBuilder();
			while(input.hasNext()) {
				text.append(input.next());
				text.append(" ");
			}
			input.close();
			str = text.toString();
		} catch (FileNotFoundException e) {
			System.out.println("No file");
		}
		return str;
	}
	public Map remove(String text) {
		text = text.toLowerCase();
		text = text.replaceAll("[^a-zA-Z 0-9]", "");
		String[] words = text.split(" ");
		Map<String, Integer> map = new HashMap<>();
		for (String element : words) {
			if (!(map.containsKey(element))) {
				map.put(element, 1);
			} else {
				map.put(element, map.get(element) + 1);
			}
		}
		return map;
	}

	public int similarity(String textOne, String textTwo) {
		double numerator = 0;
		double denominator = 1;
		double sumOne = 0;
		double sumTwo = 0;
		Map <String, Integer> mapOne = remove(textOne);
		Map <String, Integer> mapTwo = remove(textTwo);
		for (String element: mapOne.keySet()) {
			for (String item: mapTwo.keySet()) {
				if (element.equals(item)) {
					numerator += mapOne.get(element) * mapTwo.get(item);
				}
			}
		}

		for (String word: mapOne.keySet()) {
			sumOne += mapOne.get(word) * mapOne.get(word);
		}
		for (String word: mapTwo.keySet()) {
			sumTwo += mapTwo.get(word) * mapTwo.get(word);
		}
		denominator = Math.sqrt(sumOne) * Math.sqrt(sumTwo);
		double documentDistance = ((numerator / denominator) * 100);
		return (int)(documentDistance);
	}
}
public class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		try  {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		File files = new File(input);
		Data obj = new Data();
		File[] fileList = files.listFiles();
		int length = fileList.length;
		int[][] fileMatrix = new int[length][length];
		Map<Integer, List<String>> valuesMap = new HashMap<>();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i == j) {
					fileMatrix[i][j] = 100;
				} else {
				fileMatrix[i][j] = obj.similarity(obj.toText(fileList[i]), obj.toText(fileList[j]));
				}
				// if (fileMatrix[i][j] != 100) {
				// List<String> fileNames = new ArrayList<String>();
				// fileNames.add(fileList[i].getName(), fileList[j].getName());
				// valuesMap.put(fileMatrix[i][j], fileNames);
 			// 	}
			}
		}
		System.out.print("      \t");
		for (int i = 0; i < length - 1; i++) {
			System.out.print("\t" +fileList[i].getName());
		}
		System.out.println("\t" + fileList[length - 1].getName());
		for (int i = 0; i < length; i++) {
			System.out.print(fileList[i].getName() + "\t");
			for (int j = 0; j < length; j++) {
					System.out.print(fileMatrix[i][j] + "\t\t");
			}
			System.out.println();
		}
		// int maxValue = Collections.max(valuesMap.keys());
		// System.out.println(valuesMap.get(maxValue));
	} catch (NoSuchElementException e){
		System.out.println("empty directory");
	}
	}
}

