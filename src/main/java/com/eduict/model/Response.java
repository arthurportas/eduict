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

import com.eduict.model.Question;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "RESPONSE", uniqueConstraints = @UniqueConstraint(columnNames = "response"))
public class Response implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   @Column(name="RESPONSE_ID")
   @XmlAttribute
   private Long id;

   @NotNull
   @Size(min = 1, max = 500)
   @Pattern(regexp = "[A-Za-z ´`ç~]*", message = "response must contain only letters and spaces")
   @Column(name="RESPONSE")
   @XmlAttribute
   private String response;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name="QUESTION_ID_FK", referencedColumnName = "QUESTION_ID", unique= false, nullable=false, insertable=true, updatable=true)
   @XmlTransient
   private Question question;
   
   /* ==========================GETTERS/SETTERS======================= */
   
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getResponse() {
      return response;
   }

   public void setResponse(String response) {
      this.response = response;
   }
   
   public Question getQuestion() {
      return question;
   }

   public void setQuestion(Question question) {
      this.question = question;
   }
}