package com.luv2code.cruddemo;

import com.luv2code.cruddemo.entity.Student;
import com.luv2code.cruddemo.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
//            createStudent(studentDAO);
            createMultipleStudents(studentDAO);
//            findStudent(studentDAO, 2);
//            deleteStudent(studentDAO, 2);
//            findStudent(studentDAO, 2);

//            updateStudent(studentDAO);
            
//            updateAStudentLastName(studentDAO);
//            findStudent(studentDAO, 2);
//            queryStudentsByLastName(studentDAO);


//
//            queryForStudents(studentDAO);
//
//            //            createMultipleStudents(studentDAO);
//
//            queryStudentsByLastName(studentDAO);
        };
    }

    private void deleteStudent(StudentDAO studentDAO, Integer id) {
        Student theStudent = studentDAO.findById(id);
        System.out.println("Student found to deleted: " + theStudent);

        studentDAO.delete(id);
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student = new Student("First", "last", "emal@com");
        System.out.println("Student before update");
        studentDAO.update(student);
        System.out.println("Student after update: " + student);
    }

    private void updateAStudentFirstName(StudentDAO studentDAO, int id) {
        System.out.println("Updating students");
        studentDAO.updateAStudent(id);
    }

    private void updateAStudentLastName(StudentDAO studentDAO) {
        System.out.println("Updating students last names \n ============ \n =========");
        studentDAO.updateLastName();
    }

    private void queryStudentsByLastName(StudentDAO studentDAO) {
        System.out.println("Queryig last name .... \n \n");
        List<Student> theStudents = studentDAO.findByLastName("ham");

        for (Student student : theStudents){
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        System.out.println("Finding all students...");

        //get list of all stude
        List<Student> studentList = studentDAO.findAll();
//        studentList.sort();
        //displaying each student
        for (Student student: studentList){
            System.out.println(student);
        }
//        System.out.println("total student is: " + studentList.size());
    }

    private void findManyStudents(StudentDAO studentDAO) {
        List<Student> students= studentDAO.findMany("lastName","'Hameed3'");
        System.out.println("Total students: " + students.size());

        List<Student> studentsB= studentDAO.findMany("firstName","'fARh'");
        System.out.println("Total students: " + studentsB.size());
        //        for (int i = 0; i < students.size(); i++) {
//            System.out.println(students.forEach(););
//
//        }
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
    //create multiple students
        System.out.println("Creating new multiple students objects...");

        Student stu1 = new Student("Far", "Hame", "far@m.com");
        Student stu2 = new Student("far02", "ham02", "hamo2@mail.co");

        // save the students
        studentDAO.save(stu1);
//        System.out.println("Saving the new student1... \n "+ stu1.toString());

//        studentDAO.save(stu2);
//        studentDAO.save(stu2);
//        studentDAO.save(stu2);
//        studentDAO.save(stu2);
//        studentDAO.save(stu2);
//        studentDAO.save(stu2);
        studentDAO.save(stu2);
//        System.out.println("Saving the new student2... \n "+ stu2.toString());


    }

    private void createStudent(StudentDAO studentDAO) /** Inject the student DAO*/{
        //create the student object
        System.out.println("Creating new student object...");

        //create a student object and save to the db
        Student tempStudent = new Student("Faruq3", "Hameed3", "faruq3@m.com");
        System.out.println("Saving the new student... \n "+ tempStudent.toString()); //hibernate actually return this from updated saved memory
        studentDAO.save(tempStudent);

      //display the newly added student
        System.out.println(tempStudent.toString());

    }

    private void findStudent(StudentDAO studentDAO, int studentId){
        System.out.println("Finding student ...");
        Student student = studentDAO.findById(studentId);
//        System.out.println("Student is : " + student);
        if(student == null){
            System.out.println("Student not found");
        }
//        else System.out.println("student is : \n \n " + student.toString());
        else System.out.println("student is : \n \n " + student);

    }
}
