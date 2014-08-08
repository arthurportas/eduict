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

import com.eduict.model.Domain;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "question"))
public class Question implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   @Column(name="QUESTION_ID")
   @XmlAttribute
   private Long id;

   @NotNull
   @Size(min = 1, max = 500)
   @Pattern(regexp = "[A-Za-z ´`ç~]*", message = "question must contain only letters and spaces")
   @Column(name="QUESTION")
   @XmlAttribute
   private String question;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name="DOMAIN_ID_FK", referencedColumnName = "DOMAIN_ID", unique= false, nullable=false, insertable=true, updatable=true)
   @XmlTransient
   private Domain domain;
   
   /* ==========================GETTERS/SETTERS======================= */
   
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getQuestion() {
      return question;
   }

   public void setQuestion(String question) {
      this.question = question;
   }
   
   public Domain getDomain() {
      return domain;
   }

   public void setDomain(Domain domain) {
      this.domain = domain;
   }
}