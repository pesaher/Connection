package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the webuser database table.
 * 
 */
@Entity
@Table(name="webuser")
@NamedQuery(name="Webuser.findAll", query="SELECT w FROM Webuser w")
public class Webuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdUser")
	private int idUser;

	@Column(name="Adress")
	private String adress;

	@Column(name="Age")
	private int age;

	@Column(name="Category")
	private int category;

	@Column(name="Description")
	private String description;

	@Column(name="Email")
	private String email;

	@Column(name="Nickname")
	private String nickname;

	@Column(name="PasswordUser")
	private String passwordUser;

	@Column(name="ProfileImagePath")
	private String profileImagePath;

	@Column(name="Surname")
	private String surname;

	@Column(name="UserName")
	private String userName;

	//bi-directional one-to-one association to Student
	@OneToOne(mappedBy="webuser")
	private Student student;

	//bi-directional one-to-one association to Teacher
	@OneToOne(mappedBy="webuser")
	private Teacher teacher;

	public Webuser() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCategory() {
		return this.category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPasswordUser() {
		return this.passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public String getProfileImagePath() {
		return this.profileImagePath;
	}

	public void setProfileImagePath(String profileImagePath) {
		this.profileImagePath = profileImagePath;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}