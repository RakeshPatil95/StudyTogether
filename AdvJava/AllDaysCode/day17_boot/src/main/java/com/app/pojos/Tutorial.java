package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="tutorials")
public class Tutorial extends BaseEntity{
	/*
	 * name | author | publish_date | visits | contents | topic_id
	 * 
	 */
	@Column(name="name")
	private String tutName;
	private String author;
	@Column(name="publish_date")
	private LocalDate publishDate;
	private int visits;
	private String contents;
	//Many to One : Topic 1<----* Tutorial  
	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topic topic;
	
	public Tutorial() {
		// TODO Auto-generated constructor stub
	}

	public String getTutName() {
		return tutName;
	}

	public void setTutName(String tutName) {
		this.tutName = tutName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Tutorial [tutName=" + tutName + ", author=" + author + ", publishDate=" + publishDate + ", visits="
				+ visits + ", contents=" + contents + "]";
	}
		
}
