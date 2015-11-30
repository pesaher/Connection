package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the studentcourse database table.
 * 
 */
@Embeddable
public class StudentcoursePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="StudentCourse_idCourse")
	private int studentCourse_idCourse;

	@Column(name="StudentCourse_Student")
	private String studentCourse_Student;

	public StudentcoursePK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StudentcoursePK)) {
			return false;
		}
		StudentcoursePK castOther = (StudentcoursePK)other;
		return 
			(this.studentCourse_idCourse == castOther.studentCourse_idCourse)
			&& this.studentCourse_Student.equals(castOther.studentCourse_Student);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.studentCourse_idCourse;
		hash = hash * prime + this.studentCourse_Student.hashCode();
		
		return hash;
	}
}