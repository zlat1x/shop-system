# 🛒 Shop Management System

A full-featured **Spring Boot** project modeling a **purchase management system** for stores using **Hibernate** and **H2 in-memory database**,  
with a **user-friendly web interface** built with **Thymeleaf**.

## 🚀 Tech Stack

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA (Hibernate)**
- **H2 In-Memory Database**
- **Thymeleaf Template Engine**
- **Maven**

---

## 🎨 User Interface Features

- Add Categories, Products, Stores, and Customers
- Assign Products to Categories and Stores
- Register Purchases by entering Customer and Product names
- Interactive Lists:
    - Products in Category
    - Stores selling a Product
    - Purchases by Customer
- View All Categories, Products, and Purchases with sorting options

---

## 🛠️ REST API Endpoints

| Action                                   | Method | Endpoint                                         |
|------------------------------------------|--------|--------------------------------------------------|
| Add a new category                       | POST   | `/categories/add`                                |
| Add a new product                        | POST   | `/products/add`                                  |
| Add a new store                          | POST   | `/stores/add`                                    |
| Assign product to store                  | POST   | `/stores/add-product`                            |
| Assign product to category               | POST   | `/products/assign-category`                      |
| Register a purchase                      | POST   | `/purchases/buy`                                 |
| Get all products by category             | GET    | `/products/category/{categoryId}`                |
| Get all stores selling a product         | GET    | `/stores/by-product/{productId}`                 |
| Get all purchases of a customer          | GET    | `/purchases/by-customer/{customerId}`            |
| Get all purchases sorted by date         | GET    | `/purchases/sorted-by-date?order=asc|desc`       |
| Get all categories                       | GET    | `/categories`                                   |

---

## 🧪 H2 Database Access

- URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: *(leave empty)*

---

## 💻 How to Run

1. Clone the repository
2. Open the project in **IntelliJ IDEA**
3. Make sure **JDK 21** is selected
4. Run `ShopApplication.java`
5. Open `http://localhost:8080` in your browser
6. Access the H2 Console at `http://localhost:8080/h2-console` if needed

---

## ✅ Features Implemented

- Add products, categories, stores, and customers via web forms
- Link products to stores and categories
- Register purchases by entering customer and product names
- View interactive product, store, and purchase lists
- Sort purchases by date (ascending or descending)
- Styled user-friendly pages built with Thymeleaf
- In-memory data persistence with H2 Database

---

## 💎 Author

**Zlata Dovbyk**  
Made with ☕, 💻 and 💖
