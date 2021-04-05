
package model;

import java.sql.Date;


public class Student {
    
    private int student_id;
    private String firstname;
    private String lastname;
    private Date date_of_birth;
    private double tuition_fees;

    public Student(int student_id, String firstname, String lastname, Date date_of_birth) {
        this.student_id = student_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.date_of_birth = date_of_birth;
    }
    
    public Student(int student_id, String firstname, String lastname, Date date_of_birth, double tuition_fees) {
        this.student_id = student_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.date_of_birth = date_of_birth;
        this.tuition_fees = tuition_fees;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
    
        public double getTuition_fees() {
        return tuition_fees;
    }

    public void setTuition_fees(double tuition_fees) {
        this.tuition_fees = tuition_fees;
    }
    
    
}
