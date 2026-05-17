package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository // Spring registers this as a bean. Registers bean + exception translation
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) //we inject the entity manager
    {
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional // Spring opens transaction, commits on success, rolls back on exception
    public void save(Student theStudent){
        this.entityManager.persist(theStudent); //save the java object to d as a row
    }

    @Override //We don't need transactional since we are just querying
    public Student findById(Integer id) {
        Student student = this.entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = this.entityManager.createQuery("FROM Student ORDER BY lastName desc", Student.class);
        return  theQuery.getResultList();
    }


    @Override
    public List<Student> findMany(String fieldName, String fieldValue) {
        TypedQuery<Student> theQuery = this.entityManager.createQuery("FROM Student WHERE " + fieldName + "="+ fieldValue /**Name of JPA Entity i.e Class name */, Student.class); //
        //W e didn't include SELECT keyword because hibernate is lenient on that
        //Note for above when we are using JPQL syntax we used entity name and entity fields not database name
        //The Field name is also JPA entity name not the actual database name


        List<Student> students = theQuery.getResultList();//return query result
        return students;
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery = this.entityManager.createQuery(
                "SELECT s FROM Student s WHERE s.lastName=:theData", Student.class
        ); //we used JPQL Named Parameter to query here
        //"s" here is a placeholder for entity but anything can be used
        theQuery.setParameter("theData", theLastName); //so we set theData to theLastName

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateLastName(
//            Integer id
//            , String fieldName, String fieldValue
    ) {

       int numRowsUpdated = this.entityManager.createQuery("UPDATE Student SET lastName='Aseda'")
               .executeUpdate();
        System.out.println("total updated rows is : " + numRowsUpdated);
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        this.entityManager.merge(theStudent);

    }

//    @Override
//    @Transactional
//    public void delete(Student theStudent) {
//
//        this.entityManager.remove(theStudent);
//    }

    @Override
    @Transactional
    public void delete(Integer id) {
Student theStudent = this.entityManager.find(Student.class, id);

        this.entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public void updateAStudent(Integer id
//            , String fieldName, String fieldValue
    ) {
        //find the student first
        Student theStudent = this.findById(id);

        //return if not found
        if(theStudent == null){return;}

        //change name to Ajibola
        theStudent.setFirstName("Ajibola");

        //update in db i.e persist the change
        this.entityManager.merge(theStudent);

    }
}
