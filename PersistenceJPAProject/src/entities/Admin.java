package entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the admin database table.
 * 
 */
@Entity
@Table(name="admin")
@NamedQueries({
		
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")

})
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idAdmin;

	@Column(name="PasswordAdmin")
	private String passwordAdmin;

	public Admin() {
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