package com.eduict.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Column;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "description"))
public class Domain implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   @Column(name="DOMAIN_ID")
   private Long id;

   @NotNull
   @Size(min = 1, max = 100)
   @Pattern(regexp = "[A-Za-z ]*", message = "domain description must contain only letters and spaces")
   private String description;

   @OneToMany
   @JoinColumn(name="DOMAIN_QUESTIONS", referencedColumnName="DOMAIN_ID")
   private List<Question> questions;
   
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }
   
   public List<Question> getQuestions() {
      return questions;
   }

   public void setQuestions(List<Question> questions) {
      this.questions = questions;
   }
}