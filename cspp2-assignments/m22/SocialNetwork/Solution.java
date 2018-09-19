import java.util.*;
class Solution {
	private static List<Person> personDetails;
	Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SocialNetwork data = new SocialNetwork();
		while(scan.hasNext()) {
			String line = scan.nextLine();
			if (line.contains(" is connected to ")) {
				String[] tokens = line.split(" is connected to ");
				String[] items = tokens[1].replace(".","").split(", ");
				Person personObj = new Person(tokens[0]);
				for (int i = 0; i < items.length; i++) {
					personObj.addFriend(items[i]);
				}
				data.addConnection(personObj);
			} else {
				String[] input = line.split(" ", 2);
				switch(input[0]) {
					case "addConnections":
						String[] connection = input[1].split(" ");
						data.addConnection(connection[0], connection[1]);
						break;
					case "getConnections":
					System.out.println(data.getConnections(input[1]));
						break;
					case "CommonConnections":
						String[] people = input[1].split(" ");
						data.getCommonConnections(people[0], people[1]);
						break;
					case "Network":
						data.showAll();
					default: break;
				}
			}
		}
	}
}
class SocialNetwork {
	private List<Person> personData;
	SocialNetwork() {
		personData = new List<Person>();
	}
	public void addConnection(String user, String friend) {
		for (int i = 0; i < personData.size(); i++) {
			if (user.equals(personData.get(i).getUser())) {
				personData.get(i).addFriend(friend);
			}
		}
	}
	public void addConnection(Person personObj) {
		personData.add(personObj);
	}
	public String getConnections(String user) {
		for (int i = 0; i < personData.size(); i++) {
			if (user.equals(personData.get(i).getUser())) {
				return personData.get(i).toString();
			}
		}
		return "Not a user in Network";
	}
	public void getCommonConnections(String personOne, String personTwo) {
		List<String> tempOne = new List<String>();
		List<String> tempTwo = new List<String>();
		List<String> result = new List<String>();
		for (int i = 0; i < personData.size(); i++) {
			if (personOne.equals(personData.get(i).getUser())) {
				tempOne = personData.get(i).getList();
				break;
			}
		}
		for (int i = 0; i < personData.size(); i++) {
			if (personTwo.equals(personData.get(i).getUser())) {
				tempTwo = personData.get(i).getList();
				break;
			}
		}
		for (int i = 0; i < tempOne.size(); i++) {
			if (tempTwo.contains(tempOne.get(i))) {
				result.add(tempOne.get(i));
			}
		}
		System.out.println(result.toString());
	}
	public void showAll() {
		String[] userNames = new String[personData.size()];
		for (int i = 0; i < personData.size(); i++) {
			userNames[i] = personData.get(i).toString();
		}
		Arrays.sort(userNames);
		String str = Arrays.toString(userNames);
		System.out.println(str.substring(1,str.length()-1));
	}
}
class Person {
	private String user;
	private List<String> friendsList;
	Person(String user) {
		this.user = user;
		friendsList = new List<String>();
	}
	public String getUser() {
		return this.user;
	}
	public void addFriend(String follower) {
		friendsList.add(follower);
	}
	public List<String> getList() {
		return friendsList;
	}
	public String toString() {
		// String str = "[";
		// for (int i = 0; i < friendsList.size() - 1; i++) {
		// 	str +=  friendsList.get(i) + ", ";
		// }
		// str += friendsList.get(friendsList.size() - 1) + "]";
		String str = this.user+": "+friendsList.toString();
		return str;
	}
}
