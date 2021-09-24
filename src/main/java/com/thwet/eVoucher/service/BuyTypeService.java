/**
 * 
 */
package com.thwet.eVoucher.service;

import java.util.Optional;

import com.thwet.eVoucher.model.BuyType;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
public interface BuyTypeService {
	public Optional<BuyType> getLastId();
}
