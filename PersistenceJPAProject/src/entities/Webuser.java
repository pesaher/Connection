package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the webuser database table.
 * 
 */

@Entity
@Table(name="webuser")
@NamedQuery(name="Webuser.findAll", query="SELECT w FROM Webuser w")
public class Webuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdUser")
	private int idUser;

	@Column(name="Adress")
	private String adress;

	@Column(name="Age")
	private int age;

	@Column(name="Email")
	private String email;

	@Column(name="Name")
	private String name;

	@Column(name="Nickname")
	private String nickname;

	@Column(name="PasswordUser")
	private String passwordUser;

	@Column(name="ProfileImagePath")
	private String profileImagePath;

	@Column(name="Surname")
	private String surname;

	public Webuser() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPasswordUser() {
		return this.passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public String getProfileImagePath() {
		return this.profileImagePath;
	}

	public void setProfileImagePath(String profileImagePath) {
		this.profileImagePath = profileImagePath;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}