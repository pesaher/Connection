package entities;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.*;

import com.google.common.util.concurrent.ExecutionError;


/**
 * The persistent class for the teachercourse database table.
 * 
 */
@Entity
@Table(name="teachercourse")
@NamedQueries({
	@NamedQuery(name = "Teachercourse.findAll", query = "SELECT t FROM Teachercourse t"),
	@NamedQuery(name = "Teachercourse.findHighestID" , query = "SELECT  MAX(t.idTeacherCourse) FROM Teachercourse t"),
	@NamedQuery(name = "Teachercourse.findByNickname" , query = "SELECT t.teacherCourse_idCourse FROM Teachercourse t WHERE t.teacherCourse_Teacher = :nickname"),
	@NamedQuery(name = "Teachercourse.findByCourseID" , query ="SELECT t.teacherCourse_Teacher FROM Teachercourse t WHERE t.teacherCourse_idCourse = :courseID"),
	@NamedQuery(name = "Teachercourse.deleteByCourseID" , query ="DELETE FROM Teachercourse t WHERE t.teacherCourse_idCourse = :courseID")
})
public class Teachercourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdTeacherCourse")
	private int idTeacherCourse;

	@Column(name="TeacherCourse_idCourse")
	private int teacherCourse_idCourse;

	@Column(name="TeacherCourse_Teacher")
	private String teacherCourse_Teacher;
	
	@Transient
	private static AtomicInteger atomicID = null;

	public Teachercourse() {
	}
	
	public void genID(){
		if(atomicID == null)
			generateID();
		else
			idTeacherCourse = atomicID.incrementAndGet();
	}

	public int getIdTeacherCourse() {
		return this.idTeacherCourse;
	}

	public void setIdTeacherCourse(int idTeacherCourse) {
		this.idTeacherCourse = idTeacherCourse;
	}

	public int getTeacherCourse_idCourse() {
		return this.teacherCourse_idCourse;
	}

	public void setTeacherCourse_idCourse(int teacherCourse_idCourse) {
		this.teacherCourse_idCourse = teacherCourse_idCourse;
	}

	public String getTeacherCourse_Teacher() {
		return this.teacherCourse_Teacher;
	}

	public void setTeacherCourse_Teacher(String teacherCourse_Teacher) {
		this.teacherCourse_Teacher = teacherCourse_Teacher;
	}
	
	/*
	 * Function that takes the maximum value of the ID(PK) on the table
	 * and generates in an atomic way and increment of that value, so to create
	 * a new ID for the new element.
	 */
	private void generateID()
	{
		try
		{
			// 1 Create the factory of Entity Manager
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJPAProject");
		
			// 2 Create the Entity Manager
			EntityManager em = factory.createEntityManager();
		
			// 3 Get one EntityTransaction and start it
			EntityTransaction tx = em.getTransaction();
			tx.begin();
	
			atomicID = new AtomicInteger(em.createNamedQuery("Teachercourse.findHighestID", Integer.class)
					.getSingleResult());
			idTeacherCourse = atomicID.incrementAndGet();
			em.close();
		}catch(Error e){
			throw new ExecutionError("Error Generating the first ID of Teachercourse", e);
		}
	}

}