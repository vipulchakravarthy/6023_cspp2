class Water {
	private String quantity;
	private String date;
	private String time;
	Water(String quantity, String date, String time) {
		this.quantity = quantity;
		this.date = date;
		this.time = time;
	}
	public String getQuantity() {
		return quantity;
	}
	public void increase(double q) {
		quantity += q;
	}
	public String getDate() {
		return date;
	}
	public String toString() {
		String str = "";
		str += "Water" + "\n" + "Date:" + this.date + "\n" + "Quantity:" + this.quantity;
		return str;
	}
}
