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

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdStudentCourse")
	private int idStudentCourse;

	@Column(name="Percentage")
	private int percentage;

	@Column(name="StudentCourse_idCourse")
	private int studentCourse_idCourse;

	@Column(name="StudentCourse_Student")
	private String studentCourse_Student;

	@Column(name="Wishlist")
	private byte wishlist;

	public Studentcourse() {
	}

	public int getIdStudentCourse() {
		return this.idStudentCourse;
	}

	public void setIdStudentCourse(int idStudentCourse) {
		this.idStudentCourse = idStudentCourse;
	}

	public int getPercentage() {
		return this.percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public int getStudentCourse_idCourse() {
		return this.studentCourse_idCourse;
	}

	public void setStudentCourse_idCourse(int studentCourse_idCourse) {
		this.studentCourse_idCourse = studentCourse_idCourse;
	}

	public String getStudentCourse_Student() {
		return this.studentCourse_Student;
	}

	public void setStudentCourse_Student(String studentCourse_Student) {
		this.studentCourse_Student = studentCourse_Student;
	}

	public byte getWishlist() {
		return this.wishlist;
	}

	public void setWishlist(byte wishlist) {
		this.wishlist = wishlist;
	}

}