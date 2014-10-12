package com.eduict.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "RESULT")
@NamedQueries({
        @NamedQuery(name = "Result.FIND_ALL", query = "SELECT r FROM Result r")
})
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Result.FIND_ALL";

    @Id
    @GeneratedValue
    @Column(name = "RESULT_ID", unique = true, nullable = false)
    @XmlAttribute
    private Long id;

    @NotNull
    @Column(name = "RESULT_VALUE", unique = false, nullable = false)
    @XmlAttribute
    private String resultValue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "QUIZ_ID_FK", referencedColumnName = "QUIZ_ID", unique = false, nullable = true, insertable = true, updatable = true)
    @XmlTransient
    private Quiz quiz;

    /* ==========================BUILDER======================= */

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {

        private Result result;

        public Builder() {
            result = new Result();
        }

        public Builder withResultValue(String resultValue) {
            result.resultValue = resultValue;
            return this;
        }

        public Builder withQuiz(Quiz quiz) {
            result.quiz = quiz;
            return this;
        }

        public Result build() {
            return result;
        }
    }

    /* ==========================GETTERS/SETTERS======================= */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResultValue() {
        return this.resultValue;
    }

    public void setResultValue(String resultValue) {
        this.resultValue = resultValue;
    }

    public Quiz getQuiz() {
        return this.quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}