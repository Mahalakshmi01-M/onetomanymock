package onetomanyMock.cont;

import onetomanyMock.dao.StudentsDao;
import onetomanyMock.dao.TrainerDao;
import onetomanyMock.dto.Students;
import onetomanyMock.dto.Trainer;

public class StudentTrainerCon {
public static void main(String[] args) {

	Trainer trainer = new Trainer();
	trainer.setId(101);
	trainer.setName("Priya");
	trainer.setGst("priya@123");
	
	TrainerDao trainerDao =new TrainerDao();
	trainerDao.saveTrainer(trainer);
	
//	SAVE STUDENT
    Students student = new Students();
    student.setId(1);
    student.setName("maha");
    student.setAddress("bangalore");
    
    StudentsDao studentDao=new StudentsDao();
    studentDao.saveStudent(101,student);
	
}
}
