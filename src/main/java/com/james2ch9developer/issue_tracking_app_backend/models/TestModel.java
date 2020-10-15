/*
    Works Cited:
    video title = Spring Boot, PostgreSQL, JPA, Hibernate RESTful CRUD API Tutorial
    URL = https://www.youtube.com/watch?v=eWbGV3LLwVQ
    https://github.com/RameshMF/spring-boot-tutorial/tree/master/springboot2-postgresql-jpa-hibernate-crud-example
*/

package com.james2ch9developer.issue_tracking_app_backend.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tests")
//I am using the SuppressWarnings annotation here because I think the DataClass violation is stupid.
@SuppressWarnings("PMD.DataClass")
public class TestModel implements Serializable {
    
    private static final long serialVersionUID = -8519978855257442015L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    
    // Default constructor.
    public TestModel() {
        super();
    }

    /** Another constructor. */
    public TestModel(final String firstName, final String lastName, final String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    // Setters and getters.
    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
