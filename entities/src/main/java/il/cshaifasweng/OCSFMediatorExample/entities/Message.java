package il.cshaifasweng.OCSFMediatorExample.entities;

import java.io.Serializable;

public class Message implements Serializable {
    String operation;
    Object message;
    int studentId;
    String subject;
    int newScore;
    String username;
    String password;

    public Message(String operation, Object message) {
        this.operation = operation;
        this.message = message;

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public String getOperation() {
        return operation;
    }


    public Object getMessage() {
        return message;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getSubject() {
        return subject;
    }
     public int getNewScore(){
        return newScore;
     }
    public void setOperation(String operation) {
        this.operation = operation;
    }


    public void setMessage(Object message) {
        this.message = message;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setNewScore(int newScore) {
        this.newScore = newScore;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getAction() {
        if(message instanceof String){
            return (String) message;
        }
        else {
            return null;
        }
    }
}
