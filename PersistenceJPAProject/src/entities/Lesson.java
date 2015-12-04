package entities;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.*;

import com.google.common.util.concurrent.ExecutionError;


/**
 * The persistent class for the lesson database table.
 * 
 */
@Entity
@Table(name="lesson")
@NamedQueries({
	@NamedQuery(name = "Lesson.findAll", query="SELECT l FROM Lesson l"),
	@NamedQuery(name = "Lesson.findHighestId" , query = "SELECT MAX(l.idLesson) FROM Lesson l"),
	@NamedQuery(name = "Lesson.findLessonsOfCourse" , query = "SELECT l FROM Lesson l WHERE l.lesson_IdCourse = :courseID")
})
public class Lesson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdLesson")
	private int idLesson;

	@Column(name="Lesson_IdCourse")
	private int lesson_IdCourse;

	@Column(name="Title")
	private String title;
	
	private static AtomicInteger atomicID = null;

	public Lesson() {}
	
	public void genID(){
		if(atomicID == null)
			generateID();
		else
			idLesson = atomicID.incrementAndGet();
	}

	public int getIdLesson() {
		return this.idLesson;
	}

	public void setIdLesson(int idLesson) {
		this.idLesson = idLesson;
	}

	public int getLesson_IdCourse() {
		return this.lesson_IdCourse;
	}

	public void setLesson_IdCourse(int lesson_IdCourse) {
		this.lesson_IdCourse = lesson_IdCourse;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
			atomicID = new AtomicInteger(em.createNamedQuery("Lesson.findHighestId", Integer.class)
					.getSingleResult());
			idLesson = atomicID.incrementAndGet();
			em.close();
		}catch(Error e){
			throw new ExecutionError("Error Generating the first ID of Student", e);
		}
	}


}