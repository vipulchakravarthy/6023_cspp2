import java.util.*;
class Details{
	private List<Food> foodData;
	private List<Water> waterData;
	private List<PhysicalActivity> activityData;
	private List<Weight> weightData;
	private List<Sleep> sleepData;
	private String date;
	public Details() {
		foodData = new List<Food>();
		waterData = new List<Water>();
		activityData = new List<PhysicalActivity>();
		weightData = new List<Weight>();
		sleepData = new List<Sleep>();
	}
	public Details(String date) {
		this.date = date;
	}
	public void addFood(Food obj) {
		foodData.add(obj);
	}

	public void addWater(Water obj) {
		waterData.add(obj);
	}
	public void addActivity(PhysicalActivity obj) {
		activityData.add(obj);
	}

	public void addWeight(Weight obj) {
		weightData.add(obj);
	}

	public void addSleep(Sleep obj) {
		sleepData.add(obj);
	}

	// public void showAll() {
	// 	for (int i = 0; i < foodData.size(); i ++) {
	// 		System.out.println(foodData.get(i).getItem() + " " + foodData.get(i).getQuantity() + " " + foodData.get(i).getTime());
	// 	}
	// 	for (int i = 0; i < waterData.size(); i ++) {
	// 		System.out.println(waterData.get(i).getQuantity());
	// 	}
	// 	for (int i = 0; i < activityData.size(); i ++) {
	// 		System.out.println(activityData.get(i).getActivity() + " " + activityData.get(i).getDate() + " " + activityData.get(i).getStart()
	// 			+ " " + activityData.get(i).getEnd() + " " + activityData.get(i).getNotes());
	// 	}
	// 	for (int i = 0; i < weightData.size(); i++) {
	// 		System.out.println(weightData.get(i).getWeight() + " " + weightData.get(i).getFat());
	// 	}
	// 	for (int i = 0; i < sleepData.size(); i++) {
	// 		System.out.println(sleepData.get(i).getStart() + " " + sleepData.get(i).getEnd());
	// 	}
	// }

	public void getSummary() {
		getFood();
		getWater();
		getPhysicalActivity();
		getWeight();
		getSleep();
}
	public void getFood() {
		for (int i = 0; i < foodData.size(); i ++) {
			System.out.println(foodData.get(i).toString());
			System.out.println();
		}
	}
	public void getWater() {
		for (int i = 0; i < waterData.size(); i ++) {
			System.out.println(waterData.get(i).toString());
			System.out.println();
		}
	}
	public void getPhysicalActivity() {
		if (activityData.size() > 0) {
		    for (int i = 0; i < activityData.size(); i ++) {
				System.out.println(activityData.get(i).toString());
				System.out.println();
			}
		} else {
			System.out.println("PhysicalActivity");
			System.out.println("None");
		}
	}

	public void getWeight() {
		for (int i = 0; i < weightData.size(); i++) {
			System.out.println(weightData.get(i).toString());
			System.out.println();
		}
	}
	public void getSleep() {
		for (int i = 0; i < sleepData.size(); i++) {
			System.out.println(sleepData.get(i).toString());
			System.out.println();
		}
	}
	public void getSummaryOfDay(String date) {
		for (int i = 0; i < foodData.size(); i ++) {
			if (date.equals(foodData.get(i).getDate())) {
			System.out.println(foodData.get(i).toString());
		}
		}
		for (int i = 0; i < waterData.size(); i ++) {
			if (date.equals(waterData.get(i).getDate())) {
				System.out.println(waterData.get(i).toString());
		}
		}
		for (int i = 0; i < activityData.size(); i ++) {
			if (date.equals(activityData.get(i).getDate())) {
			System.out.println(activityData.get(i).toString());
		}
		}
		for (int i = 0; i < weightData.size(); i ++) {
			if (date.equals(weightData.get(i).getDate())) {
			System.out.println(weightData.get(i).toString());
		}
		}
		for (int i = 0; i < sleepData.size(); i ++) {
			if (date.equals(sleepData.get(i).getDate())) {
			System.out.println(sleepData.get(i).toString());
		}
		}
}
}

