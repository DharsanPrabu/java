package com.demo.product.service;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.product.model.Product;
import com.demo.product.repository.ProductRepository;

@Service
public class ProductServiceImpl {
	
    private final ProductRepository productRepository;
    @Autowired
    private Product prod;
    
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	/**
	 * @param productEntity
	 */
	private Product init(String productEntity) {
		JSONObject json = new JSONObject(productEntity);
		prod = new Product();
		prod.setBrand(json.get("brand").toString());
		prod.setTitle(json.get("title").toString());
		prod.setColor(json.get("color").toString());
		prod.setQuantity(json.get("Quantity").toString());
		prod.setPrice(json.get("price").toString());
		prod.setCategory(json.get("Category").toString());
		prod.setId(json.get("uuid").toString());
		return prod;
	}

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public String saveProduct(String productEntity) {
    	init(productEntity);
        productRepository.save(prod);
        return prod.toString();
    }

    public Product updateProduct(String product) {
    	Product pr = init(product);
//        return productRepository.save(init(product));
    	Product pById = productRepository.getById(prod.getId());
    	pById = pr;
    	productRepository.save(pById);
    	return pById;
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

}