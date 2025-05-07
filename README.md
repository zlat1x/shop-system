# 🛍️ Shop Management System

A simple Spring Boot project that models a purchase management system for stores using Hibernate and an in-memory H2 database.

## 🚀 Tech Stack

- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA (Hibernate)**
- **H2 Database**
- **Maven**

---

## 📁 Project Structure


---

## 🔗 REST API Endpoints

| Action                                   | Method | Endpoint                                         |
|------------------------------------------|--------|--------------------------------------------------|
| Add a new category                       | POST   | `/categories/add`                                |
| Add a new product                        | POST   | `/products/add`                                  |
| Add a new store                          | POST   | `/stores/add`                                    |
| Assign product to store                  | POST   | `/stores/{storeId}/addProduct/{productId}`       |
| Register a purchase                      | POST   | `/purchases/buy`                                 |
| Get all products by category             | GET    | `/products/category/{categoryId}`                |
| Get all stores that sell a product       | GET    | `/stores/by-product/{productId}`                 |
| Get all purchases of a specific customer | GET    | `/purchases/by-customer/{customerId}`            |

---

## 🧪 H2 Database Access

- Navigate to: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: *(leave empty)*

---

## 📦 How to Run

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Run the `ShopApplication.java` file
4. Test endpoints using Postman, curl, or browser

---

## 🧠 Features Implemented

- Add products with categories
- Register product purchases by customers
- Query products, stores, and purchases via REST API
- Auto-generated tables via JPA and in-memory H2

---

## 💎 Author

**Zlata Dovbyk**  
Made with ☕, 💻 and 💖
