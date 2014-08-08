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
@Table(name = "USER")

public class User implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   @Column(name="USER_ID")
   @XmlAttribute
   private Long id;

   @NotNull
   @Size(min = 1, max = 100)
   @Pattern(regexp = "[A-Za-z]*", message = "firstName must contain only letters")
   @Column(name="FIRSTNAME")
   @XmlAttribute
   private String firstName;

   @NotNull
   @Size(min = 1, max = 100)
   @Pattern(regexp = "[A-Za-z]*", message = "lastName must contain only letters")
   @Column(name="LASTNAME")
   @XmlAttribute
   private String lastName;
   
   /* ==========================GETTERS/SETTERS======================= */
   
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   
   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
   
}