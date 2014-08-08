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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "DOMAIN")
@NamedQueries({
        @NamedQuery(name = "Domain.FIND_ALL_QUESTIONS_PER_DOMAIN_ID", query = "SELECT d FROM Domain d WHERE d.id= :id"),
})
public class Domain implements Serializable {

   private static final long serialVersionUID = 1L;

   public static final String FIND_ALL_QUESTIONS_PER_DOMAIN_ID = "Domain.FIND_ALL_QUESTIONS_PER_DOMAIN_ID";
   
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

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "domain", cascade=CascadeType.ALL)
   @XmlAttribute
   private List<Question> questions;
   
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name="LEVEL_ID_FK", referencedColumnName = "LEVEL_ID", unique= false, nullable=false, insertable=true, updatable=true)
   @XmlTransient
   private Level level;
   
   /* ==========================GETTERS/SETTERS======================= */
   
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
   
   public Level getLevel() {
      return level;
   }

   public void setLevel(Level level) {
      this.level = level;
   }
}