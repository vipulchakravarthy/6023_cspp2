import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
    /**
     *this variable is to store.
     *question text
     */
    private String questionText;
    /**
     * variable is to store options.
     */
    private String[] choices;
    /**
     *variable is to store correct answer.
     */
    private int correctAnswer;
    /**
     * to store maximum marks of a question.
     */
    private int maxMarks;
    /**
     *to give the penalty for wrong answer.
     */
    private int penalty;
    /**
     *to store response of the user.
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
    // /**
    //  * { function_description }.
    //  *
    //  * @param      choice  The choice
    //  *
    //  * @return     { description_of_the_return_value }
    //  */
    // public boolean evaluateResponse(final String choice) {
    //     if ( choice.equals(getcorrectAnswer())) {
    //         return true;
    //     } else {
    //     return false;
    //     }
    // }
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
     * @return     The choices array.
     */
    public String[] getChoice() {
        return choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks awarded.
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
        response = answer;
    }
    /**
     * Gets the response.
     *
     * @return     The response of user.
     */
    public String getResponse() {
        return response;
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
     * to declare a array size with a variable.
     */
    private final int onehundred = 100;
    /**
     *questions array to store all questions.
     */
    private Question[] questions;
    /**
     *to store the size of array.
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
     * to be added to questions array
     */
    public void addQuestion(final Question q) {
        questions[size++] = q;
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question at that
     * index.
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
    /**
     * this method gives the size of quiz object.
     * @return size of the quiz object
     */
    public int size() {
        return size;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * the question class object with.
     * private specifier.
     */
    private static Question questionObj;
     /**
     * Constructs the object.
     */
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
     * @param      scan       The scan obj to
     * take the input from the user
     * @param      quiz       The quiz obj to
     * access all the methods.
     * @param      q          The question count
     * it gives the number of questions to load
     *
     */
    public static void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        final int five = 5;
        final int four = 4;
        final int three = 3;
        if (q > 0) {
            for (int i = 0; i < q; i++) {
                String line = scan.nextLine();
                String[] tokens = line.split(":");
                String[] choices = tokens[1].split(",");
                if (tokens[0].length() == 0 || tokens.length < five) {
                    System.out.println("Error! Malformed question");
                    return;
                }
                if (choices.length < 2) {
                System.out.println(
                "trick question  does not have "
                + "enough answer choices");
                    return;
                }
                if (Integer.parseInt(tokens[2])
                    > four && choices.length == four) {
                System.out.println(
                "Error! Correct answer choice number "
                + "is out of range for question text 1");
                return;
                }
                if (Integer.parseInt(tokens[three]) < 0) {
                    System.out.println("Invalid max"
                        + " marks for question about sony");
                    return;
                }
                if (Integer.parseInt(tokens[four]) > 0) {
                    System.out.println("Invalid penalty "
                        + "for question about sony");
                    return;
                }
                questionObj = new Question(tokens[0], choices,
                    Integer.parseInt(tokens[2]), Integer.parseInt(
                        tokens[three]), Integer.parseInt(tokens[four]));
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
     * @param      scan  The scan object to scan
     * input from user
     * @param      quiz  The quiz obj to
     * access all the methods.
     * @param      q     The answer count
     * number of answers given by user
     */
    public static void startQuiz(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        final int three = 3;
        if (quiz.size() > 0) {
        for (int i = 0; i < quiz.size(); i++) {
            System.out.println(quiz.getQuestion(i).getQuestionText()
                + "(" + quiz.getQuestion(i).getMaxMarks() + ")");
            String[] options = quiz.getQuestion(i).getChoice();
            if (options.length > 2) {
            System.out.println(options[0] + "\t" + options[1]
                + "\t" + options[2] + "\t" + options[three] + "\n");
            } else if (options.length == 2) {
                System.out.println(options[0] + "\t" + options[1] + "\n");
            }
        }
        for (int j = 0; j < q; j++) {
            String line = scan.nextLine();
            quiz.getQuestion(j).setResponse(line);
        }
    }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object to
     * access all the methods.
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
    if (quiz.size() > 0) {
        int score = 0;
        for (int i = 0; i < quiz.size(); i++) {
            System.out.println(quiz.getQuestion(i).getQuestionText());
            String[] values = quiz.getQuestion(i).getChoice();
            if (values[(quiz.getQuestion(i).getCorrectAnswer()) - 1]
                .equals(quiz.getQuestion(i).getResponse())) {
                System.out.println(" Correct Answer! - Marks Awarded: "
                    + quiz.getQuestion(i).getMaxMarks());
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

