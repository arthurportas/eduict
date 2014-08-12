package com.eduict.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

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
    @Column(name = "LEVEL_ID")
    @XmlAttribute
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[A-Za-z ]*", message = "level description must contain only letters and spaces")
    @Column(name = "DESCRIPTION")
    @XmlAttribute
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "level", cascade = CascadeType.ALL)
    private List<Domain> domains;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "QUIZ_ID_FK", referencedColumnName = "QUIZ_ID", unique = false, nullable = false, insertable = true, updatable = true)
    @XmlTransient
    private Quiz quiz;
   
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

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}