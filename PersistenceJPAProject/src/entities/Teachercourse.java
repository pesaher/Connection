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

	@EmbeddedId
	private TeachercoursePK id;

	public Teachercourse() {
	}

	public TeachercoursePK getId() {
		return this.id;
	}

	public void setId(TeachercoursePK id) {
		this.id = id;
	}

}