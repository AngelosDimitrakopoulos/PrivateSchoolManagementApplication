
package io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.*;
import dbConnection.DbConnector;


public class InputOutput {
    

    public static Scanner useInputStream() {
        Scanner scan = new Scanner(System.in);
        return scan;
    }
    
    public static String selectCourseTitle(){
        String course_title = "";
        int another = 1;
        do {
            int answer = 0;
            do {//amintikos programmatismos na dosei egkiro imput stin epilogi object
                System.out.println("Select Course Title:");
                System.out.print("0: exit, 1: CB8, 2: CB9 >> ");
                answer = ValidateInputs.validateIntegerTypeOfData();

                switch (answer) {
                    case 0:
                        System.out.println("you will exit");
                        break;
                    case 1:
                        course_title = "CB8";
                        break;
                    case 2:
                        course_title = "CB9";
                        break;
                    default:
                        System.out.println("invalid input, please type again");
                        break;
                }
            } while (!(answer == 0 || answer == 1 || answer == 2));
            
        }while (!(another == 0 || another == 1));
        return course_title;
    }
    
    public static String selectCourseStream(){
        String course_stream = "";
        int another = 1;
        do {
            int answer = 0;
            do {//amintikos programmatismos na dosei egkiro imput stin epilogi object
                System.out.println("Select Course Stream:");
                System.out.print("0: exit, 1: Java, 2: C# >> ");
                answer = ValidateInputs.validateIntegerTypeOfData();

                switch (answer) {
                    case 0:
                        System.out.println("you will exit");
                        break;
                    case 1:
                        course_stream = "Java";
                        break;
                    case 2:
                        course_stream = "C#";
                        break;
                    default:
                        System.out.println("invalid input, please type again");
                        break;
                }
            } while (!(answer == 0 || answer == 1 || answer == 2));
                
        }while (!(another == 0 || another == 1));
        
        return course_stream;
    }
    
    public static String selectCourseType(){
        String course_type = "";
        int another = 1;
        do {
            int answer = 0;
            do {//amintikos programmatismos na dosei egkiro imput stin epilogi object
                System.out.println("Select Course Type:");
                System.out.print("0: exit, 1: Full Time, 2: Part Time >> ");
                answer = ValidateInputs.validateIntegerTypeOfData();

                switch (answer) {
                    case 0:
                        System.out.println("you will exit");
                        break;
                    case 1:
                        course_type = "Full Time";
                        break;
                    case 2:
                        course_type = "Part Time";
                        break;
                    default:
                        System.out.println("invalid input, please type again");
                        break;
                }
            } while (!(answer == 0 || answer == 1 || answer == 2));
            
        }while (!(another == 0 || another == 1));
        return course_type;
    }
    
    public static int selectStudentId(String courseTitle, String courseStream, String courseType){
        int student_id = 0;
        int another = 1;
        DbConnector dbconnector = new DbConnector();
        List<Student> totalListOfStudents = new ArrayList<>(dbconnector.getAllEnrolledStudents());
        do {
            int answer = 0;
            do {//amintikos programmatismos na dosei egkiro imput stin epilogi object
                ArrayList<Student> studentPerCourseListToShow = new ArrayList<>(dbconnector.getStudentsPerCourse(courseTitle, courseStream, courseType));
                System.out.println("Choose from the following students: \n");
                printStudentsPerCourse(studentPerCourseListToShow);
                System.out.println("\nSelect Student (typing student id from the selected):");
                answer = ValidateInputs.validateIntegerTypeOfData();
                System.out.println("");

            } while (!(answer>0 && answer<=totalListOfStudents.size()));
            
            student_id = answer;
            
        }while (!(another == 0 || another == 1));
        return student_id;
    }
    
    public static void printCourses(List<Course> courseList){
        for (Course course: courseList) {
                        System.out.println("course id: " + course.getCourse_id()
                                + " title: " + course.getTitle()
                                + ", stream: " + course.getStream()
                                + ", type: " + course.getType()
                                + ", start date: " + course.getStart_date()
                                + ", end date: " + course.getEnd_date()
                        );
                    }    
        System.out.println("");
    }
    
    public static void printEnrolledStudents(List<Student> enrolledStudentList){
        for (Student student: enrolledStudentList) {
                        System.out.println("student id: " + student.getStudent_id()
                                + " first name: " + student.getFirstname()
                                + ", last name: " + student.getLastname()
                                + ", date of birth: " + student.getDate_of_birth()
                                + ", tuition fees: " + student.getTuition_fees()
                        );
                    }
        System.out.println("");
    }
    
    public static void printStudents(List<Student> studentList){
        for (Student student: studentList) {
                        System.out.println("student id: " + student.getStudent_id()
                                + " first name: " + student.getFirstname()
                                + ", last name: " + student.getLastname()
                                + ", date of birth: " + student.getDate_of_birth()
                        );
                    }
        System.out.println("");
    }
    
    public static void printTrainersWithoutSubjects(List<Trainer> trainerList){
        for (Trainer trainer: trainerList) {
                        System.out.println("trainer id: " + trainer.getTrainer_id()
                                + " first name: " + trainer.getFirst_name()
                                + ", last name: " + trainer.getLast_name()
                        );
                    }
        System.out.println("");
    }
    
    public static void printTrainersWithSubjects(List<Trainer> trainerList){
        for (Trainer trainer: trainerList) {
                        System.out.println("first name: " + trainer.getFirst_name()
                                + ", last name: " + trainer.getLast_name()
                                + ", subject: " + trainer.getSubject_taught()
                        );
        }    
        System.out.println("");
    }
    
    public static void printAssignments(List<Assignment> assignmentList){
        for (Assignment assignment: assignmentList) {
                        System.out.println("title: " + assignment.getTitle()
                                + ", description: " + assignment.getAs_description()
                                + ", submission date and time: " + assignment.getSub_date_time()
                        );
        }
        System.out.println("");
    }
    
    public static void printStudentsPerCourse(List<Student> studentsPerCourseList){
        for (Student student: studentsPerCourseList) {
                        System.out.println("student id: " + student.getStudent_id()
                                + " first name: " + student.getFirstname()
                                + ", last name: " + student.getLastname()
                                + ", date of birth: " + student.getDate_of_birth()
                                + ", tuition fees: " + student.getTuition_fees()
                        );
                    }   
        System.out.println("");
    }
    
    public static void printTrainersPerCourse(List<Trainer> trainersPerCourseList){
        for (Trainer trainer: trainersPerCourseList) {
                        System.out.println("first name: " + trainer.getFirst_name()
                                + ", last name: " + trainer.getLast_name()
                        );
                    }
        System.out.println("");
    }
    
    public static void printAssignmentsPerCourse(List<Assignment> assignmentsPerCourseList){
        for (Assignment assignment: assignmentsPerCourseList) {
                        System.out.println("title: " + assignment.getTitle()
                                + ", description: " + assignment.getAs_description()
                                + ", submission date and time: " + assignment.getSub_date_time()
                        );
                    }   
        System.out.println("");
    }
    
    public static void printAssignmentsPerStudentPerCourse(List<Assignment> assignmentsPerStudentPerCourseList){
        for (Assignment assignment: assignmentsPerStudentPerCourseList) {
                        System.out.println("title: " + assignment.getTitle()
                                + ", description: " + assignment.getAs_description()
                                + ", submission date and time: " + assignment.getSub_date_time()
                                + ", oral mark: " + assignment.getOral_mark()
                                + ", total mark: " + assignment.getTotal_mark()
                        );
                    }    
        System.out.println("");
    }
    
}
