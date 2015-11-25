package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity
@Table(name="teacher")
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int webuser_IdUser;

	@Column(name="Income")
	private double income;

	@Column(name="Paypal")
	private String paypal;

	public Teacher() {
	}

	public int getWebuser_IdUser() {
		return this.webuser_IdUser;
	}

	public void setWebuser_IdUser(int webuser_IdUser) {
		this.webuser_IdUser = webuser_IdUser;
	}

	public double getIncome() {
		return this.income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getPaypal() {
		return this.paypal;
	}

	public void setPaypal(String paypal) {
		this.paypal = paypal;
	}

}