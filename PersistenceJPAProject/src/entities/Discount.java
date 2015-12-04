package entities;

import java.io.Serializable;

import javax.persistence.*;

import com.google.common.util.concurrent.ExecutionError;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * The persistent class for the discount database table.
 * 
 */
@Entity
@Table(name="discount")

@NamedQueries({
	@NamedQuery(name="Discount.findAll", query="SELECT d FROM Discount d"),
	@NamedQuery(name = "Discount.findHighestId" , query = "SELECT MAX(d.idDiscount) FROM Discount d"),
	@NamedQuery(name = "Discount.findByCourseID" , query = "SELECT d FROM Discount d WHERE d.discount_IdCourse = :idCourse")
})
public class Discount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdDiscount")
	private int idDiscount;

	@Column(name="Discount_IdCourse")
	private int discount_IdCourse;

	@Column(name="DiscountCode")
	private String discountCode;

	@Temporal(TemporalType.DATE)
	@Column(name="ExpirationDate")
	private Date expirationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="InitDate")
	private Date initDate;

	@Column(name="Quantity")
	private double quantity;
	
	@Transient
	private static AtomicInteger atomicID = null;

	public Discount() {}
	
	public void genID(){
		if(atomicID != null)
			generateID();
		else
			idDiscount = atomicID.incrementAndGet();
	}

	public int getIdDiscount() {
		return this.idDiscount;
	}

	public void setIdDiscount(int idDiscount) {
		this.idDiscount = idDiscount;
	}

	public int getDiscount_IdCourse() {
		return this.discount_IdCourse;
	}

	public void setDiscount_IdCourse(int discount_IdCourse) {
		this.discount_IdCourse = discount_IdCourse;
	}

	public String getDiscountCode() {
		return this.discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
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

	/*
	 * Function that takes the maximum value of the ID(PK) on the table
	 * and generates in an atomic way and increment of that value, so to create
	 * a new ID for the new element.
	 */
	private void generateID()
	{
		try
		{
			// 1 Create the factory of Entity Manager
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceJPAProject");
		
			// 2 Create the Entity Manager
			EntityManager em = factory.createEntityManager();
		
			// 3 Get one EntityTransaction and start it
			EntityTransaction tx = em.getTransaction();
			tx.begin();
	
			atomicID = new AtomicInteger(em.createNamedQuery("Discount.findHighestId", Integer.class)
					.getSingleResult());
			idDiscount = atomicID.incrementAndGet();
			em.close();
		}catch(Error e){
			throw new ExecutionError("Error Generating the first ID of Student", e);
		}
	}

}