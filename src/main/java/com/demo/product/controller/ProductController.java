package com.demo.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.product.model.Product;
import com.demo.product.service.ProductServiceImpl;


@RestController
@CrossOrigin
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductServiceImpl  ps;
	
	@PostMapping("/add")
	public String addProduct(@RequestBody String product) {
		
		ps.saveProduct(product);
		return "Product added";
		
	}
	@GetMapping("/get/{id}")
	public Optional<Product> getProductById( @PathVariable("id") String id) {
		
		return ps.findById(id);
	}
	@GetMapping("/get/all")
	public List<Product> getAllProduct() {
		
		return ps.findAllProduct();
	}
	@PutMapping("/update")
    public String updateEmployee(@RequestBody String product) {
        ps.updateProduct(product);
        return "Product updated";
    }
	@DeleteMapping("/delete/{id}")
	public String deleteProductById( @PathVariable("id") String id) {
		ps.deleteProduct(id);
		
		return "Product deleted";
	}
}
