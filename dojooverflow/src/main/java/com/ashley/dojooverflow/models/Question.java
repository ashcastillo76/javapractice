package com.ashley.dojooverflow.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="questions")
public class Question {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @NotNull
	    @Size(min = 3, max = 255, message= "You must have a question with at least 3 characters")
	    private String textQ;
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
	    private List<Answer> answers;
	    
//	    @ManyToMany(fetch = FetchType.LAZY)
//	    @JoinTable(
//	        name = "questions_tags", 
//	        joinColumns = @JoinColumn(name = "question_id"), 
//	        inverseJoinColumns = @JoinColumn(name = "tag_id")
//	    )
//	    @JsonIgnore
//	    private List<Tag> tags;
	    
//	    frontend Question object creation from a form submission
	    public Question() {
	        
	    }
	    
	    
	//backend Question creation needs all fields utilized by api call
//
//		public Question(Long id, @NotNull @Size(min = 3, max = 255) String question, List<Answer> answers, List<Tag> tags) {
//		this.id = id;
//		this.question = question;
//		this.answers = answers;
//		this.tags = tags;
//	}


//getters and setters

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}




		public String getTextQ() {
			return textQ;
		}


		public void setTextQ(String textQ) {
			this.textQ = textQ;
		}


		public Date getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}


		public Date getUpdatedAt() {
			return updatedAt;
		}


		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

//
//		public List<Tag> getTags() {
//			return tags;
//		}
//
//
//		public void setTags(List<Tag> tags) {
//			this.tags = tags;
//		}
//		
		


		public List<Answer> getAnswers() {
			return answers;
		}


		public void setAnswers(List<Answer> answers) {
			this.answers = answers;
		}


		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}

		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
	}
	
	
	

