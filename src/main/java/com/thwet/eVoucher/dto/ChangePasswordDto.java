/**
 * 
 */
package com.thwet.eVoucher.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Getter
@Setter
public class ChangePasswordDto {
	String email;
	String currentPassword;
	String newPassword;
}
