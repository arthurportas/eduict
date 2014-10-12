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
@Table(name = "RESPONSE", uniqueConstraints = @UniqueConstraint(columnNames = "response"))
public class Response implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "RESPONSE_ID")
    @XmlAttribute
    private Long id;

    @NotNull
    @Size(min = 1, max = 500)
    @Pattern(regexp = "[A-Za-z ´`ç~]*", message = "response must contain only letters and spaces")
    @Column(name = "RESPONSE")
    @XmlAttribute
    private String response;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID_FK", referencedColumnName = "QUESTION_ID", unique = false, nullable = false, insertable = true, updatable = true)
    @XmlTransient
    private Question question;

    @NotNull
    @Size(min = 1, max = 4)
    @Pattern(regexp = "[A-Za-z ´`ç~,.]*", message = "value must contain only letters and chars specified")
    @Column(name = "VALUE")
    @XmlAttribute
    private String value;

    /* ==========================Builder======================= */

    /* ==========================GETTERS/SETTERS======================= */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}