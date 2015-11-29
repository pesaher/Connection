package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lessonfile database table.
 * 
 */
@Entity
@Table(name="lessonfile")
@NamedQuery(name="Lessonfile.findAll", query="SELECT l FROM Lessonfile l")
public class Lessonfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FileID")
	private int fileID;

	@Column(name="FileTitle")
	private String fileTitle;

	@Column(name="FileType")
	private String fileType;

	//bi-directional many-to-one association to Lesson
	@ManyToOne
	private Lesson lesson;

	public Lessonfile() {
	}

	public int getFileID() {
		return this.fileID;
	}

	public void setFileID(int fileID) {
		this.fileID = fileID;
	}

	public String getFileTitle() {
		return this.fileTitle;
	}

	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Lesson getLesson() {
		return this.lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

}