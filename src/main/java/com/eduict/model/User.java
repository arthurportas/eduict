package com.eduict.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import com.eduict.model.Role;
import com.eduict.model.Quiz;


@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "USER")
@NamedQueries({
        @NamedQuery(name = "User.FIND_BY_EMAIL_AND_PASSWORD", query = "SELECT u FROM User u  WHERE  u.email= :email AND u.password= :password"),
        @NamedQuery(name = "User.FIND_BY_EMAIL", query = "SELECT u FROM User u  WHERE  u.email= :email")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String FIND_BY_EMAIL_AND_PASSWORD = "User.FIND_BY_EMAIL_AND_PASSWORD";
    public static final String FIND_BY_EMAIL = "User.FIND_BY_EMAIL";

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    @XmlAttribute
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[A-Za-z]*", message = "firstName must contain only letters")
    @Column(name = "FIRSTNAME")
    @XmlAttribute
    private String firstName;

    @NotNull
    @Size(min = 1, max = 100)
    @Pattern(regexp = "[A-Za-z]*", message = "lastName must contain only letters")
    @Column(name = "LASTNAME")
    @XmlAttribute
    private String lastName;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PASSWORD")
    @XmlAttribute
    private String password;

    @NotNull
    @NotEmpty
    @Email
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "AGE")
    @XmlAttribute
    @Pattern(regexp = "[A-Za-z]*", message = "gender must contain only letters")
    private String age;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[A-Za-z]*", message = "gender must contain only letters")
    @Column(name = "GENDER")
    @XmlAttribute
    private String gender;

    @NotNull
    @NotEmpty
    @Column(name = "ACADEMIC_DEGREE")
    @XmlAttribute
    private String academicDegree;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Role> roles;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Quiz> quizzes;
   
   /* ==========================GETTERS/SETTERS======================= */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }
    
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}