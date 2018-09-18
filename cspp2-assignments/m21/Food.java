class Food {
	private String item;
	private String quantity;
	private String time;
	private String date;
	Food(String item, String quantity, String date, String time) {
		this.item = item;
		this.quantity = quantity;
		this.time = time;
		this.date = date;
	}

	public String getItem() {
		return this.item;
	}
	public String getQuantity() {
		return this.quantity;
	}
	public String getTime() {
		return this.time;
	}
	public String getDate() {
		return this.date;
	}

	public String toString(){
		String str = "";
		str += "Food" + "\n"  + "Date: " + this.date + "\n"+ "Time: "+ this.time  + "\n" +"Name: "+ this.item + "\n" +"Quantity: "+this.quantity;
		return str;
	}
}
