/**
 * 
 */
package com.thwet.eVoucher.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thwet.eVoucher.model.BuyType;
import com.thwet.eVoucher.repository.BuyTypeRepository;
import com.thwet.eVoucher.service.BuyTypeService;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Service
public class BuyTypeServiceImpl implements BuyTypeService {

	@Autowired
	private BuyTypeRepository buyTypeRepository;

	@Override
	public Optional<BuyType> getLastId() {
		return this.buyTypeRepository.findFirstByOrderByIdDesc();
	}

}
