package com.mskcc.chat.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Entity
@Table(name = "USERS")
public class User {
	
    public User(String username, String firstName, String lastName, String email, String password) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	@Id    
    @Column(name="ID", unique=true, updatable=false, nullable=false)
	@GeneratedValue
	private long id; 

    @Column(name="USERNAME", unique=true, updatable=false, nullable=false)
    private String username;
    
    @Column(name="FIRST_NAME", unique=false, updatable=true, nullable=false)
    private String firstName;
    
    @Column(name="LAST_NAME", unique=false, updatable=true, nullable=false)
    private String lastName;
    
    @Column(name="EMAIL", unique=true, updatable=true, nullable=false)
    private String email;
    
    @Column(name="PASSWORD", unique=false, updatable=true, nullable=false)
    private String password;
    
    // Getters and setters

    public User() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
