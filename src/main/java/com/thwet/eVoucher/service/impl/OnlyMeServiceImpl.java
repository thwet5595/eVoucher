/**
 * 
 */
package com.thwet.eVoucher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thwet.eVoucher.model.OnlyMe;
import com.thwet.eVoucher.repository.OnlyMeRepository;
import com.thwet.eVoucher.service.OnlyMeService;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Service
public class OnlyMeServiceImpl implements OnlyMeService {

	@Autowired
	private OnlyMeRepository onlyMeRepository;

	@Override
	public void save(OnlyMe onlyMe) {
		// TODO Auto-generated method stub
		this.onlyMeRepository.save(onlyMe);
	}

}
