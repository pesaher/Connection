package entities;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.*;

import com.google.common.util.concurrent.ExecutionError;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name="course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findHighestId" , query = "SELECT MAX(c.idCourse) FROM Course c"),
    @NamedQuery(name = "Course.findValidatedCourses" , query = "SELECT c FROM Course c WHERE c.validated = 1"),
    @NamedQuery(name = "Course.findByID" , query = "SELECT c FROM Course c WHERE c.idCourse = :courseID"),
    @NamedQuery(name = "Course.findByNickname", query = "SELECT c FROM Course c WHERE c.professor = :nickname"),
    @NamedQuery(name = "Course.findByNicknameValidated", query = "SELECT c FROM Course c WHERE c.professor = :nickname AND c.validated = 1"),
    @NamedQuery(name = "Course.findByNicknameNotValidated", query = "SELECT c FROM Course c WHERE c.professor = :nickname AND c.validated = 0"),
    @NamedQuery(name = "Course.findByTitle", query = "SELECT c FROM Course c WHERE c.title = :title"),
    @NamedQuery(name = "Course.findDescription", query = "SELECT c.descriptionCourse FROM Course c"),
    @NamedQuery(name = "Course.deleteByID" , query = "DELETE FROM Course c WHERE c.idCourse = :courseID")
})
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdCourse")
	private int idCourse;

	@Column(name="Category")
	private String category;

	@Column(name="DescriptionCourse")
	private String descriptionCourse;

	@Column(name="Difficulty")
	private int difficulty;

	@Column(name="Duration")
	private int duration;

	@Column(name="Highlighted")
	private int highlighted;

	@Column(name="Material")
	private String material;

	@Column(name="Notifications")
	private String notifications;

	@Column(name="Price")
	private double price;

	@Column(name="Professor")
	private String professor;

	@Column(name="Rating")
	private double rating;

	@Column(name="Syllabus")
	private String syllabus;

	@Column(name="Title")
	private String title;

	@Column(name="Validated")
	private int validated;
	
	@Transient
	private static AtomicInteger atomicID = null;

	public Course() {
	}
	
	public void genID(){
		if(atomicID == null)
			generateID();
		else
			idCourse = atomicID.incrementAndGet();
	}

	public int getIdCourse() {
		return this.idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescriptionCourse() {
		return this.descriptionCourse;
	}

	public void setDescriptionCourse(String descriptionCourse) {
		this.descriptionCourse = descriptionCourse;
	}

	public int getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getHighlighted() {
		return this.highlighted;
	}

	public void setHighlighted(int highlighted) {
		this.highlighted = highlighted;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getNotifications() {
		return this.notifications;
	}

	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProfessor() {
		return this.professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public double getRating() {
		return this.rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getValidated() {
		return this.validated;
	}

	public void setValidated(int validated) {
		this.validated = validated;
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
	
			atomicID = new AtomicInteger(em.createNamedQuery("Course.findHighestId", Integer.class)
					.getSingleResult());
			idCourse = atomicID.incrementAndGet();
			em.close();
		}catch(Error e){
			throw new ExecutionError("Error Generating the first ID of Student", e);
		}
	}

}