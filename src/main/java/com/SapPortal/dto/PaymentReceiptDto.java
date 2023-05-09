package com.SapPortal.dto;

public class PaymentReceiptDto {
	    private Long userId;
	    private Integer installmentNo;
	    
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public Integer getInstallmentNo() {
			return installmentNo;
		}
		public void setInstallmentNo(Integer installmentNo) {
			this.installmentNo = installmentNo;
		}

	    
}
