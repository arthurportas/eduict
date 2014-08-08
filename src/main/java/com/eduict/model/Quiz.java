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


@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "QUIZ", uniqueConstraints = @UniqueConstraint(columnNames = "description"))

public class Quiz implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   @Column(name="QUIZ_ID")
   @XmlAttribute
   private Long id;

   @NotNull
   @Size(min = 1, max = 100)
   @Pattern(regexp = "[A-Za-z ]*", message = "quiz description must contain only letters and spaces")
   @Column(name="DESCRIPTION")
   @XmlAttribute
   private String description;

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz", cascade=CascadeType.ALL)
   private List<Level> levels;
   
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
   
   public List<Level> getLevels() {
      return levels;
   }

   public void setDLevels(List<Level> levels) {
      this.levels = levels;
   }
}