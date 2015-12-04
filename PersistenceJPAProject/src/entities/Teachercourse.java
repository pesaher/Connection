package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the teachercourse database table.
 * 
 */
@Entity
@Table(name="teachercourse")
@NamedQuery(name="Teachercourse.findAll", query="SELECT t FROM Teachercourse t")
public class Teachercourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdTeacherCourse")
	private int idTeacherCourse;

	@Column(name="TeacherCourse_idCourse")
	private int teacherCourse_idCourse;

	@Column(name="TeacherCourse_Teacher")
	private String teacherCourse_Teacher;

	public Teachercourse() {
	}

	public int getIdTeacherCourse() {
		return this.idTeacherCourse;
	}

	public void setIdTeacherCourse(int idTeacherCourse) {
		this.idTeacherCourse = idTeacherCourse;
	}

	public int getTeacherCourse_idCourse() {
		return this.teacherCourse_idCourse;
	}

	public void setTeacherCourse_idCourse(int teacherCourse_idCourse) {
		this.teacherCourse_idCourse = teacherCourse_idCourse;
	}

	public String getTeacherCourse_Teacher() {
		return this.teacherCourse_Teacher;
	}

	public void setTeacherCourse_Teacher(String teacherCourse_Teacher) {
		this.teacherCourse_Teacher = teacherCourse_Teacher;
	}

}