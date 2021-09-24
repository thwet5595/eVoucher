/**
 * 
 */
package com.thwet.eVoucher.common;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
public enum Status {
	ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

	private final String status;

	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
