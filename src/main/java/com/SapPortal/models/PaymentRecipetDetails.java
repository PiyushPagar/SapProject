package com.SapPortal.models;


import lombok.AllArgsConstructor;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ReceiptData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    
    
    
    
}