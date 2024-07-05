package onetomanyMock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanyMock.dto.Students;
import onetomanyMock.dto.Trainer;



public class StudentsDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("maha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void saveStudent(int TrainerId, Students student)
	{
		EntityManager entityManager=getEntityManager();
		Trainer dbtrainer = entityManager.find(Trainer.class, TrainerId);
		if(dbtrainer!=null)
		{
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(student);
			
			List<Students> students = dbtrainer.getStudent();
			students.add(student);
			dbtrainer.setStudent(students);
			entityManager.merge(dbtrainer);
			entityTransaction.commit();
		}
		else {
			System.out.println("Sorry id is not present");
		}
	}
	public void updateStudent(int id,Students student) {
		EntityManager entityManager=getEntityManager();
		Students dbStudent = entityManager.find(Students.class, id);
		if(dbStudent!=null) {
//			id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			student.setId(id);
			entityManager.merge(student);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present to update");
		}
	}
	
	public void deleteStudent(int id) {
		EntityManager entityManager=getEntityManager();
		Students dbStudent=entityManager.find(Students.class, id);
		if(dbStudent!=null) {
//			id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbStudent);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present to delete");
		}
	}
	
	
	public void findStudent(int id) {
		EntityManager entityManager=getEntityManager();
		Students dbStudent=entityManager.find(Students.class, id);
		if(dbStudent!=null) {
//			id is present
		System.out.println(dbStudent);
		}else {
			System.out.println("Sorry id is not present to fetch");
		}
	}
}
