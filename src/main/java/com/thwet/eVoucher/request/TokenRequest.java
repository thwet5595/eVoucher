/**
 * 
 */
package com.thwet.eVoucher.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Getter
@Setter
public class TokenRequest {
	private String email;
	private String password;
}
