/**
 * 
 */
package com.thwet.eVoucher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thwet.eVoucher.model.PaymentMethod;
import com.thwet.eVoucher.repository.PaymentMethodRepository;
import com.thwet.eVoucher.service.PaymentMethodService;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
	@Autowired
	private PaymentMethodRepository paymentMethodRepository;

	@Override
	public void save(PaymentMethod paymentMethod) {
		// TODO Auto-generated method stub
		this.paymentMethodRepository.save(paymentMethod);
	}

	@Override
	public PaymentMethod findByCode(String code) {
		return this.paymentMethodRepository.findByCode(code);
	}
}
