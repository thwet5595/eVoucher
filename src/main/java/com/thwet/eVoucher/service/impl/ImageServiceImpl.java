/**
 * 
 */
package com.thwet.eVoucher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thwet.eVoucher.model.Image;
import com.thwet.eVoucher.repository.ImageRepository;
import com.thwet.eVoucher.service.ImageService;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Service
public class ImageServiceImpl implements ImageService {
	@Autowired
	private ImageRepository imageRepository;

	@Override
	public Image save(Image image) {
		return this.imageRepository.save(image);
	}

}
