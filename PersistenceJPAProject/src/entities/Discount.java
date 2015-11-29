package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the discount database table.
 * 
 */
@Entity
@Table(name="discount")
@NamedQuery(name="Discount.findAll", query="SELECT d FROM Discount d")
public class Discount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdDiscount")
	private int idDiscount;

	@Column(name="DiscountValue")
	private String discountValue;

	@Temporal(TemporalType.DATE)
	@Column(name="ExpirationDate")
	private Date expirationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="InitDate")
	private Date initDate;

	@Column(name="Quantity")
	private double quantity;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Course course;

	public Discount() {
	}

	public int getIdDiscount() {
		return this.idDiscount;
	}

	public void setIdDiscount(int idDiscount) {
		this.idDiscount = idDiscount;
	}

	public String getDiscountValue() {
		return this.discountValue;
	}

	public void setDiscountValue(String discountValue) {
		this.discountValue = discountValue;
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

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}