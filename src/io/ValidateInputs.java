package io;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import model.Course;
import model.Student;
import model.Trainer;

public class ValidateInputs {

    public static int validateIntegerTypeOfData() {
        int answer;
        boolean done = false;
        do {
            try {
                System.out.print("Please type >>  ");
                answer = InputOutput.useInputStream().nextInt();
                done = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid integer input");
                answer = 100;
            }
        } while (done == false);

        return answer;
    }

    public static double validateFeesData() {
        double answer;
        boolean done = false;
        do {
            do {
                try {
                    System.out.print("Please type: ");
                    answer = InputOutput.useInputStream().nextDouble();
                    done = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid integer input");
                    answer = 10000;
                }
            } while (done == false);
            if (answer > 2500 || answer < 0) {
                System.out.println("invalid input...");
            }
        } while (answer > 2500 || answer < 0);

        return answer;
    }
    
    public static java.sql.Date validateDate() {

         boolean done = false;
        int year = 0;
        int month = 0;
        int day = 0;
         
        do {
            try {
                System.out.print("Please type year >>  ");
                year = InputOutput.useInputStream().nextInt();
                System.out.print("Please type month >>  ");
                month = InputOutput.useInputStream().nextInt();
                System.out.print("Please type day >>  ");
                day = InputOutput.useInputStream().nextInt();
                if(year>1940 && year<2050 && month >0 && month<13 && day>0 && day<32){
                    done = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid integer input");
            }
        } while (done == false);
         
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);

        java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());
        System.out.println(sdf.format(sqlDate));
         
         return sqlDate;
     }
    
     public static java.sql.Date validateStartDate() {

         boolean done = false;
        int year = 0;
        int month = 0;
        int day = 0;
         
        do {
            try {
                System.out.print("Please type year >>  ");
                year = InputOutput.useInputStream().nextInt();
                System.out.print("Please type month >>  ");
                month = InputOutput.useInputStream().nextInt();
                System.out.print("Please type day >>  ");
                day = InputOutput.useInputStream().nextInt();
                if(year>2018 && year<2050 && month >0 && month<13 && day>0 && day<32){
                    done = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid integer input");
            }
        } while (done == false);
         
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);

        java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());
        System.out.println(sdf.format(sqlDate));
         
         return sqlDate;
     }
     
     public static java.sql.Date validateEndDate(java.sql.Date courseStartDate) {

         boolean done = false;
        int year = 0;
        int month = 0;
        int day = 0;
        java.sql.Date sqlDate;
        do {
        do {
            try {
                System.out.print("Please type year >>  ");
                year = InputOutput.useInputStream().nextInt();
                System.out.print("Please type month >>  ");
                month = InputOutput.useInputStream().nextInt();
                System.out.print("Please type day >>  ");
                day = InputOutput.useInputStream().nextInt();
                if(year>2018 && year<2050 && month >0 && month<13 && day>0 && day<32){
                    done = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid integer input");
            }
        } while (done == false);
         
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);

        sqlDate = new java.sql.Date(cal.getTimeInMillis());
        System.out.println(sdf.format(sqlDate));
        
        if(sqlDate.before(courseStartDate)){
            System.out.println("End date cannot be earlier than start date...");
            System.out.println("Please type End date again...   >>");}
        
        } while (sqlDate.before(courseStartDate));
         
         return sqlDate;
     }
     
     public static java.sql.Timestamp validateTimestamp() {
         java.sql.Timestamp sqlTimestamp;
         boolean done = false;
        int year = 0;
        int month = 0;
        int day = 0;
        String appliedDay;
         do {
            try {
                System.out.print("Please type year >>  ");
                year = InputOutput.useInputStream().nextInt();
                System.out.print("Please type month >>  ");
                month = InputOutput.useInputStream().nextInt();
                System.out.print("Please type day >>  ");
                day = InputOutput.useInputStream().nextInt();
                if(year>2018 && year<2050 && month >0 && month<13 && day>0 && day<32){
                    done = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid integer input");
            }
        } while (done == false);
         
         sqlTimestamp = Timestamp.valueOf(year + "-" + month + "-" + day + " 22:00:00");
         
         return sqlTimestamp;
     }
     
     public static int ValidateCourseOfAssignment(ArrayList<Course> courseListToShow){
         int courseOfAssignment;
         
         InputOutput.printCourses(courseListToShow);
         courseOfAssignment = validateIntegerTypeOfData();
         
         return courseOfAssignment;
     }
     
     public static int ValidateStudentCourseStudentId(List<Student> studentListToChoose){
         int studentCourseStudentId;
         
         InputOutput.printStudents(studentListToChoose);
         do{
            studentCourseStudentId = validateIntegerTypeOfData();
            if(studentCourseStudentId>studentListToChoose.size() || studentCourseStudentId<=0)
                 System.out.println("invalid student id input...");
         }while(studentCourseStudentId>studentListToChoose.size() || studentCourseStudentId<=0);
         
         
         return studentCourseStudentId;
     }
     
     public static int ValidateStudentCourseCourseId(List<Course> courseListToChoose){
         int studentCourseCoursetId;
         
         InputOutput.printCourses(courseListToChoose);
         do{
            studentCourseCoursetId = validateIntegerTypeOfData();
            if(studentCourseCoursetId>courseListToChoose.size() || studentCourseCoursetId<=0)
                 System.out.println("invalid course id input...");
         }while(studentCourseCoursetId>courseListToChoose.size() || studentCourseCoursetId<=0);
         
         return studentCourseCoursetId;
     }
     
     public static int ValidateTrainerCourseTrainerId(List<Trainer> trainerListToChoose){
         int trainerCourseStudentId;
         
         InputOutput.printTrainersWithoutSubjects(trainerListToChoose);
         do{
            trainerCourseStudentId = validateIntegerTypeOfData();
            if(trainerCourseStudentId>trainerListToChoose.size() || trainerCourseStudentId<=0)
                 System.out.println("invalid student id input...");
         }while(trainerCourseStudentId>trainerListToChoose.size() || trainerCourseStudentId<=0);
         
         
         return trainerCourseStudentId;
     }
     
     public static int ValidateTrainerCourseCourseId(List<Course> courseListToChoose){
         int trainerCourseCoursetId;
         
         InputOutput.printCourses(courseListToChoose);
         do{
            trainerCourseCoursetId = validateIntegerTypeOfData();
            if(trainerCourseCoursetId>courseListToChoose.size() || trainerCourseCoursetId<=0)
                 System.out.println("invalid course id input...");
         }while(trainerCourseCoursetId>courseListToChoose.size() || trainerCourseCoursetId<=0);
         
         return trainerCourseCoursetId;
     }
     

}
