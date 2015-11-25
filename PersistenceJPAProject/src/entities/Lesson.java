package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lesson database table.
 * 
 */
@Entity
@Table(name="lesson")
@NamedQuery(name="Lesson.findAll", query="SELECT l FROM Lesson l")
public class Lesson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLesson;

	private int course_IdCourse;

	@Column(name="Title")
	private String title;

	public Lesson() {
	}

	public int getIdLesson() {
		return this.idLesson;
	}

	public void setIdLesson(int idLesson) {
		this.idLesson = idLesson;
	}

	public int getCourse_IdCourse() {
		return this.course_IdCourse;
	}

	public void setCourse_IdCourse(int course_IdCourse) {
		this.course_IdCourse = course_IdCourse;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}