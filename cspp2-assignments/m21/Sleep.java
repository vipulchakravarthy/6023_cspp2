class Sleep {
	private String date;
	private String startTime;
	private String endTime;
	Sleep(String date, String start, String end) {
		this.date = date;
		this.startTime = start;
		this.endTime = end;
	}
	public String getDate() {
		return date;
	}
	public String getStart() {
		return startTime;
	}
	public String getEnd() {
		return endTime;
	}
	public String toString() {
		String str = "";
		str += "Sleep" + "\n" + "Date:" + this.date + "\n" + "Starttime:" + this.startTime + "\n" + "Endtime:" + this.endTime;
		return str;
	}
}
