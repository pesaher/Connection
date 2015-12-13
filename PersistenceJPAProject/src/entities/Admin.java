package entities;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.*;

import com.google.common.util.concurrent.ExecutionError;


/**
 * The persistent class for the admin database table.
 */
@Entity
@Table(name="admin")
@NamedQueries({
	@NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"), 
	@NamedQuery(name = "Admin.findHighestId" , query = "SELECT MAX(a.idAdmin) FROM Admin a"),
	@NamedQuery(name = "Admin.findByName" , query = "SELECT a FROM Admin a WHERE a.nameAdmin LIKE :NameAdmin")
})
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IdAdmin")
	private int idAdmin;

	@Column(name="NameAdmin")
	private String nameAdmin;
	
	@Column(name="SystemMoney")
	private String systemMoney;

	@Column(name="PasswordAdmin")
	private String passwordAdmin;
	
	@Transient
	private static AtomicInteger atomicID = null;

	public Admin(){}
	
	public void genID(){
		if(atomicID == null)
			generateID();
		else
			idAdmin = atomicID.incrementAndGet();
	}

	public int getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNameAdmin() {
		return this.nameAdmin;
	}

	public void setNameAdmin(String nameAdmin) {
		this.nameAdmin = nameAdmin;
	}

	public String getPasswordAdmin() {
		return this.passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}
	
	public String getSystemMoney() {
		return systemMoney;
	}

	public void setSystemMoney(String systemMoney) {
		this.systemMoney = systemMoney;
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
	
			atomicID = new AtomicInteger(em.createNamedQuery("Admin.findHighestId", Integer.class)
					.getSingleResult());
			idAdmin = atomicID.incrementAndGet();
			em.close();
		}catch(Error e){
			throw new ExecutionError("Error Generating the first ID of Student", e);
		}
	}

}