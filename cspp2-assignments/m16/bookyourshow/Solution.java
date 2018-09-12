import java.util.Scanner;
class Show {
	private String movieName;
	private String time;
	private String[] seats;
	public Show(String movie, String time, String[] seats) {
		this.movieName = movie;
		this.time = time;
		this.seats = seats;
	}
	public String getMovieName() {
		return this.movieName;
	}
	public String getTime() {
		return this.time;
	}
	public String[] getSeats() {
		return this.seats;
	}
	public void setSeats(int index, String text) {
		seats[index] = text;
	}
}
class  BookYourShow {
	List<Show> movieDetails = new List<Show>();
	List<String> reservedTickets;
	public BookYourShow() {
	reservedTickets = new List<String>();
	}
	public void addAShow(Show showObj) {
		movieDetails.add(showObj);
	}
	public Show getAShow(String movie, String time) {
		for (int i = 0; i < movieDetails.size(); i++) {
			if (movie.equals(movieDetails.get(i).getMovieName()) && time.equals(movieDetails.get(i).getTime())) {
				return movieDetails.get(i);
			}
		}
		return null;
	}
	public String bookAShow(String movieName, String time, Patron obj, String[] seats) {
		Show movieData = getAShow(movieName, time);
		for (int i = 0; i < movieData.getSeats().length; i++) {
			for (int j = 0; j < seats.length; j++) {
				if (seats[j].equals(movieData.getSeats()[i])) {
					movieData.setSeats(i, "N/A");
					reservedTickets.add(obj.getMobileNumber()+" "+movieName+" "+time);
				}
			}
		}
		return "";
	}
	public void printTicket(String movieName, String time, String mobileNumber) {
		for (int i = 0; i < reservedTickets.size(); i++) {
			if ((mobileNumber+" "+movieName+" "+time).equals(reservedTickets.get(i))) {
				System.out.println(mobileNumber+" "+movieName+" "+time);
				break;
			}
		}
	}

	public void showAll() {
		for (int i = 0; i < movieDetails.size(); i++) {
			System.out.println(movieDetails.get(i).toString());
		}
	}
}
class Patron {
	private String name;
	private String mobileNumber;
	public Patron(String user, String mobile) {
		this.name = user;
		this.mobileNumber = mobile;
	}
	public String getName() {
		return this.name;
	}
	public String getMobileNumber() {
		return this.mobileNumber;
	}
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    Show showObj = new Show(check[1], tokens[1], seats);
                    bys.addAShow(showObj);
                break;

                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show);
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                    bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}


