package com.ashley.dojooverflow.models;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="answers")
public class Answer {
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;
		    @NotNull
		    @Size(min = 3, max = 255, message="You must enter an answer with at least 3 characters")
		    private String textA;
		    @Column(updatable=false)
		    private Date createdAt;
		    private Date updatedAt;
		    
		    @ManyToOne(fetch = FetchType.LAZY)
		    @JoinColumn(name = "question_id")
		    private Question question;
		    
//		    frontend Answer object creation from a form submission
		    public Answer() {
		        
		    }
		    
		    
//		//backend Answer creation needs all fields utilized by api call
//			public Answer(Long id, @NotNull @Size(min = 3, max = 255) String answer, Question question) {
//				this.id = id;
//				this.answer = answer;
//				this.question = question;
//			}


	//getters and setters


			public Long getId() {
				return id;
			}


			public void setId(Long id) {
				this.id = id;
			}


			


			public String getTextA() {
				return textA;
			}


			public void setTextA(String textA) {
				this.textA = textA;
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


			public Question getQuestion() {
				return question;
			}


			public void setQuestion(Question question) {
				this.question = question;
			}


			@PreUpdate
			protected void onUpdate() {
				this.updatedAt = new Date();
			}
		
			
			@PrePersist
			protected void onCreate() {
				this.createdAt = new Date();
			}

		
		
		
	}

	
	
