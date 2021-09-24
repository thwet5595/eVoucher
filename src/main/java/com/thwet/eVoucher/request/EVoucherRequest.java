/**
 * 
 */
package com.thwet.eVoucher.request;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 22, 2021
 */
@Getter
@Setter
public class EVoucherRequest {
	private Long id;

	private String title;

	private String description;

	private Date expiryDate;

	private MultipartFile image;

	private String imageUrl;

	private Double amount;

	private Double discount;

	private Integer quantity;

	private String status;

	private String paymentMethod;

	private Integer maxEVoucher;

	private Integer giftPerUser;

	private String buyType;

	private String name;

	private String phoneNumber;
}
