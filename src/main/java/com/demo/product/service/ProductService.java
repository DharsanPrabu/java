package com.demo.product.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.product.model.Product;
import com.demo.product.repository.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private Product prod;
	@Autowired
	private ProductRepository pRepo;
	
	public String addProduct(String product) {
		System.out.println(product);
		JSONObject json = new JSONObject(product);
		
		prod.setBrand(json.get("brand").toString());
		prod.setTitle(json.get("title").toString());
		prod.setColor(json.get("color").toString());
		prod.setQuantity(json.get("Quantity").toString());
		prod.setPrice(json.get("price").toString());
		
		System.out.println("Brand : "+prod.getBrand());
		System.out.println("title : "+prod.getTitle());
		System.out.println("color : "+prod.getColor());
		System.out.println("quantity : "+prod.getQuantity());
		System.out.println("price : "+prod.getPrice());
		
		pRepo.save(prod);
		return prod.toString();
	}
	public String deleteProduct(String product) {
		
		
		return "";
		
	}

}
