/**
 * 
 */
package com.thwet.eVoucher.common;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
public enum ResponseCode {
	SUCCESS("0000"), TOKEN_EXPIRED("0012"), ERROR("0014"), CHANGE_PASSWORD("0016"), INVALID_TOKEN("0017"), DUPLICATE(
			"0013");

	private final String responseCode;

	private ResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseCode() {
		return responseCode;
	}
}
