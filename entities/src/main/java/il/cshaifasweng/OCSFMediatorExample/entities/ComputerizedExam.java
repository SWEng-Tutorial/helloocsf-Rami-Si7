package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "computerziedExams")
public class ComputerizedExam extends Exam implements Serializable
{
    @Column(name = "timeCounter")
    private  int timeCounter;

    private int IDcode;
    ComputerizedExam(int examID, String teacherName, ArrayList<Question> listOfQuestions, int examPeriod, String teachComments, String studentComments, int timeCounter,  int IDcode) {
        super(examID, teacherName, listOfQuestions, examPeriod, teachComments, studentComments);
        this.timeCounter = timeCounter;
        this.IDcode = IDcode;
    }

    public int getTimeCounter() {
        return timeCounter;
    }

    public void setTimeCounter(int timeCounter) {
        this.timeCounter = timeCounter;
    }

    public int getIDcode() {
        return IDcode;
    }

    public void setIDcode(int IDcode) {
        this.IDcode = IDcode;
    }
}
