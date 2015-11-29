package entities;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.*;


/**
 * The persistent class for the admin database table.
 * 
 */
@Entity
@Table(name="admin")
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	//private static AtomicInteger idGenerator = new AtomicInteger(0);
	
	@Id
	private int idAdmin;

	@Column(name="PasswordAdmin")
	private String passwordAdmin;

	public Admin() {
		this.idAdmin=0;
	}

	public int getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getPasswordAdmin() {
		return this.passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}

}