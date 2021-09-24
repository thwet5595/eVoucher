/**
 * 
 */
package com.thwet.eVoucher.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thwet.eVoucher.model.Image;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
	Optional<Image> findByName(String name);
}
