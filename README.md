# 🛒 Boltmart Backend – Smart Retail Checkout APIs

> ⚡ Powered by Spring Boot | MongoDB | REST APIs  
> A backend system enabling RFID/NFC-based automated checkout using smart baskets.

![Java](https://img.shields.io/badge/Built%20With-Java%20Spring%20Boot-brightgreen)
![Database](https://img.shields.io/badge/Database-MongoDB-lightgreen)
![Status](https://img.shields.io/badge/Status-Active-blue)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

## 📖 Overview

**Boltmart** redefines retail shopping with its automated checkout system powered by **NFC and RFID-enabled smart baskets**. This backend service acts as the core engine behind:

- Real-time item scanning  
- Cart syncing from smart basket scans  
- Secure checkout and payment flow  
- User and inventory management  

The backend is built with **Spring Boot**, uses **MongoDB** for flexible data handling, and exposes a set of RESTful APIs consumed by the mobile applications built with **Flutter** (Android) and **Swift** (iOS).

---

## 🚀 Key Features

- 🗂️ Inventory Management: Create, read, update, and delete products with associated RFID/NFC tags  
- 📦 Smart Basket Sync: Map scanned basket tags to user carts in real time  
- 🔐 Secure Auth: JWT-based login & role access for users and admins  
- 💳 Checkout API: Instantly process checkout upon smart basket scan  
- 🌐 CORS Support: Works across Flutter and Swift clients  
- 📊 Modular API Architecture: Designed for scalability and clarity  

---

## 🛠️ Tech Stack

| Technology        | Purpose                                           |
|-------------------|--------------------------------------------------|
| **Spring Boot**   | Java-based backend development                   |
| **MongoDB**       | NoSQL database for dynamic product data          |
| **JWT**           | Authentication and security                      |
| **Maven**         | Build and dependency management                  |
| **REST APIs**     | Interface for mobile clients (Flutter/Swift)     |

---

## 📦 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/hari-haran04/Boltmart.git
cd Boltmart

📫 API Endpoints Overview
🔐 Auth
Method	Endpoint	Description
POST	/api/auth/register	User registration
POST	/api/auth/login	User login (returns JWT)

📦 Product
Method	Endpoint	Description
GET	/api/products	Fetch all products
GET	/api/products/{id}	Get product by ID
GET	/api/products/rfid/{tag}	Get product by RFID/NFC
POST	/api/products	Create new product
PUT	/api/products/{id}	Update product info
DELETE	/api/products/{id}	Delete a product

🛒 Cart
Method	Endpoint	Description
POST	/api/cart/sync	Sync basket with user cart
POST	/api/cart/checkout	Trigger checkout process

🧪 Testing Tools
You can test all endpoints using:

Postman

Insomnia

Swagger UI (coming soon)

📌 Use the JWT token returned on login in the Authorization header:

Authorization: Bearer <your_token_here>

🧠 Future Enhancements

🔍 Swagger/OpenAPI integration for live API testing

📊 Admin dashboard analytics for inventory and sales

📡 WebSocket-based real-time cart updates

🧑‍💼 Role-based API access for users and admins

💳 Razorpay/Stripe payment integration

🤝 Contributing

I welcome contributions! Follow these steps:

bash Copy Edit
# 1. Fork the repository
# 2. Create a new branch
git checkout -b feature/your-feature

# 3. Make your changes

# 4. Commit your changes
git commit -m "Add your feature"

# 5. Push to your branch
git push origin feature/your-feature

# 6. Open a Pull Request on GitHub
📄 License
This project is licensed under the MIT License.
See the LICENSE file for details.

🙋 Contact
Built with 💡 by Hari Haran
📧 Email: [your-email@example.com]
🔗 GitHub: @hari-haran04

Boltmart Backend – Powering frictionless retail with smart tech 🚀

Let me know if you’d like:

- 🔧 A `README.md` for the **Flutter** or **Swift** frontend  
- 📄 A `swagger.yaml` file to kickstart API documentation  
- 🪄 A clean **project banner/logo** for branding  

I can help with those too!
