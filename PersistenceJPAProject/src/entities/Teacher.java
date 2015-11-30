package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity
@Table(name="teacher")
-@NamedQueries({
-	@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t"),
-	@NamedQuery(name="Teacher.findTeacherNickname", query="SELECT t FROM Teacher t")
-
-})
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdTeacher")
	private int idTeacher;

	@Column(name="Address")
	private String address;

	@Column(name="Age")
	private int age;

	@Column(name="Email")
	private String email;

	@Column(name="Income")
	private double income;

	@Column(name="NameTeacher")
	private String nameTeacher;

	@Column(name="Nickname")
	private String nickname;

	@Column(name="PasswordTeacher")
	private String passwordTeacher;

	@Column(name="Paypal")
	private String paypal;

	@Column(name="ProfileImagePath")
	private String profileImagePath;

	@Column(name="Surname")
	private String surname;

	public Teacher() {
	}

	public int getIdTeacher() {
		return this.idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getIncome() {
		return this.income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getNameTeacher() {
		return this.nameTeacher;
	}

	public void setNameTeacher(String nameTeacher) {
		this.nameTeacher = nameTeacher;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPasswordTeacher() {
		return this.passwordTeacher;
	}

	public void setPasswordTeacher(String passwordTeacher) {
		this.passwordTeacher = passwordTeacher;
	}

	public String getPaypal() {
		return this.paypal;
	}

	public void setPaypal(String paypal) {
		this.paypal = paypal;
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

}
