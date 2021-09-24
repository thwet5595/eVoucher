/**
 * 
 */
package com.thwet.eVoucher.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thwet.eVoucher.model.BuyType;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Repository
public interface BuyTypeRepository extends JpaRepository<BuyType, Long> {
	Optional<BuyType> findFirstByOrderByIdDesc();
}
