package com.alibaba.controller;

import com.google.gson.Gson;
import com.alibaba.AdminWebApplication;
import com.alibaba.controller.vo.ProductCreate;
import com.alibaba.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @author aliyun
 * @version 201907251159
 * @date 2019/7/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.MOCK,classes = AdminWebApplication.class)
@AutoConfigureMockMvc
public class RegControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(RegControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

//
//    /**
//     * 机器码为空
//     * @throws Exception
//     */
    @Test
    public void create() throws Exception {
        ProductCreate p = new ProductCreate();
        p.setName("name");
        p.setContent("content");
        MvcResult mvcResult = mockMvc.perform(
                post("/product/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(p)))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
//
//    /**
//     * 用户名为空
//     * @throws Exception
//     */
//    @Test
//    public void userNameNull() throws Exception {
//        UserMachineDTO dto = new UserMachineDTO();
//        dto.setMachine("12345678");
//        JSONObject obj = postRegister(dto);
//        Assert.isTrue(obj.get("code").equals("error.user.param"),"user error");
//    }
//
//    /**
//     * 密码错误
//     * @throws Exception
//     */
//    @Test
//    public void passwordWrong() throws Exception {
//        UserMachineDTO dto = new UserMachineDTO();
//        dto.setMachine("12345678");
//        dto.setUsername("username");
//        dto.setPassword("wrong password");
//        JSONObject obj = postRegister(dto);
//        logger.info(obj.toJSONString());
//        Assert.isTrue(obj.get("code").equals("error.user.param"),"user error");
//    }
//
//    /**
//     * 用户正确
//     * @throws Exception
//     */
//    @Test
//    public void userCorrect() throws Exception {
//        UserMachineDTO dto = new UserMachineDTO();
//        dto.setMachine("12345679");
//        dto.setUsername("username");
//        dto.setPassword("E10ADC3949BA59ABBE56E057F20F883E");
//        JSONObject obj = postRegister(dto);
//        logger.info(obj.toJSONString());
//        Assert.isTrue(obj.get("code").equals("success"),"user error");
//    }

}
