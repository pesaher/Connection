package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the specialoffer database table.
 * 
 */
@Entity
@Table(name="specialoffer")
@NamedQuery(name="Specialoffer.findAll", query="SELECT s FROM Specialoffer s")
public class Specialoffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdSpecialOffer")
	private int idSpecialOffer;

	@Temporal(TemporalType.DATE)
	@Column(name="ExpirationDate")
	private Date expirationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="InitDate")
	private Date initDate;

	@Column(name="Quantity")
	private double quantity;

	@Column(name="SpecialOffer_IdCourse")
	private int specialOffer_IdCourse;

	@Column(name="SpecialOfferCode")
	private String specialOfferCode;

	public Specialoffer() {
	}

	public int getIdSpecialOffer() {
		return this.idSpecialOffer;
	}

	public void setIdSpecialOffer(int idSpecialOffer) {
		this.idSpecialOffer = idSpecialOffer;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getInitDate() {
		return this.initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public int getSpecialOffer_IdCourse() {
		return this.specialOffer_IdCourse;
	}

	public void setSpecialOffer_IdCourse(int specialOffer_IdCourse) {
		this.specialOffer_IdCourse = specialOffer_IdCourse;
	}

	public String getSpecialOfferCode() {
		return this.specialOfferCode;
	}

	public void setSpecialOfferCode(String specialOfferCode) {
		this.specialOfferCode = specialOfferCode;
	}

}