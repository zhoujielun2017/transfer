package com.alibaba.controller;


import com.alibaba.repository.ProductRepository;
import com.alibaba.controller.vo.LoginUser;
import com.alibaba.model.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SimpleIdGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    private static final Logger LOG = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/img")
    public JsonResult list() {

        LoginUser user = new LoginUser();
        SimpleIdGenerator id = new SimpleIdGenerator();
        user.setToken(id.generateId().toString());
        return JsonResult.success(user);
    }



}
