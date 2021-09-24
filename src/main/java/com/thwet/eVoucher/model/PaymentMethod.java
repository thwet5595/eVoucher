/**
 * 
 */
package com.thwet.eVoucher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Payment_Method")
@Getter
@Setter
public class PaymentMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Code")
	private String code;

	@Column(name = "Status")
	private String status;

	@OneToOne(mappedBy = "paymentMethod")
	private EVoucher eVoucher;
}
