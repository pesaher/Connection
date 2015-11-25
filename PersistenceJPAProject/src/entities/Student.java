package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name="student")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int webuser_IdUser;

	@Column(name="Description")
	private String description;

	@Column(name="Interests")
	private String interests;

	@Column(name="Level")
	private String level;

	@Column(name="PaymentData")
	private String paymentData;

	public Student() {
	}

	public int getWebuser_IdUser() {
		return this.webuser_IdUser;
	}

	public void setWebuser_IdUser(int webuser_IdUser) {
		this.webuser_IdUser = webuser_IdUser;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInterests() {
		return this.interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPaymentData() {
		return this.paymentData;
	}

	public void setPaymentData(String paymentData) {
		this.paymentData = paymentData;
	}

}