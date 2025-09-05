# Multi-Tenant E-Commerce Platform

A microservices-based, multi-tenant e-commerce platform where creators have their own storefronts, sell digital products, and get paid via **Stripe Connect**. Built with **Spring Boot (Java 17)** microservices + **React/Redux** frontend, orchestrated via **Docker Compose**. Features **JWT auth + RBAC**, **subdomain tenant resolution**, **product ratings & reviews**, **personal library**, **file delivery**, **automatic platform fees**, and **admin/merchant dashboards**. Includes **Swagger UI**, **Actuator**, and a **Gateway** that serves the frontend and proxies all APIs under a single entrypoint: **http://localhost:8080**.

---

## 🚀 Features
- Multi-tenant architecture & vendor subdomains
- Custom merchant storefronts
- Stripe Connect (Checkout Sessions, webhooks, `application_fee_amount`, connected accounts)
- Automatic platform fees
- Product ratings & reviews
- User purchase library + secure file delivery
- JWT-based auth & RBAC
- Admin & Merchant dashboards
- Categories, search, image upload
- Swagger UI & Spring Boot Actuator
- Gateway with centralized Swagger aggregation
- Seed data for H2
- Postman Collection + Environment

---

## 🔑 Demo Accounts
| Role | Email | Password | Tenant | Notes |
|---|---|---|---|---|
| Admin | admin@platform.com | admin123 | platform | Admin dashboard |
| Merchant | merchant1@example.com | password123 | merchant1 | Merchant dashboard |
| Customer | customer1@example.com | password123 | merchant1 | Library, checkout |

---

## 📸 Screenshots & Diagrams
- Login: `docs/images/login.png`
- Customer Dashboard: `docs/images/customer-dashboard.png`
- Merchant Dashboard: `docs/images/merchant-dashboard.png`
- Admin Dashboard: `docs/images/admin-dashboard.png`
- App Flow: `docs/images/app-flow.png`
- Storyboards (Customer/Merchant/Admin): `docs/images/storyboard-customer.png`, `docs/images/storyboard-merchant.png`, `docs/images/storyboard-admin.png`
- Swagger UI: `docs/images/swagger-ui.png`
- Actuator: `docs/images/actuator-health.png`, `docs/images/actuator-metrics.png`
- **Database ERD**: `docs/images/database-erd.png`

> Placeholders are included; replace them with real screenshots as desired.

---

## 🏗️ Architecture
- Frontend: React + Redux (Vite)
- Services (Java 17, Spring Boot, H2):
    - `auth-service`: Auth + JWT
    - `product-service`: Products, Categories, Reviews
    - `payments-service`: Stripe Connect + webhooks
    - `file-service`: File/Image upload & delivery
- `gateway-service`: Spring Cloud Gateway + centralized Swagger
- Docker Compose for local orchestration

---

## 🌐 Single Entrypoint
- UI + APIs + Swagger via **http://localhost:8080**
- Swagger UI (central): **/swagger-ui.html**
- Actuator (gateway): **/actuator/health**

---

## 🔧 Quick Start

1) Copy `.env.example` to `.env` and fill secrets locally.

2) Use IntelliJ to import each Maven module, or run with Docker Compose after adding real implementations.

3) Open the app: http://localhost:8080

---

## 🔌 API Map (via Gateway)

| Service | Base Path | OpenAPI | Health |
|---|---|---|---|
| Auth | /auth/** | /v3/api-docs/auth | /actuator/health |
| Products | /products/** | /v3/api-docs/products | /actuator/health |
| Payments | /payments/** | /v3/api-docs/payments | /actuator/health |
| Files | /files/** | /v3/api-docs/files | /actuator/health |

---

## 🧪 Stripe Test Mode
- Success card: `4242 4242 4242 4242`
- CLI: `stripe listen --forward-to localhost:8083/payments/webhook`
- Triggers: `stripe trigger checkout.session.completed`

---

## 🧰 Postman
Import both files from `/postman`:
- `multi-tenant-ecommerce.postman_collection.json`
- `multi-tenant-ecommerce.postman_environment.json`

---

## 🗃️ H2 Seed Data
Each service loads `data.sql` on startup. (In-memory H2; see `application.yml` per service.)

---

## 🛡️ Notes
This starter is for local dev/testing. For production: external DB (Postgres), S3 storage, HTTPS, refresh tokens, stronger CORS, secrets management, and hardened webhook verification.
