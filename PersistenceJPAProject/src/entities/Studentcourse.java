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

}