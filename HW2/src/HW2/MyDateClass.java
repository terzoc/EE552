package HW2;

public class MyDateClass {
	
	int month, date, year;
	
	private void setDate(int month, int date, int year) {
		this.month = month;
		this.date = date;
		this.year = year;
	}
	
	private String getDate() {
		String output = "";
		switch(this.month) {
			case 1:
				output += "Jan";
				break;
			case 2:
				output += "Feb";
				break;
			case 3:
				output += "Mar";
				break;
			case 4:
				output += "Apr";
				break;
			case 5:
				output += "May";
				break;
			case 6:
				output += "Jun";
				break;
			case 7:
				output += "Jul";
				break;
			case 8:
				output += "Aug";
				break;
			case 9:
				output += "Sep";
				break;
			case 10:
				output += "Oct";
				break;
			case 11:
				output += "Nov";
				break;
			case 12:
				output += "Dec";
				break;
			default:
				output += "No Month";
		}
		String yearDisp;
		if (this.year < 10) {
			yearDisp = "0" + this.year;
		}else {
			yearDisp = Integer.toString(this.year);
		}
		output += "/" + this.date + "/" + yearDisp;
		return output;
	}

	public static void main(String [] args) {

		// instantiate object
		MyDateClass obj = new MyDateClass();

		//set date values
		obj.setDate(5,25,00);

		// display date
		System.out.println(obj.getDate());

		// display name
		System.out.println("Corvin Terzo");

		} // end main

}
