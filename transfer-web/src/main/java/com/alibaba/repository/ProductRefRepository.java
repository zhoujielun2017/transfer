package com.alibaba.repository;

import com.alibaba.model.ProductRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Product Ref query
 *
 * @author aliyun
 * @date 27/06/17
 */
@Repository
public interface ProductRefRepository extends JpaRepository<ProductRef, String> {

}
