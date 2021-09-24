/**
 * 
 */
package com.thwet.eVoucher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thwet.eVoucher.model.PaymentMethod;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

	PaymentMethod findByCode(String code);
}
