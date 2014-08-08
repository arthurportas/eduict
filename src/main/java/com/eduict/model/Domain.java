package com.eduict.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "description"))
public class Domain implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   @Column(name="DOMAIN_ID")
   @XmlAttribute
   private Long id;

   @NotNull
   @Size(min = 1, max = 100)
   @Pattern(regexp = "[A-Za-z ]*", message = "domain description must contain only letters and spaces")
   @Column(name="DESCRIPTION")
   @XmlAttribute
   private String description;

   @OneToMany(fetch = FetchType.EAGER, mappedBy = "domain", cascade=CascadeType.ALL)
   @XmlTransient
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