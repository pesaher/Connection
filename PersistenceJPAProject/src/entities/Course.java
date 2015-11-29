package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name="course")
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdCourse")
	private int idCourse;

	@Column(name="Category")
	private String category;

	@Column(name="Description")
	private String description;

	@Column(name="Duration")
	private int duration;

	@Column(name="Highlighted")
	private byte highlighted;

	@Column(name="Material")
	private String material;

	@Column(name="Notification")
	private String notification;

	@Column(name="Price")
	private double price;

	@Column(name="Professor")
	private String professor;

	@Column(name="Rating")
	private double rating;

	@Column(name="SpecialOfferType")
	private String specialOfferType;

	@Column(name="Syllabus")
	private String syllabus;

	@Column(name="Validated")
	private byte validated;

	//bi-directional many-to-one association to Discount
	@OneToMany(mappedBy="course")
	private List<Discount> discounts;

	//bi-directional many-to-many association to Teacher
	@ManyToMany(mappedBy="courses1")
	private List<Teacher> teachers1;

	//bi-directional many-to-one association to Specialoffer
	@OneToMany(mappedBy="course")
	private List<Specialoffer> specialoffers;

	//bi-directional many-to-one association to Studentcourse
	@OneToMany(mappedBy="course")
	private List<Studentcourse> studentcourses;

	//bi-directional many-to-many association to Teacher
	@ManyToMany(mappedBy="courses2")
	private List<Teacher> teachers2;

	public Course() {
	}

	public int getIdCourse() {
		return this.idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public byte getHighlighted() {
		return this.highlighted;
	}

	public void setHighlighted(byte highlighted) {
		this.highlighted = highlighted;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getNotification() {
		return this.notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProfessor() {
		return this.professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public double getRating() {
		return this.rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getSpecialOfferType() {
		return this.specialOfferType;
	}

	public void setSpecialOfferType(String specialOfferType) {
		this.specialOfferType = specialOfferType;
	}

	public String getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public byte getValidated() {
		return this.validated;
	}

	public void setValidated(byte validated) {
		this.validated = validated;
	}

	public List<Discount> getDiscounts() {
		return this.discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public Discount addDiscount(Discount discount) {
		getDiscounts().add(discount);
		discount.setCourse(this);

		return discount;
	}

	public Discount removeDiscount(Discount discount) {
		getDiscounts().remove(discount);
		discount.setCourse(null);

		return discount;
	}

	public List<Teacher> getTeachers1() {
		return this.teachers1;
	}

	public void setTeachers1(List<Teacher> teachers1) {
		this.teachers1 = teachers1;
	}

	public List<Specialoffer> getSpecialoffers() {
		return this.specialoffers;
	}

	public void setSpecialoffers(List<Specialoffer> specialoffers) {
		this.specialoffers = specialoffers;
	}

	public Specialoffer addSpecialoffer(Specialoffer specialoffer) {
		getSpecialoffers().add(specialoffer);
		specialoffer.setCourse(this);

		return specialoffer;
	}

	public Specialoffer removeSpecialoffer(Specialoffer specialoffer) {
		getSpecialoffers().remove(specialoffer);
		specialoffer.setCourse(null);

		return specialoffer;
	}

	public List<Studentcourse> getStudentcourses() {
		return this.studentcourses;
	}

	public void setStudentcourses(List<Studentcourse> studentcourses) {
		this.studentcourses = studentcourses;
	}

	public Studentcourse addStudentcours(Studentcourse studentcours) {
		getStudentcourses().add(studentcours);
		studentcours.setCourse(this);

		return studentcours;
	}

	public Studentcourse removeStudentcours(Studentcourse studentcours) {
		getStudentcourses().remove(studentcours);
		studentcours.setCourse(null);

		return studentcours;
	}

	public List<Teacher> getTeachers2() {
		return this.teachers2;
	}

	public void setTeachers2(List<Teacher> teachers2) {
		this.teachers2 = teachers2;
	}

}