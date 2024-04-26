package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Product;
import com.example.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create a new product
    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // Retrieve all products
    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Retrieve a product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    
    // Update a product by ID
    @PutMapping("/update/{id}")
    public Product updateProductById(@PathVariable Long id,@RequestBody Product productDetails )
    {
    	return productService.updateProduct(id,productDetails );    	
    }
    
    // Delete a product by ID
    @DeleteMapping("/delete/{id}")
    public String deleteProductById(@PathVariable Long id )
    {
       productService.deleteProduct(id); 	
    	return "Resource with ID " + id + " deleted successfully";
    } 
   
    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String attributeKey,
            @RequestParam(required = false) String attributeValue) {

        if (name != null) {
            return productService.searchProductsByName(name);
        } else if (category != null) {
            return productService.searchProductsByCategory(category);
        } else if (attributeKey != null && attributeValue != null) {
            return productService.searchProductsByAttribute(attributeKey, attributeValue);
        } else {
            // If no valid filter provided, return all products
            return productService.getAllProducts();
        }
    }
}
}