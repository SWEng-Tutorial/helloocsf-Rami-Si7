package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Teacher extends User implements Serializable
{
    private String Subject;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacher")
    private ArrayList<Exam> ExamsOfTheTeacher;

    Teacher(String firstName, String lastName, int id, String username, String password, ArrayList<Exam> ExamsOfTheTeacher)
    {
        super(firstName, lastName, id, username, password);
        this.ExamsOfTheTeacher = new ArrayList<Exam>();
    }

    public ArrayList<Exam> getExamsOfTheTeacher() {
        return ExamsOfTheTeacher;
    }

    public String getSubject() {
        return Subject;
    }

    public void setExamsOfTheTeacher(ArrayList<Exam> examsOfTheTeacher) {
        ExamsOfTheTeacher = examsOfTheTeacher;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
    public void addExam(Exam exam)
    {
        this.ExamsOfTheTeacher.add(exam);
    }
}
