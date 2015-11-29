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

	@PrimaryKeyJoinColumn
	@EmbeddedId
	private InvitedteacherPK id;

	public Invitedteacher() {
	}

	public InvitedteacherPK getId() {
		return this.id;
	}

	public void setId(InvitedteacherPK id) {
		this.id = id;
	}

}