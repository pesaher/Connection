package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the studentcourse database table.
 * 
 */
@Entity
@Table(name="studentcourse")
@NamedQuery(name="Studentcourse.findAll", query="SELECT s FROM Studentcourse s")
public class Studentcourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StudentcoursePK id;

	@Column(name="Percentage")
	private int percentage;

	@Column(name="Wishlist")
	private byte wishlist;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="course_idCourse")
	private Course course;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="student_WebUser_IdUser")
	private Student student;

	public Studentcourse() {
	}

	public StudentcoursePK getId() {
		return this.id;
	}

	public void setId(StudentcoursePK id) {
		this.id = id;
	}

	public int getPercentage() {
		return this.percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public byte getWishlist() {
		return this.wishlist;
	}

	public void setWishlist(byte wishlist) {
		this.wishlist = wishlist;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}