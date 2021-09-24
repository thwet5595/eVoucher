/**
 * 
 */
package com.thwet.eVoucher.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.Deflater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thwet.eVoucher.common.BuyTypes;
import com.thwet.eVoucher.common.Status;
import com.thwet.eVoucher.model.BuyType;
import com.thwet.eVoucher.model.EVoucher;
import com.thwet.eVoucher.model.GiftToOther;
import com.thwet.eVoucher.model.Image;
import com.thwet.eVoucher.model.OnlyMe;
import com.thwet.eVoucher.model.PaymentMethod;
import com.thwet.eVoucher.repository.BuyTypeRepository;
import com.thwet.eVoucher.repository.EVoucherRepository;
import com.thwet.eVoucher.repository.GiftToOtherRepository;
import com.thwet.eVoucher.repository.ImageRepository;
import com.thwet.eVoucher.repository.OnlyMeRepository;
import com.thwet.eVoucher.repository.PaymentMethodRepository;
import com.thwet.eVoucher.request.EVoucherRequest;
import com.thwet.eVoucher.service.EVoucherService;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 22, 2021
 */
@Service
public class EVoucherServiceImpl implements EVoucherService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EVoucherServiceImpl.class);

	@Autowired
	private EVoucherRepository eVoucherRepository;

	@Autowired
	private PaymentMethodRepository paymentMethodRepository;

	@Autowired
	private OnlyMeRepository onlyMeRepository;

	@Autowired
	private GiftToOtherRepository giftToOtherRepository;

	@Autowired
	private BuyTypeRepository buyTypeRepository;

	@Autowired
	private ImageRepository imageRepository;

	@Override
	public void create(EVoucherRequest eVoucherRequest) throws IOException {
		LOGGER.info("Inside create().");
		EVoucher eVoucher = this.convert(eVoucherRequest);
		eVoucher.setStatus(Status.ACTIVE.getStatus());
		eVoucherRepository.save(eVoucher);
	}

	public EVoucher convert(EVoucherRequest eVoucherRequest) throws IOException {
		LOGGER.info("Inside convert().");
		PaymentMethod paymentMethod = this.paymentMethodRepository.findByCode(eVoucherRequest.getPaymentMethod());
		if (BuyTypes.ONLY_ME.getType().equals(eVoucherRequest.getBuyType())) {
			OnlyMe onlyMe = new OnlyMe();
			onlyMe.setMaxEVoucher(eVoucherRequest.getMaxEVoucher());
			onlyMe.setName(eVoucherRequest.getName());
			onlyMe.setPhoneNumber(eVoucherRequest.getPhoneNumber());
			this.onlyMeRepository.save(onlyMe);
		} else if (BuyTypes.GIFT_TO_OTHER.getType().equals(eVoucherRequest.getBuyType())) {
			GiftToOther gitToOther = new GiftToOther();
			gitToOther.setMaxEVoucher(eVoucherRequest.getMaxEVoucher());
			gitToOther.setName(eVoucherRequest.getName());
			gitToOther.setPhoneNumber(eVoucherRequest.getPhoneNumber());
			gitToOther.setGiftPerUser(eVoucherRequest.getGiftPerUser());
			this.giftToOtherRepository.save(gitToOther);
		}
		Optional<BuyType> buyTypes = this.buyTypeRepository.findFirstByOrderByIdDesc();
		BuyType buyType = null;
		if (buyTypes.isPresent()) {
			buyType = buyTypes.get();
		}
		Image imageObj = new Image(eVoucherRequest.getImage().getName(), eVoucherRequest.getImage().getContentType(),
				compressBytes(eVoucherRequest.getImage().getBytes()), "Voucher");

		Image image = this.imageRepository.save(imageObj);

		EVoucher eVoucher = new EVoucher();
		eVoucher.setTitle(eVoucherRequest.getTitle());
		eVoucher.setDescription(eVoucherRequest.getDescription());
		eVoucher.setExpDate(eVoucherRequest.getExpiryDate());
		eVoucher.setImage(image);
		eVoucher.setAmount(eVoucherRequest.getAmount());
		eVoucher.setQuantity(eVoucherRequest.getQuantity());
		eVoucher.setPaymentMethod(paymentMethod);
		eVoucher.setDiscount(eVoucherRequest.getDiscount());
		if (buyType != null) {
			eVoucher.setBuyType(buyType);
		}
		return eVoucher;
	}

	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];

		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}

		try {
			outputStream.close();
		} catch (IOException e) {

		}
		LOGGER.info("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	@Override
	public void updateStatus(Long id, String status) {
		// TODO Auto-generated method stub
		Optional<EVoucher> eVouchers = this.eVoucherRepository.findById(id);
		EVoucher eVoucher = null;
		if (eVouchers.isPresent()) {
			eVoucher = eVouchers.get();
		}
		eVoucher.setStatus(Status.INACTIVE.getStatus());
		this.eVoucherRepository.save(eVoucher);
	}
}
