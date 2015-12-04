package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the invitedteacher database table.
 * 
 */
@Entity
@Table(name="invitedteacher")
@NamedQuery(name="Invitedteacher.findAll", query="SELECT i FROM Invitedteacher i")
public class Invitedteacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="InvitedTeacher_ID")
	private int invitedTeacher_ID;

	@Column(name="InvitedTeacher_HostName")
	private String invitedTeacher_HostName;

	@Column(name="InvitedTeacher_IdCourse")
	private int invitedTeacher_IdCourse;

	public Invitedteacher() {
	}

	public int getInvitedTeacher_ID() {
		return this.invitedTeacher_ID;
	}

	public void setInvitedTeacher_ID(int invitedTeacher_ID) {
		this.invitedTeacher_ID = invitedTeacher_ID;
	}

	public String getInvitedTeacher_HostName() {
		return this.invitedTeacher_HostName;
	}

	public void setInvitedTeacher_HostName(String invitedTeacher_HostName) {
		this.invitedTeacher_HostName = invitedTeacher_HostName;
	}

	public int getInvitedTeacher_IdCourse() {
		return this.invitedTeacher_IdCourse;
	}

	public void setInvitedTeacher_IdCourse(int invitedTeacher_IdCourse) {
		this.invitedTeacher_IdCourse = invitedTeacher_IdCourse;
	}

}