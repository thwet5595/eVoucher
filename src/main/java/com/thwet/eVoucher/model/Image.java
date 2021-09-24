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

import lombok.Getter;
import lombok.Setter;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Entity
@Getter
@Setter
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Content_Type")
	private String contentType;

	@Column(name = "Pic_Byte", length = 1000)
	private byte[] picByte;

	@Column(name = "Type")
	private String type;
	
	@OneToOne(mappedBy = "image")
	private EVoucher eVoucher;

	public Image() {

	}

	public Image(String name, String contentType, byte[] picByte, String type) {
		this.name = name;
		this.contentType = contentType;
		this.picByte = picByte;
		this.type = type;
	}

}
