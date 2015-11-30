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
	@Column(name="IdLesson")
	private int idLesson;

	@Column(name="Lesson_IdCourse")
	private int lesson_IdCourse;

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

	public int getLesson_IdCourse() {
		return this.lesson_IdCourse;
	}

	public void setLesson_IdCourse(int lesson_IdCourse) {
		this.lesson_IdCourse = lesson_IdCourse;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}