/**
 * 
 */
package com.thwet.eVoucher.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.thwet.eVoucher.request.EVoucherRequest;
import com.thwet.eVoucher.service.EVoucherService;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@RestController
@RequestMapping("api")
public class EVoucherController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EVoucherController.class);

	@Autowired
	private EVoucherService eVoucherService;

	@PostMapping("/evoucher/create")
	public ResponseEntity<?> createEvoucher(@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam(value = "evoucher", required = true) String data) throws IOException {
		LOGGER.info("Inside createEvoucher");

		Gson gson = new Gson();
		EVoucherRequest eVoucherRequest = gson.fromJson(data, EVoucherRequest.class);
		eVoucherRequest.setImage(file);
		this.eVoucherService.create(eVoucherRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/evoucher/update")
	public ResponseEntity<?> updateEvoucher(@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam(value = "evoucher", required = true) String data) throws IOException {
		LOGGER.info("Inside updateEvoucher");

		Gson gson = new Gson();
		EVoucherRequest eVoucherRequest = gson.fromJson(data, EVoucherRequest.class);
		eVoucherRequest.setImage(file);
		this.eVoucherService.create(eVoucherRequest);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/evoucher/id/{id}/status/{status}")
	public ResponseEntity<?> updateStatus(@PathVariable("id") Long id, @PathVariable("status") String status) {
		LOGGER.info("Inside updateStatus");
		eVoucherService.updateStatus(id, status);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
