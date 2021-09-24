/**
 * 
 */
package com.thwet.eVoucher.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Entity
@DiscriminatorValue("GiftToOther")
@Getter
@Setter
public class GiftToOther extends BuyType {
	@Column(name = "Gift_Per_User")
	private Integer giftPerUser;
}
