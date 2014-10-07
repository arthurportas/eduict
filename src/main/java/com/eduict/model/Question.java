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
@Table(name = "QUESTION", uniqueConstraints = @UniqueConstraint(columnNames = "question"))
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "QUESTION_ID")
    @XmlAttribute
    private Long id;

    @NotNull
    @Size(min = 1, max = 500)
    @Pattern(regexp = "[A-Za-z ´`ç~]*", message = "question must contain only letters and spaces")
    @Column(name = "QUESTION")
    @XmlAttribute
    private String question;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DOMAIN_ID_FK", referencedColumnName = "DOMAIN_ID", unique = false, nullable = false, insertable = true, updatable = true)
    @XmlTransient
    private Domain domain;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question", cascade = CascadeType.ALL)
    private List<Response> responses;
   
   /* ==========================GETTERS/SETTERS======================= */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
}