package com.SapPortal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SapPortal.models.PaymentRecipetDetails;

public interface PaymentRecipetDetailsRepository extends JpaRepository<PaymentRecipetDetails, Long>{
    Optional<PaymentRecipetDetails> findByFilename(String fileName);

	List<PaymentRecipetDetails> findAllByUserId(Long usersId);

	List<PaymentRecipetDetails> findAllByRecieptverifyStatus(String notVerified);

	List<PaymentRecipetDetails> findAllByRecieptverifyStatusOrderByDateTimeDesc(String notVerified);

}
