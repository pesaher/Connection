package entities;

import java.io.Serializable;

import javax.persistence.*;

import com.google.common.util.concurrent.ExecutionError;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * The persistent class for the specialoffer database table.
 * 
 */
@Entity
@Table(name="specialoffer")
@NamedQueries({
	@NamedQuery(name="Specialoffer.findAll", query="SELECT s FROM Specialoffer s"),
	@NamedQuery(name = "Specialoffer.findHighestId" , query = "SELECT MAX(s.idSpecialOffer) FROM Specialoffer s")
})
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

	@Column(name="Name")
	private String name;
	
	
	@Column(name="Description")
	private String description;

	@Column(name="SpecialOfferCode")
	private String specialOfferCode;
	
	private static AtomicInteger atomicID = null;

	public Specialoffer() {}
	
	public void genID(){
		if(atomicID == null)
			generateID();
		else
			idSpecialOffer = atomicID.incrementAndGet();
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



	public String getSpecialOfferCode() {
		return this.specialOfferCode;
	}

	public void setSpecialOfferCode(String specialOfferCode) {
		this.specialOfferCode = specialOfferCode;
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
	
			atomicID = new AtomicInteger(em.createNamedQuery("Specialoffer.findHighestId", Integer.class)
					.getSingleResult());
			idSpecialOffer = atomicID.incrementAndGet();
			em.close();
		}catch(Error e){
			throw new ExecutionError("Error Generating the first ID of Teacher", e);
		}
	}

}