package com.SapPortal.security.services;

import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.SapPortal.models.PaymentInstallment;
import com.SapPortal.models.PaymentRecipetDetails;
import com.SapPortal.repository.PaymentInstallmentRepository;
import com.SapPortal.repository.PaymentRecipetDetailsRepository;
import com.SapPortal.util.ConstantUtil;
import com.SapPortal.util.DateUtil;
import com.SapPortal.util.ImageUtils;


@Service
public class PaymentRecipetDetailsService {

	
    @Autowired
    private PaymentRecipetDetailsRepository repository;
    @Autowired
	PaymentInstallmentRepository paymentInstallmentRepository;
    
   

    public String uploadImage(MultipartFile file, Long installmentNumber, Long userId) throws IOException {
    	String currDateTime = DateUtil.currentformatDateTime(ConstantUtil.DateFormat);
    	String fileName=file.getOriginalFilename()+currDateTime;
    	PaymentInstallment paymentInstallment =paymentInstallmentRepository.findById(installmentNumber).get();
    	paymentInstallment.setInstallmentStatus(ConstantUtil.Paid);
    	paymentInstallmentRepository.save(paymentInstallment);
    	PaymentRecipetDetails imageData = repository.save(PaymentRecipetDetails.builder()
                .filename(fileName)
                .filetype(file.getContentType())
                .userId(userId)
                .recieptverifyStatus(ConstantUtil.NotVerified)
                .dateTime(currDateTime)
                .paymentInstallmentId(installmentNumber)
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return "file not uploaded successfully : " + file.getOriginalFilename();
    }

    
    public byte[] downloadImage(String fileName){
        Optional<PaymentRecipetDetails> dbImageData = repository.findByFilename(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }


}
