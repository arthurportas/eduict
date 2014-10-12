package com.eduict.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "REGION", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@NamedQueries({
        @NamedQuery(name = "Region.FIND_ALL", query = "SELECT r FROM Region r"),
        @NamedQuery(name = "Region.FIND_BY_NAME", query = "SELECT r FROM Region r WHERE r.regionName LIKE :regionName"),
        @NamedQuery(name = "Region.FIND_BY_NAME_PATTERN", query = "SELECT r FROM Region r WHERE r.regionName LIKE :regionName")
})
public class Region implements Serializable {

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
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
    @Column(name = "NAME", unique = true, nullable = false)
    @XmlAttribute
    private String regionName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region", cascade = CascadeType.ALL)
    private List<School> schools;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workRegion", cascade = CascadeType.ALL)
    private List<User> users = Collections.EMPTY_LIST;

    /* ==========================Builder======================= */

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {

        private Region regionEntity;

        public Builder() {
            regionEntity = new Region();
        }

        public Builder withName(String name) {
            regionEntity.regionName = name;
            return this;
        }

        public Builder withSchools(List<School> schools) {
            regionEntity.schools = schools;
            return this;
        }

        public Builder withUsers(List<User> users) {
            regionEntity.users = users;
            return this;
        }

        public Region build() {
            return regionEntity;
        }
    }
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
    

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}