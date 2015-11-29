package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity
@Table(name="teacher")
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@PrimaryKeyJoinColumn
	@Id
	private int webuser_IdUser;

	@Column(name="Income")
	private double income;

	@Column(name="Paypal")
	private String paypal;

	//bi-directional many-to-many association to Course
	@ManyToMany
	@JoinTable(
		name="invitedteacher"
		, joinColumns={
			@JoinColumn(name="teacher_WebUser_IdUser")
			}
		, inverseJoinColumns={
			@JoinColumn(name="course_idCourse")
			}
		)
	private List<Course> courses1;

	//bi-directional one-to-one association to Webuser
	@OneToOne
	private Webuser webuser;

	//bi-directional many-to-many association to Course
	@ManyToMany
	@JoinTable(
		name="teachercourse"
		, joinColumns={
			@JoinColumn(name="teacher_WebUser_IdUser")
			}
		, inverseJoinColumns={
			@JoinColumn(name="course_idCourse")
			}
		)
	private List<Course> courses2;

	public Teacher() {
	}

	public int getWebuser_IdUser() {
		return this.webuser_IdUser;
	}

	public void setWebuser_IdUser(int webuser_IdUser) {
		this.webuser_IdUser = webuser_IdUser;
	}

	public double getIncome() {
		return this.income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getPaypal() {
		return this.paypal;
	}

	public void setPaypal(String paypal) {
		this.paypal = paypal;
	}

	public List<Course> getCourses1() {
		return this.courses1;
	}

	public void setCourses1(List<Course> courses1) {
		this.courses1 = courses1;
	}

	public Webuser getWebuser() {
		return this.webuser;
	}

	public void setWebuser(Webuser webuser) {
		this.webuser = webuser;
	}

	public List<Course> getCourses2() {
		return this.courses2;
	}

	public void setCourses2(List<Course> courses2) {
		this.courses2 = courses2;
	}

}