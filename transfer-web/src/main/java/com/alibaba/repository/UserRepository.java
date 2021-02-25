package com.alibaba.repository;

import com.alibaba.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * user query
 *
 * @author ruby
 * @date 27/06/17
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
