package com.eduict.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import javax.xml.bind.annotation.*;
import com.eduict.model.Response;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "RESULT")
@NamedQueries({
    @NamedQuery(name = "Result.FIND_ALL", query = "SELECT r FROM Result r")
})
public class Result implements Serializable{

    /** Default value included to remove warning. Remove or modify at will. **/
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
    
    @OneToOne(fetch=FetchType.LAZY, mappedBy="result")
    @XmlTransient
    private Response response;
    
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

    public Response getResponse() {
      return this.response;
    }

    public void setResponse(Response response) {
      this.response = response;
    }
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
        
        public Builder withResponse(Response response) {
            result.response = response;
            return this;
        }
        
        public Result build() {
            return result;
        }
    }
}