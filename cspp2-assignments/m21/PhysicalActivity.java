class PhysicalActivity {
	private String activity;
	private String date;
	private String startTime;
	private String endTime;
	private String notes;
	PhysicalActivity(String activity, String notes, String date, String start, String end) {
		this.activity = activity;
		this.startTime = start;
		this.endTime = end;
		this.notes = notes;
		this.date = date;
	}
	public String getActivity() {
		return activity;
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
	public String getNotes() {
		return notes;
	}
	public  String toString() {
		String str = "";
		str += "PhysicalActivity" + "\n" + "Names:" + this.activity + "\n" + "Notes:" + this.notes +"\n"
		+ "Date:" + this.date + "\n"+ "Starttime:" + this.startTime + "\n" + "Endtime:" + this.endTime;
		return str;
	}
}
