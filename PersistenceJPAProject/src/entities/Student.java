package entities;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.*;

import com.google.common.util.concurrent.ExecutionError;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name="student")
@NamedQueries({
	@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s"),
	@NamedQuery(name = "Student.findHighestId" , query = "SELECT MAX(s.idStudent) FROM Student s"),
	@NamedQuery(name = "Student.findByNickname" , query ="SELECT s FROM Student s WHERE s.nickname LIKE :nickname")
})
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdStudent")
	private int idStudent;

	@Column(name="Address")
	private String address;

	@Column(name="Age")
	private int age;

	@Column(name="DescriptionStudent")
	private String descriptionStudent;

	@Column(name="Email")
	private String email;

	@Column(name="Interests")
	private String interests;

	@Column(name="NameStudent")
	private String nameStudent;

	@Column(name="Nickname")
	private String nickname;

	@Column(name="PasswordStudent")
	private String passwordStudent;

	@Column(name="PaymentData")
	private String paymentData;

	@Column(name="ProfileImagePath")
	private String profileImagePath;

	@Column(name="StudentLevel")
	private String studentLevel;

	@Column(name="Surname")
	private String surname;
	
	private static AtomicInteger atomicID = null;

	public Student() {}
	
	public void genID(){
		if(atomicID == null)
			generateID();
		else
			idStudent = atomicID.incrementAndGet();
	}

	public int getIdStudent() {
		return this.idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescriptionStudent() {
		return this.descriptionStudent;
	}

	public void setDescriptionStudent(String descriptionStudent) {
		this.descriptionStudent = descriptionStudent;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInterests() {
		return this.interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getNameStudent() {
		return this.nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPasswordStudent() {
		return this.passwordStudent;
	}

	public void setPasswordStudent(String passwordStudent) {
		this.passwordStudent = passwordStudent;
	}

	public String getPaymentData() {
		return this.paymentData;
	}

	public void setPaymentData(String paymentData) {
		this.paymentData = paymentData;
	}

	public String getProfileImagePath() {
		return this.profileImagePath;
	}

	public void setProfileImagePath(String profileImagePath) {
		this.profileImagePath = profileImagePath;
	}

	public String getStudentLevel() {
		return this.studentLevel;
	}

	public void setStudentLevel(String studentLevel) {
		this.studentLevel = studentLevel;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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
	
			atomicID = new AtomicInteger(em.createNamedQuery("Student.findHighestId", Integer.class)
					.getSingleResult());
			idStudent = atomicID.incrementAndGet();
			em.close();
		}catch(Error e){
			throw new ExecutionError("Error Generating the first ID of Student", e);
		}
	}

}