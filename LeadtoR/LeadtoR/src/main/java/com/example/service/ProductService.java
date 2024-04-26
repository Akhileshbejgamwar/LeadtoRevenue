package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Create a new product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    // Retrieve all products
	 public List<Product> getAllProducts() {
	        return productRepository.findAll();
	}

	// Retrieve a product by ID
	    public Product getProductById(Long id) {
	        Optional<Product> productOptional = productRepository.findById(id);
	        return productOptional.orElse(null);
	 }
	    
	// Update a product by ID
	    public Product updateProduct(Long id,Product productDetails) {
	    	Product product = getProductById(id);
	    	if(product != null) {
	    		product.setName(productDetails.getName());
	    		product.setDescription(productDetails.getDescription());
	    		product.setPrice(productDetails.getPrice());
	    		return productRepository.save(product);
	    	}
	    	return null;
	    }
	    
	 // Delete a product by ID
	    public void deleteProduct(Long id) {
	    	productRepository.deleteById(id);
	    } 
	 

}


