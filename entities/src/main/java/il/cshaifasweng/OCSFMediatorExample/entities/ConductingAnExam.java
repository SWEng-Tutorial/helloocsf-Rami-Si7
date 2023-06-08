package il.cshaifasweng.OCSFMediatorExample.entities;

import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "User")
public abstract class ConductingAnExam
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "testId")
    private int id;
    @Column(name = "testDate")
    private String testDate;

    @Column(name = "testTime")
    private LocalTime testTime;

    @Column(name = "executionCode")
    private String executionCode;

    @Column(name = "teacher")
    private String teacherName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "")
    private ArrayList<Student> students;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "examId")
    private Exam examToExecute;

    ConductingAnExam(int id, String testDate, LocalTime testTime, String executionCode, String teacherName, Exam exam)
    {
        this.examToExecute = exam;
        this.executionCode = executionCode;
        this.id = id;
        this.teacherName = teacherName;
        this.testDate = testDate;
        this.students = new ArrayList<Student>();
        this.testTime = testTime;
    }
    public void setTestDate(LocalDate testDate)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
        this.testDate = formatter.format(testDate);
    }
    public void addStudent(Student student)
    {
        this.students.add(student);
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Exam getExamToExecute() {
        return examToExecute;
    }

    public LocalTime getTestTime() {
        return testTime;
    }

    public String getExecutionCode() {
        return executionCode;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setExamToExecute(Exam examToExecute) {
        this.examToExecute = examToExecute;
    }

    public void setExecutionCode(String executionCode) {
        this.executionCode = executionCode;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public void setTestTime(LocalTime testTime) {
        this.testTime = testTime;
    }
}
