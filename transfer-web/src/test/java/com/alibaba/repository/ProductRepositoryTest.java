package com.alibaba.repository;

import com.alibaba.model.Product;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author aliyun
 * @version 201907251131
 * @date 2019/7/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryTest.class);

    @Autowired
    ProductRepository productRepository;

    Date now = new Date();

    @Test
    public void save(){
        Product save = new Product();

        save.setName("正品原装小米米家护眼LED台灯床头灯1代");
        save.setContent("输出参数:12V0.5A");
        save.setFreight(0);
        save.setPrice(1500);
        save.setCreateTime(now);
        save.setUpdateTime(now);
        productRepository.save(save);
    }

    @Test
    public void findAll(){
    }
}
