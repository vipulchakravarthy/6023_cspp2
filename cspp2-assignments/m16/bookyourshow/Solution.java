import java.util.Scanner;
import java.util.Arrays;
/**
 *Each ​Show  should have the following information
 *about the event it describes.
 *The constructor should take a three parameters
 *the name of the movie,
 *the show date and time ​, and the seats.
 */
class Show {
	/**the varaible is declared with private specifier.
	*/
	private String movieName;
	/**the varaible is declared with private specifier.
	*/
	private String time;
	/**the varaible is declared with private specifier.
	*/
	private String[] seats;
	/**
	 * this is a Show constructor.
	 * @param      movie  The movie
	 * @param      time   The time
	 * @param      seats  The seats
	 */
	public Show(final String movie, final String time,
	 final String[] seats) {
		this.movieName = movie;
		this.time = time;
		this.seats = seats;
	}
	/**this method gives the movie name.
	*@return movieName which is the
	*name of the movie
	*/
	public String getMovieName() {
		return this.movieName;
	}
	/**this method gives the movie time.
	*@return time which is the
	*show timing and date
	*/
	public String getTime() {
		return this.time;
	}
	/**this method gives the available seats.
	*@return seats which are available
	*/
	public String[] getSeats() {
		return this.seats;
	}
	/**this method changes the booked seats.
	*with given text
	*/
	public void setSeats(final int index, final String text) {
		seats[index] = text;
	}
	/**this method gives the movie name and.
	*time , date.
	*@return movieName and time which is of
	*String type
	*/
	public String toString() {
		return this.movieName + "," + this.time;
	}
}
/**
 * the book your show method is to.
 * do all the possible operations for
 * booking a ticket.
 */
class  BookYourShow {
	/**
	 * the moviedetails  is the object of.
	 * show type for list class.
	 */
	private List<Show> movieDetails = new List<Show>();
	/**
	 * the reserved tickets is object of list class and.
	 * String type.
	 */
	private List<String> reservedTickets;
	/**
	 * this is a constructor for book your show.
	 */
	public BookYourShow() {
	reservedTickets = new List<String>();
	}
	/**
	 * the method is to add a show to the.
	 * movieDetails object
	 * @param      showObj  The show object
	 * which sends the movie name, timings
	 * available seats
	 */
	public void addAShow(final Show showObj) {
		movieDetails.add(showObj);
	}
	/**
	 * this method gives the show details.
	 * @param      movie  The movie name to get
	 * the show
	 * @param      time   The time for which we need
	 * a movie
	 * @return     about the show details
	 * for the required movie.
	 */
	public Show getAShow(final String movie, final String time) {
		for (int i = 0; i < movieDetails.size(); i++) {
			if (movie.equals(movieDetails.get(i).getMovieName())
			 && time.equals(movieDetails.get(i).getTime())) {
				return movieDetails.get(i);
			}
		}
		return null;
	}
	/**
	 * this method allows us to book a show.
	 * @param      movieName  The movie name
	 * which the user is required.
	 * @param      time   the time when to book.
	 * @param      obj the object gives the mobile
	 * number and name of user
	 * @param      seats the seats which he want
	 * to book
	 */
	public void bookAShow(final String movieName,
	final String time, final Patron obj, final String[] seats) {
	Show movieData = getAShow(movieName, time);
	if (movieData != null) {
		for (int i = 0; i < movieData.getSeats().length; i++) {
			for (int j = 0; j < seats.length; j++) {
				if (seats[j].equals(movieData.getSeats()[i])) {
					movieData.setSeats(i, "N/A");
					reservedTickets.add(
						obj.getMobileNumber() + " " + movieName + " " + time);
				}
			}
		}
	} else {
		System.out.println("No show");
	}
	}
	/**
	 *this method prints the booked ticket.
	 * @param      movieName the movie which
	 * he had booked
	 * @param      time  The time which he had
	 * booked for a show
	 * @param      mobileNumber  The mobile number
	 * of the user
	 */
	public void printTicket(final String movieName,
		final String time, final String mobileNumber) {
		for (int i = 0; i < reservedTickets.size(); i++) {
			if ((mobileNumber + " " + movieName + " " + time).equals(reservedTickets.get(i))) {
				System.out.println(mobileNumber + " " + movieName + " " + time);
				return;
			}
		}
		System.out.println("Invalid");
		return;
	}
	/**
	 * the method is to show all the.
	 * available shows
	 */
	public void showAll() {
		for (int i = 0; i < movieDetails.size(); i++) {
			System.out.println(movieDetails.get(i).toString() + "," +
				Arrays.toString(movieDetails.get(i).getSeats()).replace(" ",""));
		}
	}
}
/**
 * the class is to give the details.
 * of user
 */
class Patron {
	/**
	 * the name of the user.
	 * with private specifier
	 */
	private String name;
	/**
	 * the number of the user.
	 * with private specifier
	 */
	private String mobileNumber;
	/**
	 * this is constructor for patron class.
	 * @param      user    The name of user
	 * @param      mobile the mobile number
	 * of user
	 */
	public Patron(final String user, final String mobile) {
		this.name = user;
		this.mobileNumber = mobile;
	}
	/**
	 * this method is to give the.
	 *name of the user.
	 * @return The name of user
	 */
	public String getName() {
		return this.name;
	}
	/**
	 *it gives the mobile number.
	 *of user
	 * @return The mobile number
	 * of user.
	 */
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


