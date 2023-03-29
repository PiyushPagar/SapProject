package com.SapPortal.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SapPortal.models.PaymentInstallment;

@Repository
public interface PaymentInstallmentRepository extends JpaRepository<PaymentInstallment, Long> {

	List<PaymentInstallment> findAllByuserId(Long userId);

	@Transactional
	@Modifying
	@Query(value = "SELECT * FROM payment_installment where installment_status='unpaid' and user_id= :userId ORDER BY installment ASC",nativeQuery = true)
	List<PaymentInstallment> findpaymentInstallmentByStatus(Long userId);

//	

}
