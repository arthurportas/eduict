package com.eduict.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import javax.xml.bind.annotation.*;
import com.eduict.model.School;
import java.util.List;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "ROLE", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
@NamedQueries({
    @NamedQuery(name = "Role.FIND_ALL", query = "SELECT r from Role r"),
    @NamedQuery(name = "Role.FIND_BY_NAME", query = "SELECT r from Role r WHERE r.roleName LIKE :roleName"),
    @NamedQuery(name = "Role.FIND_BY_NAME_PATTERN", query = "SELECT r from Role r WHERE r.roleName LIKE :roleName"),
})
public class Role implements Serializable{

    /** Default value included to remove warning. Remove or modify at will. **/
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
    @Column(name = "NAME", unique = true, nullable = false)
    @XmlAttribute
    private String roleName;
    

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
        
        public Region build() {
            return region;
        }
    }
}