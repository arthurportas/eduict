package com.eduict.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import javax.xml.bind.annotation.*;
import com.eduict.model.School;


@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "REGION", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@NamedQueries({
    @NamedQuery(name = "Region.FIND_ALL", query = "SELECT r from Region r"),
    @NamedQuery(name = "Region.FIND_BY_NAME", query = "SELECT r from Region r WHERE r.regionName LIKE :regionName"),
    @NamedQuery(name = "Region.FIND_BY_NAME_PATTERN", query = "SELECT r from Region r WHERE r.regionName LIKE :regionName"),
})
public class Region implements Serializable{

    /** Default value included to remove warning. Remove or modify at will. **/
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Region.FIND_ALL";

    public static final String FIND_BY_NAME = "Region.FIND_BY_NAME";

    public static final String FIND_BY_NAME_PATTERN = "Region.FIND_BY_NAME_PATTERN";

    @Id
    @GeneratedValue
    @Column(name = "REGION_ID", unique = true, nullable = false)
    @XmlAttribute
    private Long id;

    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
    @Column(name = "NAME", unique = true, nullable = false)
    @XmlAttribute
    private String regionName;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region", cascade = CascadeType.ALL)
    private List<School> schools;

    	/* ==========================GETTERS/SETTERS======================= */

    public Long getId() {
      return this.id;
   }

    public void setId(Long id) {
      this.id = id;
   }

    public String getRegionName() {
      return this.regionName;
   }

    public void setRegionName(String regionName) {
      this.regionName = regionName;
   }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }
    
    /* ==========================BUILDER======================= */

    public static Builder getBuilder() {
        return new Builder();
    }
    public static class Builder {

        private Region region;

        public Builder() {
            region = new Region();
        }

        public Builder withName(String regionName) {
            region.regionName = regionName;
            return this;
        }

        public Builder withSchools(List<School> schools) {
            school.schools = schools;
            return this;
        }
        
        public Region build() {
            return region;
        }
    }
}