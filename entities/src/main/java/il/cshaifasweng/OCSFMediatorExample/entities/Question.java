package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable
{
    private int QuestionID;
    private ArrayList<String> arrayOfAnswers;
    private String pupilAnswer;
    private String correctAnswer;
    private float score;

    Question(int QuestionID, ArrayList<String> arrayOfAnswers, String pupilAnswer, String correctAnswer, float score)
    {
        this.QuestionID = QuestionID;
        this.arrayOfAnswers = arrayOfAnswers;
        this.score = score;
        this.correctAnswer = correctAnswer;
        this.pupilAnswer = pupilAnswer;
    }

    public ArrayList<String> getArrayOfAnswers() {
        return arrayOfAnswers;
    }

    public float getScore() {
        return score;
    }

    public int getQuestionID() {
        return QuestionID;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getPupilAnswer() {
        return pupilAnswer;
    }

    public void setArrayOfAnswers(ArrayList<String> arrayOfAnswers) {
        this.arrayOfAnswers = arrayOfAnswers;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setPupilAnswer(String pupilAnswer) {
        this.pupilAnswer = pupilAnswer;
    }

    public void setQuestionID(int questionID) {
        QuestionID = questionID;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
