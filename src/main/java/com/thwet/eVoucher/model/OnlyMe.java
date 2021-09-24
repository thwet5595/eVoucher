/**
 * 
 */
package com.thwet.eVoucher.model;

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
@DiscriminatorValue("OnlyMe")
@Getter
@Setter
public class OnlyMe extends BuyType {

}
