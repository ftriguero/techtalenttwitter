package com.tts.techtalenttwitter.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // Tell Springboot this is going to be stored in a DATABASE
public class User { 
	
	@Id //Tells Springbood that this field is going to be the database table's 
		//primary key.
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="user_id")
	private Long id;
	
	@Email(message = "Please provide a valid email")
	@NotEmpty(message = "Please provide an email")
	private String email;
	
	@Length(min = 3, message = "Your username must have at least 3 characters")
	@Length(max = 15, message = "Your username cannot have more than 15 characters")
	private String username;
	
	@Length(min = 5, message = "Your password must have at least 5 characters")
	private String password;
	
	@NotEmpty(message = "Please provide your first name")
	private String firstName;
	
	@NotEmpty(message = "Please provide your last name")
	private String lastName;
	
	private int active;
	
	@CreationTimestamp //This will tell the JPA to autopopulate this when an object 
					   //is created
	private Date createdAt;
	
	//This set of roles needs to be generated VIA a relationship in the relationship in the 
	//database to work with the JPA... we have to add annotations to define that relationship
	//and then the JPA can fill out this value.
	
	@ManyToMany(cascade = CascadeType.ALL) //Specify the Users and roles have a many to many
										   //db relationship 
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	
	private Set<Role> roles; //This will contain all the security roles that the user has.
							//However there is generally no way to store 'compound' or 
							//complicated data structures in a database..... So
							//we need to get this Set of Roles from somewhere..
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_follower", joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="follower_id"))
	private List<User> followers;
	
	@ManyToMany(mappedBy="followers")
	private List<User> following;
}
