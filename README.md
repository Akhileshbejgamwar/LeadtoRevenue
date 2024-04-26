# LeadtoRevenue
	Data Model Diagram
  				------------------------------------
  
 Product Entity:
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | bigint       | NO   | PRI | NULL    | auto_increment |
| in_stock    | bit(1)       | YES  |     | NULL    |                |
| quantity    | int          | YES  |     | NULL    |                |
| description | varchar(255) | YES  |     | NULL    |                |
| name        | varchar(255) | YES  |     | NULL    |                |
| price       | double       | YES  |     | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+

 product_attributes:
+-----------------+--------------+------+-----+---------+-------+
| Field           | Type         | Null | Key | Default | Extra |
+-----------------+--------------+------+-----+---------+-------+
| product_id      | bigint       | NO   | PRI | NULL    |       |
| attribute_value | varchar(255) | YES  |     | NULL    |       |
| attribute_key   | varchar(255) | NO   | PRI | NULL    |       |
+-----------------+--------------+------+-----+---------+-------+

product_categories:
--+--------------+------+-----+----------+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| product_id | bigint       | NO   | MUL | NULL    |       |
| categories | varchar(255) | YES  |     | NULL    |       |
+------------+--------------+------+-----+---------+-------+

 rating:
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| user_id    | varchar(255) | NO   | PRI | NULL    |       |
| comment    | varchar(255) | YES  |     | NULL    |       |
| rating     | int          | NO   |     | NULL    |       |
| product_id | bigint       | YES  | MUL | NULL    |       |
+------------+--------------+------+-----+---------+-------+
  
Example Product Entity:
------------------------
Json Data Format:

{
  "id": "1",
  "name": "Product A",
  "description": "Description of Product A",
  "price": 29.99,
  "categories": ["Category1", "Category2"],
  "attributes": [{"key": "size", "value": "Small"}, {"key": "color", "value": "Red"}],
  "availability": {"inStock": true, "quantity": 100},
  "ratings": [{"userId": "user1", "rating": 4, "comment": "Good product"}]
}
  
Relational Tables
-----------------
1. Product Table
This table represents the main Product entity.
Each row corresponds to a single product.

2.Category Table:
This table stores the categories associated with each product using a many-to-many relationship.

3.Attribute Table:
This table represents the attributes of each product using key-value pairs.

4.Rating Table:
This table stores the ratings associated with each product.


					Entity Relationship Diagram
			------------------------------------------
					
  +------------+           +-------------+           +---------+
  |  Product   |    1      | Availability|     1     |  Rating |
  +------------+-----------+-------------+-----------+---------+
  | id         |           | inStock     |           | userId  |
  | name       |           | quantity    |           | rating  |
  | description|           +-------------+           | comment |
  | price      |                                     +---------+
  | categories |
  | attributes |
  +------------+
       1
       |
       *
  +---------+
  | Rating  |
  +---------+
  | userId  |
  | rating  |
  | comment |
  +---------+


  
Base URL - http://localhost:9090/

Product Entity
------------------
The product entity has the following attributes:

id: Long (unique identifier for the product)
name: String (name of the product)
description: String (description of the product)
price: Double (price of the product)

categories: Array of Strings (categories the product belongs to)

attributes: Array of Objects (additional attributes such as size, color, brand, etc.)

availability: Object with the following attributes:
---------------------------------------------------

inStock: Boolean (indicates if the product is in stock)
quantity: Integer (available quantity)

ratings: Array of Objects with the following attributes:
--------------------------------------------------------

userId: String (unique identifier for the user who gave the rating)
rating: Integer (numerical rating value)
comment: String (optional text comment on the rating)


API End points:
-----------------
GET:
1:getAll=To get all products
2:{id}=Retrieve product by id

POST:
1:create=For creating new product

DELETE:
1:delete/{id}=for deleting specific product

PUT:
1:update/{id}=for updating a product


