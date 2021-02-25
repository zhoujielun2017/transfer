package com.alibaba.controller;


import com.alibaba.controller.vo.Pagination;
import com.alibaba.repository.ProductRefRepository;
import com.alibaba.repository.ProductRepository;
import com.alibaba.controller.vo.ProductCreate;
import com.alibaba.model.JsonResult;
import com.alibaba.model.Product;
import com.alibaba.model.ProductRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductRefRepository productRefRepository;

    @RequestMapping("/list")
    public JsonResult list() {

        Pagination p = new Pagination();
        List<Product> list = productRepository.findAll();
        p.setItems(list);
        return JsonResult.success(p);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(@RequestBody ProductCreate p1) {

        productRepository.save(p1.toProduct());
        return JsonResult.success();
    }

    @GetMapping(value = "/detail")
    public JsonResult detail(String id) {

        Optional<Product> p=productRepository.findById(id);
        ProductRef ref = new ProductRef();
        ref.setProductId(id);
        Example<ProductRef> ex = Example.of(ref);
        List<ProductRef> list = productRefRepository.findAll(ex);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("product",p);
        map.put("list",list);

        return JsonResult.success(map);
    }

    @RequestMapping("/update")
    public JsonResult update(@RequestBody ProductCreate p) {

        Optional<Product> product1 = productRepository.findById(p.getId());
        Product product = product1.get();
        product.setPrice(p.getPrice());
        product.setFreight(p.getFreight());
        product.setName(p.getName());
        product.setContent(p.getContent());
        productRepository.save(product);
        return JsonResult.success();
    }

    @RequestMapping("/delete")
    public JsonResult delete(String id) {

        productRepository.deleteById(id);
        return JsonResult.success();
    }
}
