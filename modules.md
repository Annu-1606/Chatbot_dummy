# Modules & Code Structure
**Project:** Cloud-based Chat Bot   
**Version:** 0.1 (Draft)  
**Date:** 2025-08-31  

---

## 1. Overview
The chatbot system will support **basic person-to-person messaging**:  
- Users are registered and available immediately.  
- A user can send a message to another user.  
- The receiver can view messages instantly (on refreshing their inbox).  
- UI remains minimal — plain form and message list.  

We will divide the system into four main modules:  

1. **User Module** – manages users (create, list, lookup).  
2. **Message Module** – handles message sending and retrieval.  
3. **Chat Controller** – exposes REST APIs for frontend interaction.  
4. **Frontend (Thymeleaf UI)** – simple web interface for chat.  

---

## 2. Module Breakdown

### 2.1 User Module
**Purpose:** Manage user details (ID, username).  

**Components:**  
- `User` entity – represents a single user.  
- `UserService` – business logic for creating and retrieving users.  

**Functions:**  
```java
public User createUser(String username);
public User getUser(Long id);
public List<User> getAllUsers();
