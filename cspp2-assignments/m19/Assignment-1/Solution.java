import java.util.Scanner;
import java.util.Arrays;
/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    public static List<Quiz> quizObj = new List<Quiz>();
    public static  Quiz questionObj;
    public static Quiz responseObj;
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
    	if (questionCount > 0) {
        	for (int i = 0; i < questionCount; i++) {
        		String line = s.nextLine();
        		String[] tokens = line.split(":");
        		if (tokens.length == 5) {
        		String[] answers = tokens[1].split(",");
        		if (tokens[0].length() == 0 || tokens[3].length() == 0
                    || tokens[1].length() == 0 || tokens[2].length() == 0 || tokens[4].length() == 0) {
        			System.out.println("Error! Malformed question");
        			return;
        		}
        		if (Integer.parseInt(tokens[2]) > 4 && answers.length == 4) {
        			System.out.println("Error! Correct answer choice number is out of range for question text 1");
        			return;
				}
				if (answers.length < 2) {
					System.out.println("trick question  does not have enough answer choices");
					return;
				}
				if (Integer.parseInt(tokens[3]) < 0) {
					System.out.println("Invalid max marks for question about sony");
					return;
				}
				if (Integer.parseInt(tokens[4]) > 0) {
					System.out.println("Invalid penalty for question about sony");
					return;
				}
        		questionObj = new Quiz(tokens[0], answers, tokens[2],
        		tokens[3],tokens[4]);
        		quizObj.add(questionObj);
        		}
        	}
        System.out.println(questionCount + " are added to the quiz");
    	} else {
    		System.out.println("Quiz does not have questions");
    	}
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
       for (int i = 0; i < quizObj.size(); i++) {
       	System.out.println(quizObj.get(i).getQuestion()+"("+quizObj.get(i).getMarks()+")");
       	String[] options = quizObj.get(i).getOptions();
       	System.out.println(options[0] + "\t" + options[1] + "\t"
       		+ options[2] + "\t" + options[3] +"\n");
       	 }

       String[] response = new String[answerCount];
        for (int i = 0; i < answerCount; i++) {
        	String line  = s.nextLine();
        	String[] responseArray = line.split(" ");
        	response[i] = responseArray[1];
        }
        responseObj = new Quiz(response);
}
    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
    	if (quizObj.size() > 0) {
    	int score = 0;
    	for (int i = 0; i < quizObj.size(); i++) {
    		System.out.println(quizObj.get(i).getQuestion());
    		if (quizObj.get(i).getAnswer().equals(responseObj.getResponses(i))) {
    			System.out.println(" Correct Answer! - Marks Awarded: "
    				+ quizObj.get(i).getMarks() );
    			score += Integer.parseInt(quizObj.get(i).getMarks());
    		} else {
    			System.out.println(" Wrong Answer! - Penalty: "
    				+ quizObj.get(i).getPenality());
    			score += Integer.parseInt(quizObj.get(i).getPenality());
    		}
    }
    System.out.println("Total Score: " + score);
    } else {
    	return;
}
}
}
class Quiz {
	private String  question;
	private String[] options;
	private String marks;
	private String answer;
	private String penality;
	private String[] responses;
	Quiz(){

	}
	Quiz(String ques, String[] choices,
		String correct, String marks, String penality) {
		this.question = ques;
		this.options = choices;
		this.answer = correct;
		this.marks = marks;
		this.penality = penality;
	}
	Quiz(String[] response) {
		this.responses = response;
	}
	public String getQuestion() {
		return this.question;
	}

	public String[] getOptions() {
		return this.options;
	}
	public String getMarks() {
		return this.marks;
	}
	public String getAnswer() {
		return this.answer;
	}
	public String getPenality() {
		return this.penality;
	}
	public String getResponses(int index) {
		return responses[index];
	}
}
