/**
 * 
 */
package com.thwet.eVoucher.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 22, 2021
 */
@Getter
@Setter
public class PromoCodeRequest {

	private String promoCode;

	private String qrCode;

	private String status;
}
