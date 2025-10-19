# 🚀 LinkForge

LinkForge is a minimalist URL shortening engine with smart redirection and live tracking. Designed for developers and product teams who value clean APIs, speed, and extensibility.

---

## 🔍 Overview

Take long URLs and compress them into shareable, trackable links with a single API call. Built with Spring Boot for rapid deployment and easy maintenance.

---

## 📦 Features

- Generate custom short links
- Redirect seamlessly to original URLs
- Monitor usage with access counters
- Lightweight, zero-dependency storage options (e.g., H2, MySQL)
- Plug-and-play architecture

---

## ⚙️ Architecture Overview

```
📦 com.projectx.urlshortener
 ┣ 📂controller         → REST API interfaces
 ┣ 📂entity             → JPA-mapped domain objects
 ┣ 📂repository         → Data access with Spring Data JPA
 ┣ 📂advice             → Exception management
 ┗ 📂dto                → Transfer models for requests/responses
```

---

## 🧪 API Cheat Sheet

### 1. Create Short URL
```
POST /shorten
```
**Body:**
```json
{
  "sourceAddress": "https://example.com/very/long/path"
}
```
**Returns:** `compressedLink` with short redirect URL

---

### 2. Redirect to Original
```
GET /r/{shortCode}
```
Automatically redirects users to the full URL.

---

### 3. Check Analytics
```
GET /analytics/{shortCode}
```
Returns number of times the short link has been accessed.

---

## 🔧 Setup Instructions

1. Clone the repo
2. Run with Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Or build and run:
   ```bash
   mvn package
   java -jar target/*.jar
   ```

---

## 🎯 Use Cases

- Social media link compression
- Campaign tracking for marketing
- Email-safe URLs
- Lightweight URL monitor

---

## 🛠️ Tech Specs

- Java 17+
- Spring Boot
- H2 (default) / MySQL / PostgreSQL support
- Maven build tool

---
