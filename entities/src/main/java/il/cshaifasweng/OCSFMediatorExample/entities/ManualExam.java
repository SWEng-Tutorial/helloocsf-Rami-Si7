package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "ManualExams")
public class ManualExam extends Exam implements Serializable
{
    private int timeCounter;
    ManualExam(int examID, String teacherName, ArrayList<Question> listOfQuestions, int examPeriod, String teachComments, String studentComments, int timeCounter) {
        super(examID, teacherName, listOfQuestions, examPeriod, teachComments, studentComments);
        this.timeCounter = timeCounter;
    }

    public int getTimeCounter() {
        return timeCounter;
    }

    public void setTimeCounter(int timeCounter) {
        this.timeCounter = timeCounter;
    }
}
