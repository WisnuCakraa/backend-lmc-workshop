package com.nunu.lmc.Service;

import com.nunu.lmc.Constants;
import com.nunu.lmc.Entity.ErrorException;
import com.nunu.lmc.Entity.Product;
import com.nunu.lmc.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getListProduct(Integer pageNumber){
        Pageable page = PageRequest.of(pageNumber - 1, 10, Sort.by("name").ascending()); //FE would send page start 1, but here would start 0

        return productRepository.findAll(page);
    }

    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(String productId) {
        boolean exist = productRepository.existsById(productId);
        ErrorException error = new ErrorException(Constants.ID_NOT_EXIST_ERROR_CODE, "Product ID doesnt exist");

        if(!exist) {
            throw new IllegalStateException(error.getFullErrorMessage());
        }

        productRepository.deleteById(productId);
    }




}
