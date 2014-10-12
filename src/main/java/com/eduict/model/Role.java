package com.eduict.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "ROLE")
@NamedQueries({
        @NamedQuery(name = "Role.FIND_ALL", query = "SELECT r FROM Role r"),
        @NamedQuery(name = "Role.FIND_BY_NAME", query = "SELECT r FROM Role r WHERE r.roleName LIKE :roleName"),
        @NamedQuery(name = "Role.FIND_BY_NAME_PATTERN", query = "SELECT r FROM Role r WHERE r.roleName LIKE :roleName"),
})
public class Role implements Serializable{

    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Role.FIND_ALL";

    public static final String FIND_BY_NAME = "Role.FIND_BY_NAME";

    public static final String FIND_BY_NAME_PATTERN = "Role.FIND_BY_NAME_PATTERN";

    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID", unique = true, nullable = false)
    @XmlAttribute
    private Long id;

    @NotNull
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
    @Column(name = "NAME", nullable = false)
    @XmlAttribute
    private String roleName;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID_FK", referencedColumnName = "USER_ID", unique = false, nullable = false, insertable = true, updatable = true)
    @XmlTransient
    private User user;

    /* ==========================BUILDER======================= */

    public static Builder getBuilder() {
        return new Builder();
    }
    public static class Builder {

        private Role role;

        public Builder() {
            role = new Role();
        }

        public Builder withName(String roleName) {
            role.roleName = roleName;
            return this;
        }

        public Builder withUser(User user) {
            role.user = user;
            return this;
        }

        public Role build() {
            return role;
        }
    }

    /* ==========================GETTERS/SETTERS======================= */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}