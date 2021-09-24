/**
 * 
 */
package com.thwet.eVoucher.common;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
public enum Roles {
	ROLE_ADMIN("ROLE_ADMIN"), ROLE_USER("ROLE_USER");

	private final String role;

	private Roles(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
