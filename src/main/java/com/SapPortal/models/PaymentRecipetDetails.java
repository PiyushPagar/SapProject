package com.SapPortal.models;



import javax.persistence.*;

@Entity
@Table(name = "ReceiptData")
public class PaymentRecipetDetails {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long paymentInstallmentId;
    private String dateTime;
    private String filename;
    private String recieptverifyStatus;
    private String filetype;
    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;
    
    
    public PaymentRecipetDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentRecipetDetails(Long id, Long userId, Long paymentInstallmentId, String dateTime, String filename,
			String recieptverifyStatus, String filetype, byte[] imageData) {
		super();
		this.id = id;
		this.userId = userId;
		this.paymentInstallmentId = paymentInstallmentId;
		this.dateTime = dateTime;
		this.filename = filename;
		this.recieptverifyStatus = recieptverifyStatus;
		this.filetype = filetype;
		this.imageData = imageData;
	}
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
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
    
    
    
}