package com.SapPortal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomRepository {
	
	Page<> findProductByFilter(Integer pagenum, Integer pagesize,String productName,Long offerId,
			Long  productId,Long categoryId,Long maxPrice,Long minPrice,Boolean ispopular,
		 String status,String sorting,Boolean isAsc,Pageable page,Long price);

}
