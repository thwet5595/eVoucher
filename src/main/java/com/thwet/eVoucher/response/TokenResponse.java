/**
 * 
 */
package com.thwet.eVoucher.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Getter
@Setter
public class TokenResponse {
	private String type = "Bearer";
	private String code;
	private String token;
	private String desc;
	private String expiry_date_time;
}
