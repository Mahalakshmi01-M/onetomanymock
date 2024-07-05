package onetomanyMock.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanyMock.dto.Trainer;

public class TrainerDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("maha");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void saveTrainer(Trainer trainer)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(trainer);
		entityTransaction.commit();
	}
	public void updateTrainer(int id,Trainer trainer)
	{
		EntityManager entityManager=getEntityManager();
		Trainer dbtrainer=entityManager.find(Trainer.class, id);
		if(dbtrainer!=null)
		{
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			trainer.setId(id);
			trainer.setStudent(dbtrainer.getStudent());
			entityManager.merge(trainer);
			entityTransaction.commit();
		}
		else {
			System.out.println("Sorry id is not present to update trainer data");
		}
	}
	public void deleteTrainer(int id)
	{
		EntityManager entityManager=getEntityManager();
		Trainer dbtrainer = entityManager.find(Trainer.class, id);
		if(dbtrainer !=null)
		{
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbtrainer);
			entityTransaction.commit();
		}
		else {
			System.out.println("Sorry id is not present to delete Trainer data");
		}
	}
	public void findTrainer(int id)
	{
		EntityManager entityManager=getEntityManager();
		Trainer dbtrainer=entityManager.find(Trainer.class, id);
		if(dbtrainer!=null)
		{
			System.out.println(dbtrainer);
		}
		else {
			System.out.println("Sorry id is not present ");
		}
	}
}

