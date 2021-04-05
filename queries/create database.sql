-- CREATE DATABASE private_school;
USE private_school;

CREATE TABLE STUDENT (
STUDENT_ID INT NOT NULL AUTO_INCREMENT,
FIRSTNAME VARCHAR(40),
LASTNAME VARCHAR(40),
DATEOFBIRTH DATE,
PRIMARY KEY (STUDENT_ID),
UNIQUE (FIRSTNAME, LASTNAME, DATEOFBIRTH)
);

-- DROP TABLE STUDENT;

CREATE TABLE COURSE (
COURSE_ID INT NOT NULL AUTO_INCREMENT,
TITLE VARCHAR(100),
STREAM VARCHAR(40),
CO_TYPE VARCHAR(40),
START_DATE DATE,
END_DATE DATE,
PRIMARY KEY (COURSE_ID),
UNIQUE (TITLE, STREAM, CO_TYPE)
);

-- DROP TABLE COURSE;

CREATE TABLE TRAINER (
TRAINER_ID INT NOT NULL AUTO_INCREMENT,
FIRSTNAME VARCHAR(40),
LASTNAME VARCHAR(40),
PRIMARY KEY (TRAINER_ID),
UNIQUE (FIRSTNAME, LASTNAME)
);

-- DROP TABLE TRAINER;

CREATE TABLE ASSIGNMENT (
ASSIGNMENT_ID INT NOT NULL AUTO_INCREMENT,
TITLE VARCHAR(40),
AS_DESCRIPTION VARCHAR(400),
SUB_DATE_TIME TIMESTAMP,
COURSE_ID INT NOT NULL,
PRIMARY KEY (ASSIGNMENT_ID),
UNIQUE (TITLE, AS_DESCRIPTION, SUB_DATE_TIME),
FOREIGN KEY (COURSE_ID) REFERENCES COURSE (COURSE_ID)
);

-- DROP TABLE ASSIGNMENT;

CREATE TABLE STUDENT_COURSE (
ST_CO_ID INT NOT NULL AUTO_INCREMENT,
STUDENT_ID INT NOT NULL,
COURSE_ID INT NOT NULL,
TUITION_FEES DECIMAL(7,2),
PRIMARY KEY (ST_CO_ID),
UNIQUE (STUDENT_ID,COURSE_ID),
FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT (STUDENT_ID),
FOREIGN KEY (COURSE_ID) REFERENCES COURSE (COURSE_ID)
);

-- DROP TABLE STUDENT_COURSE;

CREATE TABLE TRAINER_COURSE (
TR_CO_ID INT NOT NULL AUTO_INCREMENT,
TRAINER_ID INT NOT NULL,
COURSE_ID INT NOT NULL,
SUBJECT_TAUGHT VARCHAR(40),
PRIMARY KEY (TR_CO_ID),
UNIQUE (TRAINER_ID, COURSE_ID, SUBJECT_TAUGHT),
FOREIGN KEY (TRAINER_ID) REFERENCES TRAINER (TRAINER_ID),
FOREIGN KEY (COURSE_ID) REFERENCES COURSE (COURSE_ID)
);

-- DROP TABLE TRAINER_COURSE;


CREATE TABLE ASSIGNMENT_STUDENT (
AS_ST_ID INT NOT NULL AUTO_INCREMENT,
ASSIGNMENT_ID INT NOT NULL,
STUDENT_ID INT NOT NULL,
ORAL_MARK INT,
TOTAL_MARK INT,
PRIMARY KEY (AS_ST_ID),
UNIQUE (ASSIGNMENT_ID, STUDENT_ID),
FOREIGN KEY (ASSIGNMENT_ID) REFERENCES ASSIGNMENT (ASSIGNMENT_ID),
FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT (STUDENT_ID)
);

-- DROP TABLE ASSIGNMENT_STUDENT;