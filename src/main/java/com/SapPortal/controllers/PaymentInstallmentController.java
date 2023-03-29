package com.SapPortal.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SapPortal.models.PaymentInstallment;
import com.SapPortal.payload.response.MessageResponse;
import com.SapPortal.repository.PaymentInstallmentRepository;
import com.SapPortal.util.ConstantUtil;

@CrossOrigin(origins = "*")
@RestController
public class PaymentInstallmentController {

	@Autowired
	PaymentInstallmentRepository paymentInstallmentRepository;

	@PostMapping("/addNewPayentInstallment")
	public ResponseEntity<?> NewPaymentInstallment( @RequestBody List<PaymentInstallment> paymentInstallmentList) {
		try {
			for (PaymentInstallment paymentInstallment : paymentInstallmentList) {
				paymentInstallmentRepository.save(paymentInstallment);
			}
			return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(), "Payment added successfully!"));
		} catch (Exception ce) {
			return ResponseEntity.ok(new MessageResponse(HttpStatus.BAD_REQUEST.value(), ce.getMessage()));
		}
	}

	@GetMapping("/getPayentInstallment")
	public List<PaymentInstallment>  getPaymentInstallment(@RequestParam(name = "UserId") Long UserId) {
		List<PaymentInstallment> paymentInstallmentList=paymentInstallmentRepository.findAllByuserId(UserId);
		return paymentInstallmentList;
	}
	
	
	@GetMapping("/getunpaidPayentInstallment")
	public List<PaymentInstallment>  getunpaidPaymentInstallment(@RequestParam(name = "UserId") Long UserId,
			@RequestParam(name = "Status") String status) {
		List<PaymentInstallment> paymentInstallmentList=paymentInstallmentRepository.findAllByuserId(UserId);
		List<PaymentInstallment> paymentInstallmentListResponse = new ArrayList<PaymentInstallment>();
		for (PaymentInstallment paymentInstallment : paymentInstallmentList) {
			if(paymentInstallment.getInstallmentStatus().equalsIgnoreCase(status)) {
				paymentInstallmentListResponse.add(paymentInstallment);
			}
		}
		return paymentInstallmentListResponse;
	}
	
	
	@PostMapping("/updatePayentInstallment")
	public ResponseEntity<?> updatePaymentInstallment( @RequestBody List<PaymentInstallment> paymentInstallmentList) {
		try {
			PaymentInstallment paymentInstallmentListResponse = new PaymentInstallment();
			for (PaymentInstallment paymentInstallment : paymentInstallmentList) {
				paymentInstallmentListResponse.setId(paymentInstallment.getId());
				paymentInstallmentListResponse.setInstallment(paymentInstallment.getInstallment());
				paymentInstallmentListResponse.setInstallmentAmount(paymentInstallment.getInstallmentAmount());
				paymentInstallmentListResponse.setInstallmentStatus(paymentInstallment.getInstallmentStatus());
				paymentInstallmentListResponse.setNoOfInstallment(paymentInstallment.getNoOfInstallment());
				paymentInstallmentListResponse.setTotalFees(paymentInstallment.getTotalFees());
				paymentInstallmentListResponse.setUserId(paymentInstallment.getUserId());
				paymentInstallmentRepository.save(paymentInstallmentListResponse);
			}
			return ResponseEntity.ok(new MessageResponse(HttpStatus.OK.value(), "Payment Installment updated successfully!"));
		} catch (Exception ce) {
			return ResponseEntity.ok(new MessageResponse(HttpStatus.BAD_REQUEST.value(), ce.getMessage()));
		}
	}
	
	@GetMapping("/getPaymentInstallmentAmount")
	public PaymentInstallment  getPaymentInstallmentAmount(@RequestParam(name = "UserId") Long UserId) {
		List<PaymentInstallment> paymentInstallmentList=paymentInstallmentRepository.findpaymentInstallmentByStatus(UserId);
		PaymentInstallment paymentInstallmentListResponse =new PaymentInstallment();
		if(paymentInstallmentList != null  &&  !paymentInstallmentList.isEmpty()) {
		paymentInstallmentListResponse = paymentInstallmentList.get(0);
		return paymentInstallmentListResponse;
		}
		return paymentInstallmentListResponse;
	}
	
}
