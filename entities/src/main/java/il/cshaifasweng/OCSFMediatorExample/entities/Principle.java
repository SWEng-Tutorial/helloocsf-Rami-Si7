package il.cshaifasweng.OCSFMediatorExample.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
public class Principle extends User implements Serializable
{
    Principle(String firstName, String lastName, int id, String username, String password)
    {
        super(firstName, lastName, id, username, password);
    }
}
