# Architecture Document
**Project:** Cloud-based Chat Bot   
**Version:** 0.1 (Draft)  
**Date:** 2025-08-31  

---

## 1. Technologies
- **Backend:** Spring Boot (Java 17)  
- **Frontend:** Thymeleaf + HTML/CSS/JavaScript  
- **Database (optional):** H2 (in-memory) for chat history  
- **Containerization:** Docker (openjdk:17-jdk-slim base image)  
- **Hosting:** Cloud VM (AWS/GCP/Azure free tier)  
- **Security:** HTTPS (Let’s Encrypt or self-signed certificate)  

---

## 2. High-Level Architecture
flowchart TD
    A[User Browser] <--> B[Spring Boot App]
    B <--> C[(H2 DB - optional)]
    B --> D[Docker Container]
    D --> E[Cloud VM]

sequenceDiagram
    participant U as User (Browser)
    participant B as Spring Boot App
    participant DB as Database (Optional)
    U->>B: Send message
    B->>B: Process message (rule-based logic)
    B->>DB: Save chat (optional)
    DB-->>B: Confirm save
    B-->>U: Return reply
