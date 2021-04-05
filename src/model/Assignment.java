
package model;

import java.sql.*;
import java.time.*;



public class Assignment {
    
    private int assignment_id;
    private String title;
    private String as_description;
    private Timestamp sub_date_time;
    private int course_id;
    private int oral_mark;
    private int total_mark;


    public Assignment(int assignment_id, String title, String as_description, Timestamp sub_date_time) {
        this.assignment_id = assignment_id;
        this.title = title;
        this.as_description = as_description;
        this.sub_date_time = sub_date_time;
    }

    public Assignment(int assignment_id, String title, String as_description, Timestamp sub_date_time, int course_id) {
        this.assignment_id = assignment_id;
        this.title = title;
        this.as_description = as_description;
        this.sub_date_time = sub_date_time;
        this.course_id = course_id;
    }

    public Assignment(int assignment_id, String title, String as_description, Timestamp sub_date_time, int oral_mark, int total_mark) {
        this.assignment_id = assignment_id;
        this.title = title;
        this.as_description = as_description;
        this.sub_date_time = sub_date_time;
        this.oral_mark = oral_mark;
        this.total_mark = total_mark;
    }


    public int getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(int assignment_id) {
        this.assignment_id = assignment_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAs_description() {
        return as_description;
    }

    public void setAs_description(String as_description) {
        this.as_description = as_description;
    }

    public Timestamp getSub_date_time() {
        return sub_date_time;
    }

    public void setSub_date_time(Timestamp sub_date_time) {
        this.sub_date_time = sub_date_time;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getOral_mark() {
        return oral_mark;
    }

    public void setOral_mark(int oral_mark) {
        this.oral_mark = oral_mark;
    }

    public int getTotal_mark() {
        return total_mark;
    }

    public void setTotal_mark(int total_mark) {
        this.total_mark = total_mark;
    }
    
    
    
    
    
}
