
package dbConnection;

import java.sql.*;
import java.time.*;
import java.util.*;
import model.*;

public class DbConnector {
    
    private static final String MYSQL_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/private_school?serverTimezone=UTC";
    private static final String USERNAME = "java_user_angelos";
    private static final String PASSWORD = "12345";
    
    
    public List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<>();
    
        Connection conn = null;
        PreparedStatement preparedStatement = null; 
        ResultSet resultSet = null;
        
        try{
               
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            

            String query = "SELECT C.COURSE_ID, C.TITLE, C.STREAM, C.CO_TYPE, C.START_DATE, C.END_DATE FROM COURSE C;";
            
            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery(query);
            
            while (resultSet.next()) {
                int course_id = resultSet.getInt("C.COURSE_ID");
                String title = resultSet.getString("C.TITLE");
                String stream = resultSet.getString("C.STREAM");
                String type = resultSet.getString("C.CO_TYPE");
                java.sql.Date start_date = resultSet.getDate("C.START_DATE");
                java.sql.Date end_date = resultSet.getDate("C.END_DATE");
                
                Course course = new Course(course_id, title, stream, type, start_date, end_date);
                courses.add(course);
                                
            }
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
          return courses;
        
    }
    
    public List<Student> getAllEnrolledStudents(){
        List<Student> students = new ArrayList<>();
    
        Connection conn = null;
        PreparedStatement preparedStatement = null; 
        ResultSet resultSet = null;
        
        try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            

            String query = "SELECT S.STUDENT_ID, S.LASTNAME, S.FIRSTNAME, S.DATEOFBIRTH, SUM(SC.TUITION_FEES) AS TOTALFEES " +
                            "FROM STUDENT S, STUDENT_COURSE SC " +
                            "WHERE S.STUDENT_ID=SC.STUDENT_ID " +
                            "GROUP BY S.STUDENT_ID " +
                            "ORDER BY LASTNAME ASC;";
            
            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery(query);
            
            while (resultSet.next()) {
                int student_id = resultSet.getInt("S.STUDENT_ID");
                String firstname = resultSet.getString("S.FIRSTNAME");
                String lastname = resultSet.getString("S.LASTNAME");
                double tuition_fees = resultSet.getDouble("TOTALFEES");
                java.sql.Date date_of_birth = resultSet.getDate("S.DATEOFBIRTH");
                
                Student student = new Student(student_id, firstname, lastname, date_of_birth, tuition_fees);
                students.add(student);
                                
            }
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
          return students;
        
    }
    
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
    
        Connection conn = null;
        PreparedStatement preparedStatement = null; 
        ResultSet resultSet = null;
        
        try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            

            String query = "SELECT S.STUDENT_ID, S.LASTNAME, S.FIRSTNAME, S.DATEOFBIRTH " +
                            "FROM STUDENT S " +
                            "ORDER BY LASTNAME ASC;";
            
            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery(query);
            
            while (resultSet.next()) {
                int student_id = resultSet.getInt("S.STUDENT_ID");
                String firstname = resultSet.getString("S.FIRSTNAME");
                String lastname = resultSet.getString("S.LASTNAME");
                java.sql.Date date_of_birth = resultSet.getDate("S.DATEOFBIRTH");
                
                Student student = new Student(student_id, firstname, lastname, date_of_birth);
                students.add(student);
                                
            }
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
          return students;
        
    }
    
    public List<Trainer> getAllTrainersWithoutSubjects(){
        List<Trainer> trainers = new ArrayList<>();
    
        Connection conn = null;
        PreparedStatement preparedStatement = null; 
        ResultSet resultSet = null;
        
        try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            

            String query = "SELECT T.TRAINER_ID, T.FIRSTNAME, T.LASTNAME " +
                            "FROM TRAINER T " +
                            "ORDER BY T.LASTNAME;";
            
            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery(query);
            
            while (resultSet.next()) {
                int trainer_id = resultSet.getInt("T.TRAINER_ID");
                String first_name = resultSet.getString("T.FIRSTNAME");
                String last_name = resultSet.getString("T.LASTNAME");
                
                Trainer trainer = new Trainer(trainer_id, first_name, last_name);
                trainers.add(trainer);
                                
            }
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
          return trainers;
    }
    
    public List<Trainer> getAllTrainersWithSubjects(){
        List<Trainer> trainers = new ArrayList<>();
    
        Connection conn = null;
        PreparedStatement preparedStatement = null; 
        ResultSet resultSet = null;
        
        try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            

            String query = "SELECT DISTINCT T.TRAINER_ID, T.LASTNAME, T.FIRSTNAME, TC.SUBJECT_TAUGHT AS SUBJECTS " +
                            "FROM TRAINER T, TRAINER_COURSE TC " +
                            "WHERE T.TRAINER_ID=TC.TRAINER_ID " +
                            "ORDER BY T.LASTNAME ASC;";
            
            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery(query);
            
            while (resultSet.next()) {
                int trainer_id = resultSet.getInt("T.TRAINER_ID");
                String first_name = resultSet.getString("T.FIRSTNAME");
                String last_name = resultSet.getString("T.LASTNAME");
                String subject_taught = resultSet.getString("SUBJECTS");
                
                Trainer trainer = new Trainer(trainer_id, first_name, last_name, subject_taught);
                trainers.add(trainer);
                                
            }
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
          return trainers;
    }
    
    public List<Assignment> getAllAssignments(){
        List<Assignment> assignments = new ArrayList<>();
    
        Connection conn = null;
        PreparedStatement preparedStatement = null; 
        ResultSet resultSet = null;
        
        try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            

            String query = "SELECT A.ASSIGNMENT_ID, A.TITLE, A.AS_DESCRIPTION, A.SUB_DATE_TIME " +
                            "FROM ASSIGNMENT A " +
                            "ORDER BY A.ASSIGNMENT_ID;";
            
            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery(query);
            
            while (resultSet.next()) {
                int assignment_id = resultSet.getInt("A.ASSIGNMENT_ID");
                String title = resultSet.getString("A.TITLE");
                String as_description = resultSet.getString("A.AS_DESCRIPTION");

                  Timestamp sub_date_time = resultSet.getTimestamp("A.SUB_DATE_TIME");
                Assignment assignment = new Assignment(assignment_id, title, as_description, sub_date_time);
                assignments.add(assignment);
                                
            }
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
          return assignments;
    
    }
    
    public List<Student> getStudentsPerCourse(String courseTitle, String courseStream, String courseType){
        List<Student> studentsPerCourse = new ArrayList<>();
    
        Connection conn = null;
        PreparedStatement preparedStatement = null; 
        ResultSet resultSet = null;
        
        try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            

            String query = "SELECT S.STUDENT_ID, S.LASTNAME, S.FIRSTNAME, S.DATEOFBIRTH, TUITION_FEES AS TOTALFEES " +
                            "FROM STUDENT S, STUDENT_COURSE SC, COURSE C " +
                            "WHERE S.STUDENT_ID=SC.STUDENT_ID " +
                            "AND SC.COURSE_ID=C.COURSE_ID " +
                            "AND C.TITLE=? && C.STREAM=? && C.CO_TYPE=? " +
                            "ORDER BY LASTNAME ASC;";
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, courseTitle);
            preparedStatement.setString(2, courseStream);
            preparedStatement.setString(3, courseType);

            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                int student_id = resultSet.getInt("S.STUDENT_ID");
                String firstname = resultSet.getString("S.FIRSTNAME");
                String lastname = resultSet.getString("S.LASTNAME");
                double tuition_fees = resultSet.getDouble("TOTALFEES");
                java.sql.Date date_of_birth = resultSet.getDate("S.DATEOFBIRTH");
                
                Student student = new Student(student_id, firstname, lastname, date_of_birth, tuition_fees);
                studentsPerCourse.add(student);
                                
            }
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
          return studentsPerCourse;
        
    
}
    
    public List<Trainer> getTrainersPerCourse(String courseTitle, String courseStream, String courseType){
        List<Trainer> trainersPerCourse = new ArrayList<>();
    
        Connection conn = null;
        PreparedStatement preparedStatement = null; 
        ResultSet resultSet = null;
        
        try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            

            String query = "SELECT DISTINCT T.TRAINER_ID, T.LASTNAME, T.FIRSTNAME " +
                            "FROM TRAINER T, TRAINER_COURSE TC, COURSE C " +
                            "WHERE T.TRAINER_ID=TC.TRAINER_ID " +
                            "AND TC.COURSE_ID=C.COURSE_ID " +
                            "AND C.TITLE=? && C.STREAM=? && C.CO_TYPE=? " +
                            "ORDER BY T.LASTNAME ASC;";
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, courseTitle);
            preparedStatement.setString(2, courseStream);
            preparedStatement.setString(3, courseType);

            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                int trainer_id = resultSet.getInt("T.TRAINER_ID");
                String firstname = resultSet.getString("T.FIRSTNAME");
                String lastname = resultSet.getString("T.LASTNAME");
                
                Trainer trainer = new Trainer(trainer_id, firstname, lastname);
                trainersPerCourse.add(trainer);
                                
            }
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
          return trainersPerCourse;
        
    
}
    
    public List<Assignment> getAssignmentsPerCourse(String courseTitle, String courseStream, String courseType){
        List<Assignment> assignmentsPerCourse = new ArrayList<>();
    
        Connection conn = null;
        PreparedStatement preparedStatement = null; 
        ResultSet resultSet = null;
        
        try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            

            String query = "SELECT A.ASSIGNMENT_ID, A.TITLE, A.AS_DESCRIPTION, A.SUB_DATE_TIME " +
                            "FROM ASSIGNMENT A, COURSE C " +
                            "WHERE A.COURSE_ID=C.COURSE_ID " +
                            "AND C.TITLE=? && C.STREAM=? && C.CO_TYPE=? " +
                            "ORDER BY A.ASSIGNMENT_ID;";
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, courseTitle);
            preparedStatement.setString(2, courseStream);
            preparedStatement.setString(3, courseType);

            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                int assignment_id = resultSet.getInt("A.ASSIGNMENT_ID");
                String title = resultSet.getString("A.TITLE");
                String as_description = resultSet.getString("A.AS_DESCRIPTION");
                Timestamp sub_date_time = resultSet.getTimestamp("A.SUB_DATE_TIME");
                
                Assignment assignment = new Assignment(assignment_id, title, as_description, sub_date_time);
                assignmentsPerCourse.add(assignment);
                                
            }
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
          return assignmentsPerCourse;
        
    
}
    
    public List<Assignment> getAssignmentsPerStudentPerCourse(String courseTitle, String courseStream, String courseType, int studentId){
        List<Assignment> assignmentsPerStudentPerCourse = new ArrayList<>();
    
        Connection conn = null;
        PreparedStatement preparedStatement = null; 
        ResultSet resultSet = null;
        
        try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...\n");
            

            String query = "SELECT A.ASSIGNMENT_ID, A.COURSE_ID, S.STUDENT_ID, A.TITLE, A.AS_DESCRIPTION, A.SUB_DATE_TIME, SA.ORAL_MARK, SA.TOTAL_MARK " +
                            "FROM STUDENT S, COURSE C, STUDENT_COURSE SC, ASSIGNMENT A, ASSIGNMENT_STUDENT SA " +
                            "WHERE C.COURSE_ID=SC.COURSE_ID " +
                            "AND S.STUDENT_ID=SC.STUDENT_ID " +
                            "AND S.STUDENT_ID=SA.STUDENT_ID " +
                            "AND A.ASSIGNMENT_ID=SA.ASSIGNMENT_ID " +
                            "AND A.COURSE_ID=C.COURSE_ID " +
                            "AND C.TITLE=?&&C.STREAM=?&&C.CO_TYPE=? " +
                            "AND S.STUDENT_ID=?;";
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, courseTitle);
            preparedStatement.setString(2, courseStream);
            preparedStatement.setString(3, courseType);
            preparedStatement.setInt(4, studentId);

            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                int assignment_id = resultSet.getInt("A.ASSIGNMENT_ID");
                String title = resultSet.getString("A.TITLE");
                String as_description = resultSet.getString("A.AS_DESCRIPTION");
                Timestamp sub_date_time = resultSet.getTimestamp("A.SUB_DATE_TIME");
                int oral_mark = resultSet.getInt("ORAL_MARK");
                int total_mark = resultSet.getInt("TOTAL_MARK");
                
                Assignment assignment = new Assignment(assignment_id, title, as_description, sub_date_time, oral_mark, total_mark);
                assignmentsPerStudentPerCourse.add(assignment);
                                
            }
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
          return assignmentsPerStudentPerCourse;
        
    
}
    
    public List<Student> getStudentsWithMultipleCourses(){
        List<Student> studentsWithMultipleCourses = new ArrayList<>();
    
        Connection conn = null;
        PreparedStatement preparedStatement = null; 
        ResultSet resultSet = null;
        
        try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...\n");
            

            String query = "SELECT S.STUDENT_ID, S.LASTNAME, S.FIRSTNAME, S.DATEOFBIRTH, SUM(SC.TUITION_FEES) AS TOTALFEES " +
                            "FROM STUDENT S, COURSE C, STUDENT_COURSE SC " +
                            "WHERE S.STUDENT_ID=SC.STUDENT_ID " +
                            "AND SC.COURSE_ID=C.COURSE_ID " +
                            "GROUP BY S.STUDENT_ID " +
                            "HAVING COUNT(*)>1 " +
                            "ORDER BY S.LASTNAME;";
            
            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery(query);
            
            while (resultSet.next()) {
                int student_id = resultSet.getInt("S.STUDENT_ID");
                String firstname = resultSet.getString("S.FIRSTNAME");
                String lastname = resultSet.getString("S.LASTNAME");
                double tuition_fees = resultSet.getDouble("TOTALFEES");
                java.sql.Date date_of_birth = resultSet.getDate("S.DATEOFBIRTH");
                
                Student student = new Student(student_id, firstname, lastname, date_of_birth, tuition_fees);
                studentsWithMultipleCourses.add(student);
                                
            }
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
          return studentsWithMultipleCourses;
        
    }
    
    public boolean checkIfCourseExists(String courseTitle, String courseStream, String courseType){
            boolean courseExists = false;
            
            Connection conn = null;
            PreparedStatement preparedStatement = null; 
            ResultSet resultSet = null;
            
            try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            

            String query = "SELECT COUNT(*) "
                    + "FROM COURSE "
                    + "WHERE COURSE.TITLE = ? "
                    + "AND COURSE.STREAM = ? "
                    + "AND COURSE.CO_TYPE = ?";
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, courseTitle);
            preparedStatement.setString(2, courseStream);
            preparedStatement.setString(3, courseType);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                int count = resultSet.getInt(1);
                if(count>0)
                    courseExists = true;
                   
            }
            
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }

            return courseExists;
        }
    
    public int insertNewCourse(String courseTitle, String courseStream, String courseType, java.sql.Date courseStartDate, java.sql.Date courseEndDate){
        
            int rowsAffected = 0;
            
            Connection conn = null;
            PreparedStatement preparedStatement = null; 
            
            try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            
            
            String query = "INSERT INTO COURSE (TITLE, STREAM, CO_TYPE, START_DATE, END_DATE) "
                    + "VALUES (?, ?, ?, ?, ?);";
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, courseTitle);
            preparedStatement.setString(2, courseStream);
            preparedStatement.setString(3, courseType);
            preparedStatement.setDate(4, courseStartDate);
            preparedStatement.setDate(5, courseEndDate);
            
            rowsAffected = preparedStatement.executeUpdate();

            
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
            
        
            return rowsAffected;
        }
    
    public boolean checkIfStudentExists(String studentFirstName, String studentLastName, java.sql.Date studentBirthDate){
            boolean studentExists = false;
            
            Connection conn = null;
            PreparedStatement preparedStatement = null; 
            ResultSet resultSet = null;
            
            try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            

            String query = "SELECT COUNT(*) "
                    + "FROM STUDENT "
                    + "WHERE STUDENT.FIRSTNAME = ? "
                    + "AND STUDENT.LASTNAME = ? "
                    + "AND STUDENT.DATEOFBIRTH = ?";
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, studentFirstName);
            preparedStatement.setString(2, studentLastName);
            preparedStatement.setDate(3, studentBirthDate);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                int count = resultSet.getInt(1);
                if(count>0)
                    studentExists = true;
                   
            }
            
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }

            return studentExists;
        }
    
    public int insertNewStudent(String studentFirstName, String studentLastName, java.sql.Date studentBirthDate){
        
            int rowsAffected = 0;
            
            Connection conn = null;
            PreparedStatement preparedStatement = null; 
            
            try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            
            
            String query = "INSERT INTO STUDENT (FIRSTNAME, LASTNAME, DATEOFBIRTH) "
                    + "VALUES (?, ?, ?);";
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, studentFirstName);
            preparedStatement.setString(2, studentLastName);
            preparedStatement.setDate(3, studentBirthDate);
            
            rowsAffected = preparedStatement.executeUpdate();

            
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
            
        
            return rowsAffected;
        }
    
    public boolean checkIfTrainerExists(String trainerFirstName, String trainerLastName){
            boolean trainerExists = false;
            
            Connection conn = null;
            PreparedStatement preparedStatement = null; 
            ResultSet resultSet = null;
            
            try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            

            String query = "SELECT COUNT(*) "
                    + "FROM TRAINER "
                    + "WHERE TRAINER.FIRSTNAME = ? "
                    + "AND TRAINER.LASTNAME = ?";
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, trainerFirstName);
            preparedStatement.setString(2, trainerLastName);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                int count = resultSet.getInt(1);
                if(count>0)
                    trainerExists = true;
                   
            }
            
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }

            return trainerExists;
        }
    
    public int insertNewTrainer(String trainerFirstName, String trainerLastName){
        
            int rowsAffected = 0;
            
            Connection conn = null;
            PreparedStatement preparedStatement = null; 
            
            try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            
            
            String query = "INSERT INTO TRAINER (FIRSTNAME, LASTNAME) VALUES (?, ?);";
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, trainerFirstName);
            preparedStatement.setString(2, trainerLastName);
            
            rowsAffected = preparedStatement.executeUpdate();

            
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
            
        
            return rowsAffected;
        }
    
    public boolean checkIfAssignmentExists(String assignmentTitle, String assignmentDescription, java.sql.Timestamp assignmentSubDateTime){
            boolean assignmentExists = false;
            
            Connection conn = null;
            PreparedStatement preparedStatement = null; 
            ResultSet resultSet = null;
            
            try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            

            String query = "SELECT COUNT(*) "
                    + "FROM ASSIGNMENT "
                    + "WHERE ASSIGNMENT.FIRSTNAME = ? "
                    + "AND ASSIGNMENT.LASTNAME = ? "
                    + "AND ASSIGNMENT.SUB_DATE_TIME = ?";
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, assignmentTitle);
            preparedStatement.setString(2, assignmentDescription);
            preparedStatement.setTimestamp(3, assignmentSubDateTime);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                int count = resultSet.getInt(1);
                if(count>0)
                    assignmentExists = true;
                   
            }
            
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            if(resultSet != null){ 
                try{
                    resultSet.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }

            return assignmentExists;
        }
    
    public int insertNewAssignment(String assignmentTitle, String assignmentDescription, java.sql.Timestamp assignmentSubDateTime, int courseOfAssignment){
        
            int rowsAffected = 0;
            
            Connection conn = null;
            PreparedStatement preparedStatement = null; 
            
            try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            
            
            String query = "INSERT INTO ASSIGNMENT (TITLE, AS_DESCRIPTION, SUB_DATE_TIME, COURSE_ID) "
                    + "VALUES (?, ?, ?, ?);";
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, assignmentTitle);
            preparedStatement.setString(2, assignmentDescription);
            preparedStatement.setTimestamp(3, assignmentSubDateTime);
            preparedStatement.setInt(4, courseOfAssignment);
            
            rowsAffected = preparedStatement.executeUpdate();

            
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
            
        
            return rowsAffected;
        }
    
    public int insertNewStudent_Course(int studentCourseStudentId, int studentCourseCourseId, double studentCourseTuitionFees){
        
            int rowsAffected = 0;
            
            Connection conn = null;
            PreparedStatement preparedStatement = null; 
            
            try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            
            
            String query = "INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID, TUITION_FEES) "
                    + "VALUES (?, ?, ?);";
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, studentCourseStudentId);
            preparedStatement.setInt(2, studentCourseCourseId);
            preparedStatement.setDouble(3, studentCourseTuitionFees);
            
            rowsAffected = preparedStatement.executeUpdate();

            
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
            
        
            return rowsAffected;
        }
    
    public int insertNewTrainer_Course(int trainerCourseTrainerId, int trainerCourseCourseId, String trainerCourseSubject){
        
            int rowsAffected = 0;
            
            Connection conn = null;
            PreparedStatement preparedStatement = null; 
            
            try{
                
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
            System.out.println("Connection created successfully...");
            
            
            String query = "INSERT INTO TRAINER_COURSE (TRAINER_ID, COURSE_ID, SUBJECT_TAUGHT) "
                    + "VALUES (?, ?, ?);";
            
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, trainerCourseTrainerId);
            preparedStatement.setInt(2, trainerCourseCourseId);
            preparedStatement.setString(3, trainerCourseSubject);
            
            rowsAffected = preparedStatement.executeUpdate();

            
            
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }finally {
            
            if(preparedStatement != null){ 
                try{
                    preparedStatement.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
            
            if(conn != null){ 
                try{
                    conn.close();
                } catch (SQLException e){
                 e.printStackTrace();
                }
            }
        
        }
            
            
        
            return rowsAffected;
        }
    
}