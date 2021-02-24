package com.nunu.lmc.Controller;

import com.nunu.lmc.Entity.Product;
import com.nunu.lmc.Entity.ResponsePaging;
import com.nunu.lmc.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponsePaging getListAllProduct(
            @RequestHeader("pageNumber") Integer pageNumber
    ) {
        //set data from service
        Page<Product> page = productService.getListProduct(pageNumber);

        //set response
        ResponsePaging responsePaging = new ResponsePaging();
        responsePaging.setPageSize(page.getSize());
        responsePaging.setCurrentPage(pageNumber);
        responsePaging.setTotalItem(page.getTotalElements());
        responsePaging.setTotalPage(page.getTotalPages());
        responsePaging.setData(page.getContent());

        return responsePaging;
    }

    @PostMapping(path = "/add")
    public void addNewProduct(
            @RequestBody Product product
    ) {
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "/delete/{productId}")
    public  void deleteProduct(
            @PathVariable("productId") String productId
    ) {
        productService.deleteProduct(productId);
    }
}
