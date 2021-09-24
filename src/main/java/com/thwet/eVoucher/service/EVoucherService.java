/**
 * 
 */
package com.thwet.eVoucher.service;

import java.io.IOException;
import com.thwet.eVoucher.request.EVoucherRequest;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 22, 2021
 */
public interface EVoucherService {
	public void create(EVoucherRequest eVoucherRequest) throws IOException;
	
	public void updateStatus(Long id, String status);
}
