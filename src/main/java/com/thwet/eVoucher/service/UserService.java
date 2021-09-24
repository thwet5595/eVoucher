/**
 * 
 */
package com.thwet.eVoucher.service;

import com.thwet.eVoucher.model.User;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
public interface UserService {

	void save(User user);

	User findByEmail(String eamil);

}
