package com.alibaba.repository;

import com.alibaba.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author aliyun
 * @version 201907251131
 * @date 2019/7/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    UserRepository userRepository;

    @Test
    public void save(){
        User save = new User();
        save.setUsername("xerox");
        save.setPassword("E10ADC3949BA59ABBE56E057F20F883E");
        Date now = new Date();
        save.setTimes(999);
        save.setUsed_times(0);
        save.setCreateTime(now);
        save.setUpdateTime(now);
        userRepository.save(save);
    }

    @Test
    public void findAll(){
        User save = new User();
        save.setUsername("username");
        save.setPassword("E10ADC3949BA59ABBE56E057F20F883E");
        Example<User> example = Example.of(save);
        List<User> list = userRepository.findAll(example);
        logger.info("findAll {}",list.size());
    }
}
