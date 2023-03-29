package com.SapPortal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Payment_Installment")
public class PaymentInstallment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "userId")
	private Long userId;
	
	@Column(name = "no_of_installment")
	private Integer noOfInstallment;
	
	
	@Column(name = "installment")
	private Integer installment;
	
	@Column(name = "installmentAmount")
	private Integer installmentAmount;
	
	@Column(name = "total_fees")
	private Integer totalFees ;
	
	@Column(name = "installment_status")
	private String installmentStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getNoOfInstallment() {
		return noOfInstallment;
	}

	public void setNoOfInstallment(Integer noOfInstallment) {
		this.noOfInstallment = noOfInstallment;
	}

	public Integer getInstallment() {
		return installment;
	}

	public void setInstallment(Integer installment) {
		this.installment = installment;
	}

	public Integer getInstallmentAmount() {
		return installmentAmount;
	}

	public void setInstallmentAmount(Integer installmentAmount) {
		this.installmentAmount = installmentAmount;
	}

	public Integer getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(Integer totalFees) {
		this.totalFees = totalFees;
	}

	public String getInstallmentStatus() {
		return installmentStatus;
	}

	public void setInstallmentStatus(String installmentStatus) {
		this.installmentStatus = installmentStatus;
	}

	
	
}
