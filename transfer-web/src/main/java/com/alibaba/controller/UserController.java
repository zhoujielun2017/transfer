package com.alibaba.controller;


import com.alibaba.repository.ProductRepository;
import com.alibaba.controller.vo.LoginUser;
import com.alibaba.model.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/login")
    public JsonResult list() {

        LoginUser user = new LoginUser();
        SimpleIdGenerator id = new SimpleIdGenerator();
        user.setToken(id.generateId().toString());
        return JsonResult.success(user);
    }

    @RequestMapping("/info")
    public JsonResult add() {
        LoginUser user = new LoginUser();
        SimpleIdGenerator id = new SimpleIdGenerator();
        user.setToken(id.generateId().toString());
        user.setName("username");
        user.setAvatar("avatar");
        return JsonResult.success(user);
    }


    @RequestMapping("/logout")
    public JsonResult logout() {
        return JsonResult.success();
    }

    @RequestMapping("/avatar")
    public void avatar() {

    }

}
