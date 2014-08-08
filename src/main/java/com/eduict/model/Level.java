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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "LEVEL", uniqueConstraints = @UniqueConstraint(columnNames = "description"))
@NamedQueries({
        @NamedQuery(name = "Level.FIND_ALL_QUESTIONS_PER_LEVEL_ID", query = "SELECT l FROM Level l WHERE l.id= :id"),
})
public class Level implements Serializable {

   private static final long serialVersionUID = 1L;

   public static final String FIND_ALL_QUESTIONS_PER_LEVEL_ID = "Level.FIND_ALL_QUESTIONS_PER_LEVEL_ID";
   
   @Id
   @GeneratedValue
   @Column(name="LEVEL_ID")
   @XmlAttribute
   private Long id;

   @NotNull
   @Size(min = 1, max = 100)
   @Pattern(regexp = "[A-Za-z ]*", message = "level description must contain only letters and spaces")
   @Column(name="DESCRIPTION")
   @XmlAttribute
   private String description;

   @OneToMany(mappedBy = "level", cascade=CascadeType.ALL)
   @Fetch(value = FetchMode.LAZY)
   @XmlAttribute
   private List<Domain> domains;
   
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
   
   public List<Domain> getDomains() {
      return domains;
   }

   public void setDomains(List<Domain> domains) {
      this.domains = domains;
   }
}