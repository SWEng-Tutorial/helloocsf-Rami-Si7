package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Exam implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examID")
    private int examID;

    @Column(name = "teacherName")
    private String teacherName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exam")
    private ArrayList<Question> listOfQuestions;

    @Column(name = "examPeriod")
    private int examPeriod;

    @Column(name = "teacherComments")
    private String teacherComments;

    @Column(name = "studentComments")
    private String studentComments;

    Exam(int examID, String teacherName, ArrayList<Question> listOfQuestions, int examPeriod, String teachComments, String studentComments)
    {
        this.examID = examID;
        this.examPeriod = examPeriod;
        this.listOfQuestions = new ArrayList<Question>();
        this.studentComments = studentComments;
        this.teacherComments = teachComments;
        this.teacherName = teacherName;
    }

    void addQuestion(Question question)
    {
        listOfQuestions.add(question);
    }
    public int getExamID() {
        return examID;
    }

    public ArrayList<Question> getListOfQuestions() {
        return listOfQuestions;
    }

    public int getExamPeriod() {
        return examPeriod;
    }

    public String getStudentComments() {
        return studentComments;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public String getTeachComments() {
        return teacherComments;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setExamPeriod(int examPeriod) {
        this.examPeriod = examPeriod;
    }

    public void setListOfQuestions(ArrayList<Question> listOfQuestions) {
        this.listOfQuestions = listOfQuestions;
    }

    public void setStudentComments(String studentComments) {
        this.studentComments = studentComments;
    }

    public void setTeachComments(String teachComments) {
        this.teacherComments = teachComments;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}

