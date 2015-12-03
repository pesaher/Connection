package entities;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.*;

import com.google.common.util.concurrent.ExecutionError;


/**
 * The persistent class for the lessonfile database table.
 * 
 */
@Entity
@Table(name="lessonfile")
@NamedQueries({
	@NamedQuery(name="Lessonfile.findAll", query="SELECT l FROM Lessonfile l"),
	@NamedQuery(name = "Lessonfile.findHighestId" , query = "SELECT MAX(l.fileID) FROM Lessonfile l")
})
public class Lessonfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FileID")
	private int fileID;

	@Column(name="FileTitle")
	private String fileTitle;

	@Column(name="FileType")
	private String fileType;

	@Column(name="LessonFile_IdLesson")
	private int lessonFile_IdLesson;
	
	private static AtomicInteger atomicID = null;

	public Lessonfile() {}
	
	public void genID(){
		if(atomicID == null)
			generateID();
		else
			fileID = atomicID.incrementAndGet();
	}

	public int getFileID() {
		return this.fileID;
	}

	public void setFileID(int fileID) {
		this.fileID = fileID;
	}

	public String getFileTitle() {
		return this.fileTitle;
	}

	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getLessonFile_IdLesson() {
		return this.lessonFile_IdLesson;
	}

	public void setLessonFile_IdLesson(int lessonFile_IdLesson) {
		this.lessonFile_IdLesson = lessonFile_IdLesson;
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
			fileID = atomicID.incrementAndGet();
			em.close();
		}catch(Error e){
			throw new ExecutionError("Error Generating the first ID of Student", e);
		}
	}

}