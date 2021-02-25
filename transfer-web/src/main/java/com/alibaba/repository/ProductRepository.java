package com.alibaba.repository;

import com.alibaba.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Product query
 *
 * @author aliyun
 * @date 27/06/17
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
