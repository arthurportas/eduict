package com.eduict.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import com.eduict.model.Region;


@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "SCHOOL", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@NamedQueries({
    @NamedQuery(name = "School.FIND_ALL", query = "SELECT s from School s"),
    @NamedQuery(name = "School.FIND_BY_NAME", query = "SELECT s from School s WHERE s.schoolName LIKE :schoolName"),
    @NamedQuery(name = "School.FIND_BY_NAME_PATTERN", query = "SELECT s from School s WHERE s.schoolName LIKE :schoolName"),
})
public class School implements Serializable{

    /** Default value included to remove warning. Remove or modify at will. **/
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "School.FIND_ALL";

    public static final String FIND_BY_NAME = "School.FIND_BY_NAME";

    public static final String FIND_BY_NAME_PATTERN = "School.FIND_BY_NAME_PATTERN";

    @Id
    @GeneratedValue
    @Column(name = "SCHOOL_ID", unique = true, nullable = false)
    @XmlAttribute
    private Long id;

    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
    @Column(name = "NAME", unique = true, nullable = false)
    @XmlAttribute
    private String schoolName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REGION_ID_FK", referencedColumnName = "REGION_ID", unique = false, nullable = false, insertable = true, updatable = true)
    @XmlTransient
    private Region region;
    
    /* ==========================GETTERS/SETTERS======================= */

    public Long getId() {
      return this.id;
   }

    public void setId(Long id) {
      this.id = id;
   }

    public String getSchoolName() {
      return this.schoolName;
    }

    public void setSchoolName(String schoolName) {
      this.schoolName = schoolName;
    }

    public Region getRegion() {
      return this.region;
    }

    public void setRegion(Region region) {
      this.region = region;
    }
    /* ==========================BUILDER======================= */

    public static Builder getBuilder() {
        return new Builder();
    }
    public static class Builder {

        private School school;

        public Builder() {
            school = new School();
        }

        public Builder withName(String schoolName) {
            school.schoolName = schoolName;
            return this;
        }

        public Builder withRegion(Region region) {
            school.region = region;
            return this;
        }
        
        public School build() {
            return school;
        }
    }
}