package com.app.pojos;
import javax.persistence.*;

@Entity
@Table(name="topics")
public class Topic extends BaseEntity{
//id | name
	@Column(name="name")
	private String topicName;
	public Topic() {
		// TODO Auto-generated constructor stub
	}
	
		public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	@Override
	public String toString() {
		return "Topic [topicId=" +getId() + ", topicName=" + topicName + "]";
	}
	
}
