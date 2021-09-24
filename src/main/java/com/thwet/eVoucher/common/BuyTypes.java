/**
 * 
 */
package com.thwet.eVoucher.common;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
public enum BuyTypes {
	ONLY_ME("ONLY_ME"), GIFT_TO_OTHER("GIFT_TO_OTHER");

	private final String type;

	private BuyTypes(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
