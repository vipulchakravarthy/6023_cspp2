class Weight {
	private  String weight;
	private String fat;
	private String date;
	private String time;
	Weight(String date, String time, String weight, String fat) {
		this.weight = weight;
		this.fat = fat;
		this.date = date;
		this.time = time;
	}
	public String getTime() {
		return time;
	}
	public String getWeight() {
		return weight;
	}
	public  String getFat() {
		return fat;
	}
	public String getDate() {
		return date;
	}
	public String toString() {
		String str = "";
		str += "Weight" + "\n" + "Date:" + this.date + "\n" + "Time:" + this.time +"\n"+ "Weight" + this.weight + "\n" + "Fat:" + this.fat;
		return str;
	}
}
