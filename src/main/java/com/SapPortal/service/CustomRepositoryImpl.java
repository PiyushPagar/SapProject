package com.SapPortal.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.SapPortal.repository.CustomRepository;


@Repository
public  class CustomRepositoryImpl implements CustomRepository {
	
	@Override
	public Page<> findProductByFilter(Integer pagenum, Integer pagesize,String productName, Long offerId, Long productId,
			Long categoryId,Long maxPrice,Long minPrice,Boolean ispopular, String status,String sorting,Boolean isAsc, Pageable page,Long price) {
		Page<> pager = productRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            if (status != null && !status.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("status"), status )));
            }
            if (productName != null && !productName.equals("")) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("name"),"%"+productName+"%")));
            }
            if (offerId != null ) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("offer"), offerId)));
            }
            if (productId != null ) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("id"), productId)));
            }
            if (categoryId != null ) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("category"), categoryId)));
            }
            if (price != null ) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("price"), price)));
            }
            if ( maxPrice != null && minPrice != null ) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.between(
                                        root.get("price"), minPrice, maxPrice)));
            }
            if (ispopular != null ) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.equal(
                                        root.get("ispopular"), ispopular)));
            }
            if (sorting != null && !sorting.isEmpty()) {
            	if(isAsc==false) {
            		  criteriaQuery.orderBy(criteriaBuilder.asc(root.get(sorting)));  
            	}else {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(sorting)));   
            	}

            }
            return criteriaBuilder.and(
                    predicatesList.toArray(new Predicate[predicatesList.size()]));
        }, page);
    return pager;	
	}
}
