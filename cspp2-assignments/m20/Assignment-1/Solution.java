import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
    /**
     * { var_description }.
     */
    private String questionText;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private int correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
        final int correctAnswer1, final int maxMarks1, final int penalty1) {
        this.correctAnswer = correctAnswer1;
        this.questionText = question1;
        this.choices = choices1;
        this.penalty = penalty1;
        this.maxMarks = maxMarks1;
    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    // public boolean evaluateResponse(final String choice) {
    //     if ( response.equals(correctAnswer)) {
    //         return true;
    //     } else {
    //     return false;
    //     }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return questionText;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return choices ;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        String[] answers = answer.split(" ");
        response = answers[1];
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public int getResponse() {
        return Integer.parseInt(response);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        return s;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions ;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        questions = new Question[onehundred];
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        questions[size++] = q;
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        String s = "";
        return s;
    }
    public int size() {
        return size;
    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    public static Question questionObj;
    private Solution() {
        // leave this blank
        questionObj = new Question();
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
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (q > 0) {
            for (int i = 0; i < q; i++) {
                String line = scan.nextLine();
                String[] tokens = line.split(":");
                String[] choices = tokens[1].split(",");
                if (tokens[0].length() == 0 || tokens[4].length() == 0) {
                    System.out.println("Error! Malformed question");
                    return;
                }
                if (choices.length < 2) {
                    System.out.println("trick question  does not have enough answer choices");
                    return;
                }
                if (Integer.parseInt(tokens[2]) > 4 && choices.length == 4) {
                    System.out.println("Error! Correct answer choice number is out of range for question text 1");
                    return;
                }
                if (Integer.parseInt(tokens[3]) < 0 ) {
                    System.out.println("Invalid max marks for question about sony");
                    return;
                }
                if (Integer.parseInt(tokens[4]) > 0) {
                    System.out.println("Invalid penalty for question about sony");
                    return;
                }
                questionObj = new Question(tokens[0], choices, Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
                quiz.addQuestion(questionObj);
            }
            System.out.println(q + " are added to the quiz");
            return;
        } else {
            System.out.println("Quiz does not have questions");
        }
    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        String[] options = questionObj.getChoice();
        for (int i = 0; i < quiz.size(); i++) {
            System.out.println(quiz.getQuestion(i).getQuestionText() + "(" + quiz.getQuestion(i).getMaxMarks() + ")");
            System.out.println(options[0] + "\t" + options[1] + "\t" + options[2] + "\t" + options[3] + "\n");
        }
        for (int j = 0; j < q; j ++) {
            String line = scan.nextLine();
            quiz.getQuestion(j).setResponse(line);
        }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
    if (quiz.size() > 0) {
        int score = 0;
        for (int i = 0; i < quiz.size(); i++) {
            System.out.println(quiz.getQuestion(i).getQuestionText());
            if (quiz.getQuestion(i).getCorrectAnswer() == (quiz.getQuestion(i).getResponse())) {
                System.out.println(" Correct Answer! - Marks Awarded: "
                    + quiz.getQuestion(i).getMaxMarks() );
                score += quiz.getQuestion(i).getMaxMarks();
            } else {
                System.out.println(" Wrong Answer! - Penalty: "
                    + quiz.getQuestion(i).getPenalty());
                score += quiz.getQuestion(i).getPenalty();
            }
        }
    System.out.println("Total Score: " + score);
    } else {
        return;
    }
}
}
