package onetomanyMock.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Trainer {
	@Id
	private int id;
	private String name;
	private String gst;
	@OneToMany
	private List<Students> student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public List<Students> getStudent() {
		return student;
	}

	public void setStudent(List<Students> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", gst=" + gst + ", student=" + student + "]";
	}
	
	
}
