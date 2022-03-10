package com.integration.db.Microservice.service;

import com.integration.db.Microservice.dto.Product;
import com.integration.db.Microservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public String addProduct(Product product) {
        log.info("adding product");
        productRepository.save(product);
        return "success";
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> productCategoryList(String category) {
        /*return products.stream()
                .filter(product -> product.getCategory().getName().equalsIgnoreCase(category)).collect(Collectors.toList());
   */
        return productRepository.findByCategory(category);
    }

    public Product productById(String id) {
        //return products.stream().filter(product -> product.getId() == id).findAny().get();
        return productRepository.findById(id).get();
    }

    public String updateProduct(Product product) {
        /*for (Product prod : products) {
            if (prod.getId().equals(product.getId())) {
                productRepository.save(product);
                prod.setName(product.getName());
                prod.setCategory(product.getCategory());
                prod.setCurrency(product.getCurrency());
                prod.setDiscountDescription(product.getDiscountDescription());
                return "product updated successfully";
            }*/
        productRepository.save(product);
        return "product updated";
    }

    public String deleteProductById(String id) {
        /*for (Product product : products) {
            if (product.getId().equals(id)) {
                products.remove(product);
                return "product deleted";
            }
        }*/
        productRepository.deleteById(id);
        return "product deleted";
    }
}