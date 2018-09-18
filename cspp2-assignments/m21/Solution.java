import java.util.*;
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Details log = new Details();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			switch(tokens[0]) {
				case "Food":
					String[] data = tokens[1].split(",");
					Food foodObj = new Food(data[0], data[1], data[2], data[3]);
					log.addFood(foodObj);
					break;
				case "Water":
					String[] waterData = tokens[1].split(",");
					Water waterObj = new Water(waterData[0], waterData[1], waterData[2]);
					log.addWater(waterObj);
					break;
				case "PhysicalActivity":
					String[] activity = tokens[1].split(",");
					PhysicalActivity activityObj = new PhysicalActivity(activity[0], activity[1], activity[2], activity[3], activity[4]);
					log.addActivity(activityObj);
					break;
				case "Weight":
					String[] weights = tokens[1].split(",");
					Weight weightObj = new Weight(weights[0], weights[1], weights[2], weights[3]);
					log.addWeight(weightObj);
					break;
				case "Sleep":
					String[] duration = tokens[1].split(",");
					Sleep sleepObj = new Sleep(duration[0], duration[1], duration[2]);
					log.addSleep(sleepObj);
					break;
				case "Summary":
					if (tokens.length == 1) {
						log.getSummary();
					} else {
						log.getSummaryOfDay(tokens[1]);
					}
					break;
				case "Foodlog":
					log.getFood();
					break;
				case "Waterlog":
					log.getWater();
					break;
				case "PhysicalActivitylog":
					log.getPhysicalActivity();
					break;
				case "Weightlog":
					log.getWeight();
					break;
				case "Sleeplog":
					log.getSleep();
					break;
				default: break;

			}
		}
	}
}
