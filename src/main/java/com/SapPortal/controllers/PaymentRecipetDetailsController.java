package com.SapPortal.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SapPortal.dto.PaymentRecipetDetailsDto;
import com.SapPortal.models.PaymentInstallment;
import com.SapPortal.models.PaymentRecipetDetails;
import com.SapPortal.repository.PaymentInstallmentRepository;
import com.SapPortal.repository.PaymentRecipetDetailsRepository;
import com.SapPortal.security.services.PaymentRecipetDetailsService;
import com.SapPortal.util.ConstantUtil;

@RestController
@CrossOrigin(origins = "*")
public class PaymentRecipetDetailsController {

	@Autowired
	private PaymentRecipetDetailsService service;

	@Autowired
	private PaymentRecipetDetailsRepository repository;
	
	@Autowired
	PaymentInstallmentRepository paymentInstallmentRepository;

	@PostMapping("/uploadfeesreceipt")
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file,
			@RequestParam("paymantinstallmentIds") Integer paymantinstallmentIds,
			@RequestParam("usersID") Integer usersID) throws IOException {
		@SuppressWarnings("deprecation")
		Long userId = new Long(usersID);
		@SuppressWarnings("deprecation")
		Long paymantinstallmentId = new Long(paymantinstallmentIds);
		String uploadImage = service.uploadImage(file, paymantinstallmentId, userId);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}

	@GetMapping("getfeesreceipt/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
		byte[] imageData = service.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);

	}
	
	
	@PostMapping("updatefeesreceiptstatus/{id}/{status}")
	public ResponseEntity<?> updateFeesrecieptStatus(@PathVariable("id") Integer id,@PathVariable("status") String status) {
		@SuppressWarnings("deprecation")
		Long ids = new Long(id);
		PaymentRecipetDetails paymentRecipetDetails=repository.findById(ids).get();
		paymentRecipetDetails.setRecieptverifyStatus(status);
		repository.save(paymentRecipetDetails);
		return ResponseEntity.status(HttpStatus.OK).body("Status Updated Successful");
	}
	

	@GetMapping("getReceiptByuserId/{userId}")
	public ResponseEntity<?> get(@PathVariable("userId") Integer userId) {
		@SuppressWarnings("deprecation")
		Long usersId = new Long(userId);
		List <PaymentRecipetDetails> PaymentRecipetDetailsList=repository.findAllByUserId(usersId);
		return ResponseEntity.status(HttpStatus.OK).body(PaymentRecipetDetailsList);
	}
	
	@GetMapping("getReceiptverification")
	public ResponseEntity<?> getReceiptVerfication() {
		List <PaymentRecipetDetails> PaymentRecipetDetailsList=repository.findAllByRecieptverifyStatusOrderByDateTimeDesc(ConstantUtil.NotVerified);
		List<PaymentRecipetDetailsDto> paymentRecipetDetailsDtoList = new ArrayList<PaymentRecipetDetailsDto>();
		for(PaymentRecipetDetails paymentRecipetDetails : PaymentRecipetDetailsList) {
			PaymentInstallment paymentInstallment =paymentInstallmentRepository.findById(paymentRecipetDetails.getPaymentInstallmentId()).get();
			PaymentRecipetDetailsDto paymentRecipetDetailsDto = new PaymentRecipetDetailsDto();
			paymentRecipetDetailsDto.setDateTime(paymentRecipetDetails.getDateTime());
			paymentRecipetDetailsDto.setFilename(paymentRecipetDetails.getFilename());
			paymentRecipetDetailsDto.setFiletype(paymentRecipetDetails.getFiletype());
			paymentRecipetDetailsDto.setId(paymentRecipetDetails.getId());
			paymentRecipetDetailsDto.setInstallmentAmount(paymentInstallment.getInstallmentAmount());
			paymentRecipetDetailsDto.setInstallment(paymentInstallment.getInstallment());
			paymentRecipetDetailsDto.setNoOfInstallment(paymentInstallment.getNoOfInstallment());
			paymentRecipetDetailsDto.setTotalFees(paymentInstallment.getTotalFees());
			paymentRecipetDetailsDto.setPaymentInstallmentId(paymentRecipetDetails.getPaymentInstallmentId());
			paymentRecipetDetailsDto.setRecieptverifyStatus(paymentRecipetDetails.getRecieptverifyStatus());
			paymentRecipetDetailsDto.setUserId(paymentRecipetDetails.getUserId());
			paymentRecipetDetailsDtoList.add(paymentRecipetDetailsDto);
		}
		return ResponseEntity.status(HttpStatus.OK).body(paymentRecipetDetailsDtoList);
	}

}
