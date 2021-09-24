/**
 * 
 */
package com.thwet.eVoucher.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 22, 2021
 */
@Entity
@Table(name = "E_Voucher")
@Getter
@Setter
public class EVoucher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "Title")
	private String title;

	@Column(name = "Description")
	private String description;

	@Column(name = "Exp_Date")
	private Date expDate;

	@OneToOne
	@JoinColumn(name = "Payment_Method_Id")
	private PaymentMethod paymentMethod;

	@OneToOne
	@JoinColumn(name = "Buy_Type_Id")
	private BuyType buyType;

	@Column(name = "Amount")
	private Double amount;

	@Column(name = "Quantity")
	private Integer quantity;

	@Column(name = "Status")
	private String status;

	@Column(name = "Discount")
	private Double discount;
	
	@OneToOne
	@JoinColumn(name = "Image_Id")
	private Image image;
}
