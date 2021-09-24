/**
 * 
 */
package com.thwet.eVoucher.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thwet.eVoucher.model.EVoucher;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 22, 2021
 */
@Repository
public interface EVoucherRepository extends JpaRepository<EVoucher, Long> {
	void create(EVoucher eVoucher);

	Optional<EVoucher> findById(Long id);
}
