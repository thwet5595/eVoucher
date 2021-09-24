/**
 * 
 */
package com.thwet.eVoucher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Entity
@Table(name = "User")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Email")
	private String email;

	@Column(name = "Password")
	private String password;

	@Column(name = "Old_Password")
	String oldPassword;

	@Column(name = "ROLE")
	String role;

	@Column(name = "First_Login")
	boolean firstLogin;
}
