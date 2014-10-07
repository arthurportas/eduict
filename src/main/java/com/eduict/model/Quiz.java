package com.eduict.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;
import java.util.Date;
import com.eduict.model.User;
import com.eduict.model.Result;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "QUIZ", uniqueConstraints = @UniqueConstraint(columnNames = "description"))

public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "QUIZ_ID")
    @XmlAttribute
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[A-Za-z ]*", message = "quiz description must contain only letters and spaces")
    @Column(name = "DESCRIPTION")
    @XmlAttribute
    private String description = "Quiz";

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Level> levels;
    
    @Column(name = "CREATED_AT")
    @XmlAttribute
    private Date createdAt = new java.util.Date();
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID_FK", referencedColumnName = "USER_ID", unique = false, nullable = true, insertable = true, updatable = true)
    @XmlTransient
    private User user;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Result> results;
    
    /* ==========================Builder======================= */
    
    
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

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreateAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}