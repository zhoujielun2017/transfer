package com.alibaba.controller;


import com.alibaba.controller.vo.Pagination;
import com.alibaba.repository.ProductRefRepository;
import com.alibaba.controller.vo.ProductCreate;
import com.alibaba.controller.vo.ProductRefCreate;
import com.alibaba.model.JsonResult;
import com.alibaba.model.ProductRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author
 */
@RestController
@RequestMapping("/product_ref")
public class ProductRefController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductRefController.class);

    @Autowired
    private ProductRefRepository productRefRepository;

    @RequestMapping("/list")
    public JsonResult list() {

        Pagination p = new Pagination();
        List<ProductRef> list = productRefRepository.findAll();
        p.setItems(list);
        return JsonResult.success(p);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(@RequestBody ProductRefCreate p1) {

        productRefRepository.save(p1.toProductRef());
        return JsonResult.success();
    }

    @GetMapping(value = "/detail")
    public JsonResult detail(String id) {

        Optional<ProductRef> p=productRefRepository.findById(id);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("product",p);

        return JsonResult.success(map);
    }

    @RequestMapping("/update")
    public JsonResult update(@RequestBody ProductCreate p) {
        System.out.println(p);
//        Optional<Product> product1 = productRepository.findById(p.getId());
//        Product product = product1.get();
//        productRepository.save(product);
        return JsonResult.success();
    }

    @RequestMapping("/delete")
    public JsonResult delete(String id) {

        productRefRepository.deleteById(id);
        return JsonResult.success();
    }
}
