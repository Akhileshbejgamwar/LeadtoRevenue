package com.example.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private double price;
    
    @ElementCollection
    private List<String> categories;
    
    @ElementCollection
    @CollectionTable(name = "product_attributes")
    @MapKeyColumn(name = "attribute_key")
    @Column(name = "attribute_value")
    private Map<String, String> attributes;
    
    @Embedded
    private Availability availability;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<Rating> ratings;   

	public Product() {
		super();
	}

	public Product(Long id, String name, String description, double price, List<String> categories,
			Map<String, String> attributes, Availability availability, List<Rating> ratings) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.categories = categories;
		this.attributes = attributes;
		this.availability = availability;
		this.ratings = ratings;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
}

