package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "Questions")
public class QuestionRepository implements Serializable
{
    ArrayList<Question> listOfQuestions;

}
