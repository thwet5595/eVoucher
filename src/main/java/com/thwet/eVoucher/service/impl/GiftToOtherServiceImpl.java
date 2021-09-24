/**
 * 
 */
package com.thwet.eVoucher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thwet.eVoucher.model.GiftToOther;
import com.thwet.eVoucher.repository.GiftToOtherRepository;
import com.thwet.eVoucher.service.GiftToOtherService;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Service
public class GiftToOtherServiceImpl implements GiftToOtherService {

	@Autowired
	private GiftToOtherRepository giftToOtherRepository;

	@Override
	public void save(GiftToOther giftToOther) {
		// TODO Auto-generated method stub
		this.giftToOtherRepository.save(giftToOther);
	}
}
