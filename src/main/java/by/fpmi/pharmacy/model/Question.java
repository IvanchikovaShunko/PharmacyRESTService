package by.fpmi.pharmacy.model;

import javax.persistence.*;

@Entity
@Table(name = "QUESTION")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "QUESTION_ID", nullable = false)
    private long questionID;

    @Column(name = "QUESTION", nullable = false)
    private String question;

    @Column(name = "ANSWER1", nullable = false)
    private String answer1;

    @Column(name = "ANSWER2", nullable = false)
    private String answer2;

    @Column(name = "ANSWER3", nullable = false)
    private String answer3;

    @Column(name = "ANSWER4", nullable = false)
    private String answer4;

    @Column(name = "CORRECT_ANSWER_ID", nullable = false)
    private int correctID;

    @Column(name = "SCORE", nullable = false)
    private int score;


    public Question() {
    }

    public Question(int questionID, String question, String answer1, String answer2, String answer3, String answer4, int correctID, int score) {
        this.questionID = questionID;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctID = correctID;
        this.score = score;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public int getCorrectID() {
        return correctID;
    }

    public void setCorrectID(int correctID) {
        this.correctID = correctID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getQuestionID() {
        return questionID;
    }
}
