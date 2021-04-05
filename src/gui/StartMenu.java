
package gui;

import dbConnection.DbConnector;
import io.InputOutput;
import io.ValidateInputs;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.*;


public class StartMenu {
    
    public void getStartMenu(){
        boolean check = false;
    do {
        
        int answer;
        do {
            System.out.print("I want to (0: view data, 1: insert data): ");
            //answer = useInputStream().nextInt();
            answer = ValidateInputs.validateIntegerTypeOfData();
            if (!(answer == 0 || answer == 1)) {
                System.out.println("invalid input...");
            }
        } while (!(answer == 0 || answer == 1));
        if (answer == 0) {
            getViewMenu();
        } else {
            getInsertMenu();
        }
        
        do {
            System.out.print("do you want to continue? (0: no, 1: yes)   ");
            //answer = useInputStream().nextInt();
            answer = ValidateInputs.validateIntegerTypeOfData();
            if (!(answer == 0 || answer == 1)) {
                System.out.println("invalid input...");
            }
        } while (!(answer == 0 || answer == 1));
        if (answer == 0) {
            check = true;
        }

            
    } while (!check);
    }

    public void getViewMenu(){
        
        int option;
       
            System.out.println("1. Select all courses.");
            System.out.println("2. Select all enrolled students.");
            System.out.println("3. Select all students.");
            System.out.println("4. Select all trainers (without subjects).");
            System.out.println("5. Select all trainers (with subjects).");
            System.out.println("6. Select all assignments.");
            System.out.println("7. Select all students per course.");
            System.out.println("8. Select all trainers per course.");
            System.out.println("9. Select all assignments per course.");
            System.out.println("10. Select all assignments per student per course.");
            System.out.println("11. Select all students that belong to more than one courses.");

            Scanner scan = new Scanner(System.in);
            System.out.println("");
            option = ValidateInputs.validateIntegerTypeOfData();

            DbConnector dbconnector = new DbConnector();
            String courseTitle;
            String courseStream;
            String courseType;
            int studentId;
            switch (option) {
                case 1:
                    List<Course> courseList = new ArrayList<>(dbconnector.getAllCourses());
                    InputOutput.printCourses(courseList);
                    break;
                case 2:
                    List<Student> enrolledStudentList = new ArrayList<>(dbconnector.getAllEnrolledStudents());
                    InputOutput.printEnrolledStudents(enrolledStudentList);
                    break;
                case 3:
                    List<Student> studentList = new ArrayList<>(dbconnector.getAllStudents());
                    InputOutput.printStudents(studentList);
                    break;
                case 4:
                    List<Trainer> trainerListWithoutSubjects = new ArrayList<>(dbconnector.getAllTrainersWithoutSubjects());
                    InputOutput.printTrainersWithoutSubjects(trainerListWithoutSubjects);
                    break;
                case 5:
                    List<Trainer> trainerListWithSubjects = new ArrayList<>(dbconnector.getAllTrainersWithSubjects());
                    InputOutput.printTrainersWithSubjects(trainerListWithSubjects);
                    break;
                case 6:
                    List<Assignment> assignmentList = new ArrayList<>(dbconnector.getAllAssignments());
                    InputOutput.printAssignments(assignmentList);
                    break;
                case 7:
                    courseTitle = InputOutput.selectCourseTitle();
                    courseStream = InputOutput.selectCourseStream();
                    courseType = InputOutput.selectCourseType();
                    
                    List<Student> studentsPerCourseList = new ArrayList<>(dbconnector.getStudentsPerCourse(courseTitle, courseStream, courseType));
                    InputOutput.printStudentsPerCourse(studentsPerCourseList);
                    break;
                case 8:
                    courseTitle = InputOutput.selectCourseTitle();
                    courseStream = InputOutput.selectCourseStream();
                    courseType = InputOutput.selectCourseType();
                    
                    List<Trainer> trainersPerCourseList = new ArrayList<>(dbconnector.getTrainersPerCourse(courseTitle, courseStream, courseType));
                    InputOutput.printTrainersPerCourse(trainersPerCourseList);
                    break;
                case 9:
                    courseTitle = InputOutput.selectCourseTitle();
                    courseStream = InputOutput.selectCourseStream();
                    courseType = InputOutput.selectCourseType();
                    
                    List<Assignment> assignmentsPerCourseList = new ArrayList<>(dbconnector.getAssignmentsPerCourse(courseTitle, courseStream, courseType));
                    InputOutput.printAssignmentsPerCourse(assignmentsPerCourseList);
                    break;
                case 10:
                    courseTitle = InputOutput.selectCourseTitle();
                    courseStream = InputOutput.selectCourseStream();
                    courseType = InputOutput.selectCourseType();
                    studentId = InputOutput.selectStudentId(courseTitle, courseStream, courseType);
                    
                    List<Assignment> assignmentsPerStudentPerCourseList = new ArrayList<>(dbconnector.getAssignmentsPerStudentPerCourse(courseTitle, courseStream, courseType, studentId));
                    InputOutput.printAssignmentsPerStudentPerCourse(assignmentsPerStudentPerCourseList);
                    break;
                case 11:
                    List<Student> studentsWithMultipleCoursesList = new ArrayList<>(dbconnector.getStudentsWithMultipleCourses());
                    InputOutput.printStudents(studentsWithMultipleCoursesList);
                    break;
                default:
                    break;
            }

        
        
    
    }
    
    public void getInsertMenu(){
        int option;
        
        System.out.println("1. Insert new course.");
        System.out.println("2. Insert new student.");
        System.out.println("3. Insert new trainer.");
        System.out.println("4. Insert new assignment.");
        System.out.println("5. Insert new students per course.");
        System.out.println("6. Insert new trainers per course.");
       
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        option = ValidateInputs.validateIntegerTypeOfData();
        
        DbConnector dbconnector = new DbConnector();
        int rowsAffected;
        boolean studentExists;
        boolean courseExists;
        boolean trainerExists;
        boolean assignmentExists;
        int studentId;
        int courseId;
        int trainerId;
        int assignmentId;
        String courseTitle;
        String courseStream;
        String courseType;
        java.sql.Date courseStartDate;
        java.sql.Date courseEndDate;
        String studentFirstName;
        String studentLastName;
        String trainerFirstName;
        String trainerLastName;
        String assignmentTitle;
        String assignmentDescription;
        ArrayList<Course> courseListToShow;
        List<Student> studentListToChoose;
        List<Course> courseListToChoose;
        List<Trainer> trainerListToChoose;
        java.sql.Timestamp assignmentSubDateTime;
        int courseOfAssignment;
        int studentCourseStudentId;
        int studentCourseCourseId;
        int trainerCourseTrainerId;
        int trainerCourseCourseId;
        double studentCourseTuitionFees;
        String trainerCourseSubject;
        boolean theCourseExists;
        java.sql.Date studentBirthDate;
        
        switch (option) {
                case 1:
                    courseExists = false;
                    courseId = -1;
                    do {
                        List<Course> courseList = dbconnector.getAllCourses();
                        for (Course course : courseList) {
                            System.out.println("course id: " + course.getCourse_id()
                                    + ", title: " + course.getTitle()
                                    + ", stream: " + course.getStream()
                                    + ", type: " + course.getType()
                            );
                        }
                        System.out.println("now enter the title for the new course:");
                        courseTitle = scan.nextLine();
                        System.out.println("now enter the stream for the new course:");
                        courseStream = scan.nextLine();
                        System.out.println("now enter the type for the new course:");
                        courseType = scan.nextLine();
                        System.out.println("now enter the start date for the new course:");
                        courseStartDate = ValidateInputs.validateStartDate();
                        System.out.println("now enter the end date for the new course:");
                        courseEndDate = ValidateInputs.validateEndDate(courseStartDate);

                        for (Course course : courseList) {
                            if (course.getTitle().equalsIgnoreCase(courseTitle) && course.getStream().equalsIgnoreCase(courseStream) && course.getType().equalsIgnoreCase(courseType)) {
                                courseExists = true;
                                System.out.println("The course already exists, please type again...");
                            }
                        }

                    } while (courseExists);

                    rowsAffected = dbconnector.insertNewCourse(courseTitle, courseStream, courseType, courseStartDate, courseEndDate);
                    
                    if(rowsAffected==0){
                        System.out.println("something went wrong");
                    }else{
                        System.out.println("course " + courseTitle + ", " + courseStream + ", " + courseType + " was inserted sucessfully.");
                    }
                break;
                case 2:
                    studentExists = false;
                    studentId = -1;
                    do {
                        List<Student> studentList = dbconnector.getAllStudents();
                        for (Student student : studentList) {
                            System.out.println("student id: " + student.getStudent_id()
                                    + ", firstname: " + student.getFirstname()
                                    + ", lastname: " + student.getLastname()
                                    + ", date of birth: " + student.getDate_of_birth()
                            );
                        }
                        System.out.println("now enter the first name of the new student:");
                        studentFirstName = scan.nextLine();
                        System.out.println("now enter the last name of the new student:");
                        studentLastName = scan.nextLine();
                        System.out.println("now enter the birth date for the new student:");
                        studentBirthDate = ValidateInputs.validateDate();

                        for (Student student : studentList) {
                            if (student.getDate_of_birth().toString().equalsIgnoreCase(studentBirthDate.toString()) && student.getFirstname().equalsIgnoreCase(studentFirstName) && student.getLastname().equalsIgnoreCase(studentLastName)) {
                                studentExists = true;
                                System.out.println("The student already exists, please type again...");
                            }
                        }
                        

                    } while (studentExists);

                    rowsAffected = dbconnector.insertNewStudent(studentFirstName, studentLastName, studentBirthDate);
                    
                    if(rowsAffected==0){
                        System.out.println("something went wrong");
                    }else{
                        System.out.println("student: " + studentFirstName + ", " + studentLastName + ", " + studentBirthDate + " was inserted sucessfully.");
                    }
                break;
                case 3:
                    trainerExists = false;
                    trainerId = -1;
                    do {
                        List<Trainer> trainerList = dbconnector.getAllTrainersWithoutSubjects();
                        for (Trainer trainer : trainerList) {
                            System.out.println("trainer id: " + trainer.getTrainer_id()
                                    + ", firstname: " + trainer.getFirst_name()
                                    + ", lastname: " + trainer.getLast_name()
                            );
                        }
                        System.out.println("now enter the first name of the new trainer:");
                        trainerFirstName = scan.nextLine();
                        System.out.println("now enter the last name of the new trainer:");
                        trainerLastName = scan.nextLine();

                        for (Trainer trainer : trainerList) {
                            
                            if (trainer.getFirst_name().equalsIgnoreCase(trainerFirstName) && trainer.getLast_name().equalsIgnoreCase(trainerLastName)) {
                                trainerExists = true;
                                System.out.println("The trainer already exists, please type again...");
                            }
                        }
                        

                    } while (trainerExists);

                    rowsAffected = dbconnector.insertNewTrainer(trainerFirstName, trainerLastName);
                    
                    if(rowsAffected==0){
                        System.out.println("something went wrong");
                    }else{
                        System.out.println("trainer: " + trainerFirstName + ", " + trainerLastName + " was inserted sucessfully.");
                    }
                break;
                case 4:
                    assignmentExists = false;
                    assignmentId = -1;
                    do {
                        List<Assignment> assignmentList = dbconnector.getAllAssignments();
                        for (Assignment assignment : assignmentList) {
                            System.out.println("assignment id: " + assignment.getAssignment_id()
                                    + ", title: " + assignment.getTitle()
                                    + ", description: " + assignment.getAs_description()
                                    + ", submission date time: " + assignment.getSub_date_time()
                            );
                        }
                        System.out.println("now enter the title of the new assignment:");
                        assignmentTitle = scan.nextLine();
                        System.out.println("now enter the description of the new assignment:");
                        assignmentDescription = scan.nextLine();
                        System.out.println("now enter the submission date time of the new assignment:");
                        assignmentSubDateTime = ValidateInputs.validateTimestamp();
                        System.out.println("now enter the course id of the course that belongs the new assignment:");
                        courseOfAssignment = ValidateInputs.ValidateCourseOfAssignment(courseListToShow = (ArrayList<Course>) dbconnector.getAllCourses());

                        for (Assignment assignment : assignmentList) {
                            
                            if (assignment.getTitle().equalsIgnoreCase(assignmentTitle) && assignment.getAs_description().equalsIgnoreCase(assignmentDescription) && assignment.getSub_date_time().toString().equalsIgnoreCase(assignmentSubDateTime.toString())) {
                                assignmentExists = true;
                                System.out.println("The assignment already exists, please type again...");
                            }
                        }

                    } while (assignmentExists);

                    rowsAffected = dbconnector.insertNewAssignment(assignmentTitle, assignmentDescription, assignmentSubDateTime, courseOfAssignment);
                    
                    if(rowsAffected==0){
                        System.out.println("something went wrong");
                    }else{
                        System.out.println("assignment: " + assignmentTitle + ", " + assignmentDescription + ", " + assignmentSubDateTime + " of course with course id: " + courseOfAssignment + " was inserted sucessfully.");
                    }
                break;
                case 5:
                    boolean theStudentExists = false;
                    studentId = -1;
                    theCourseExists = false;
                    courseId = -1;
                    do {
                        studentListToChoose = dbconnector.getAllStudents();

                        System.out.println("now enter the student id:");
                        studentCourseStudentId = ValidateInputs.ValidateStudentCourseStudentId(studentListToChoose);

                        for (Student student : studentListToChoose) {
                            //System.out.println("check 1: " + studentExists);
                            //studentExists = dbconnector.checkIfStudentExistsFromId(studentCourseStudentId);
                            if (student.getStudent_id()==studentCourseStudentId) {    
                                theStudentExists = true;
                                break;
                            }
                        }
                         System.out.println("check 2: " + theStudentExists);
                        if(theStudentExists = false){
                            System.out.println("student does not exists, choose student again...");
                        }

                    } while (theStudentExists = false);
                    
                    do {
                        courseListToChoose = dbconnector.getAllCourses();

                        System.out.println("now enter the course id:");
                        studentCourseCourseId = ValidateInputs.ValidateStudentCourseCourseId(courseListToChoose);


                        for (Course course : courseListToChoose) {

                            if (course.getCourse_id()==studentCourseCourseId) {
                                theCourseExists = true;
                                break;
                            }
                        }
                        if(theCourseExists = false)
                            System.out.println("course does not exists, choose course again...");

                    } while (theCourseExists = false);
                    
                    System.out.println("Enter fees for the selected course for the student: ");
                    studentCourseTuitionFees = ValidateInputs.validateFeesData();

                    rowsAffected = dbconnector.insertNewStudent_Course(studentCourseStudentId, studentCourseCourseId, studentCourseTuitionFees);
                    
                    if(rowsAffected==0){
                        System.out.println("something went wrong");
                    }else{
                        System.out.println("student with student id: : " + studentCourseStudentId + " was inserted successfully to course with course id:  " + studentCourseCourseId + " and fees:  " + studentCourseTuitionFees + ".");
                    }
                break;
                case 6:
                    boolean theTrainerExists = false;
                    studentId = -1;
                    theCourseExists = false;
                    courseId = -1;
                    do {
                        trainerListToChoose = dbconnector.getAllTrainersWithoutSubjects();

                        System.out.println("now enter the trainer id:");
                        trainerCourseTrainerId = ValidateInputs.ValidateTrainerCourseTrainerId(trainerListToChoose);

                        for (Trainer trainer : trainerListToChoose) {
                            //System.out.println("check 1: " + studentExists);
                            //studentExists = dbconnector.checkIfStudentExistsFromId(studentCourseStudentId);
                            if (trainer.getTrainer_id()==trainerCourseTrainerId) {    
                                theTrainerExists = true;
                                break;
                            }
                        }
                         System.out.println("check 2: " + theTrainerExists);
                        if(theStudentExists = false){
                            System.out.println("trainer does not exists, choose student again...");
                        }

                    } while (theStudentExists = false);
                    
                    do {
                        courseListToChoose = dbconnector.getAllCourses();

                        System.out.println("now enter the course id:");
                        trainerCourseCourseId = ValidateInputs.ValidateTrainerCourseCourseId(courseListToChoose);


                        for (Course course : courseListToChoose) {

                            if (course.getCourse_id()==trainerCourseCourseId) {
                                theCourseExists = true;
                                break;
                            }
                        }
                        if(theCourseExists = false)
                            System.out.println("course does not exists, choose course again...");

                    } while (theCourseExists = false);
                    
                    System.out.println("Enter subject for the selected trainer the student: ");
                    trainerCourseSubject = InputOutput.useInputStream().nextLine();

                    rowsAffected = dbconnector.insertNewTrainer_Course(trainerCourseTrainerId, trainerCourseCourseId, trainerCourseSubject);
                    
                    if(rowsAffected==0){
                        System.out.println("something went wrong");
                    }else{
                        System.out.println("trainer with trainer id: : " + trainerCourseTrainerId + " was inserted successfully to course with course id:  " + trainerCourseCourseId + " and subject:  " + trainerCourseSubject + ".");
                    }
                break;
                default:
                break;
            }
    }
    
}


                    
