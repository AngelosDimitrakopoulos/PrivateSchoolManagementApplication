
package model;

import java.util.ArrayList;


public class Trainer {
    
    private int trainer_id;
    private String first_name;
    private String last_name;
    private String subject_taught;

    public Trainer(int trainer_id, String first_name, String last_name) {
        this.trainer_id = trainer_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Trainer(int trainer_id, String first_name, String last_name, String subject_taught) {
        this.trainer_id = trainer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.subject_taught = subject_taught;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSubject_taught() {
        return subject_taught;
    }

    public void setSubject_taught(String subject_taught) {
        this.subject_taught = subject_taught;
    }
    
    
    
}
