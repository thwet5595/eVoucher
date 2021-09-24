/**
 * 
 */
package com.thwet.eVoucher.service;

import com.thwet.eVoucher.model.PaymentMethod;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
public interface PaymentMethodService {

	void save(PaymentMethod paymentMethod);

	PaymentMethod findByCode(String code);
}
