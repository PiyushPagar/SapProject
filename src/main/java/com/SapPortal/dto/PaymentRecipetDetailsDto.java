package com.SapPortal.dto;

public class PaymentRecipetDetailsDto {

	private Long id;
	private Long userId;
	private Long paymentInstallmentId;
	private String dateTime;
	private String filename;
	private String recieptverifyStatus;
	private String filetype;
	private Integer noOfInstallment;
	private Integer installmentAmount;
	private Integer installment;

	private Integer totalFees ;
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
	public Long getPaymentInstallmentId() {
		return paymentInstallmentId;
	}
	public void setPaymentInstallmentId(Long paymentInstallmentId) {
		this.paymentInstallmentId = paymentInstallmentId;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getRecieptverifyStatus() {
		return recieptverifyStatus;
	}
	public void setRecieptverifyStatus(String recieptverifyStatus) {
		this.recieptverifyStatus = recieptverifyStatus;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public Integer getNoOfInstallment() {
		return noOfInstallment;
	}
	public void setNoOfInstallment(Integer noOfInstallment) {
		this.noOfInstallment = noOfInstallment;
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
	
	public Integer getInstallment() {
		return installment;
	}
	public void setInstallment(Integer installment) {
		this.installment = installment;
	}


}
