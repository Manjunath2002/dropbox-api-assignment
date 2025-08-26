# Dropbox API Assignment

This repository contains the **CloudEagle Product Management Internship Assignment** implementation using the **Dropbox (Business) API**.

---

## 📌 Project Overview
The goal of this assignment is to:
- Document important Dropbox (Business) APIs.
- Configure **OAuth2 authentication** with Dropbox.
- Test APIs in **Postman** (screenshots included in the assignment document).
- Implement a **Java program** that authenticates with Dropbox and fetches team user data.
- Package everything into a GitHub repository.

---

## 📂 Repository Contents
- `pom.xml` → Maven dependencies (`OkHttp`, `Jackson`, `exec-maven-plugin`)
- `src/main/java/com/example/dropbox/Main.java` → Java program that calls Dropbox API
- `Dropbox_API_Assignment.docx` → Completed assignment template with API details

---

## ⚙️ Prerequisites
- Java 11 or later
- Maven 3.6+
- A Dropbox (Business) account
- A Dropbox App created in [Dropbox App Console](https://www.dropbox.com/developers/apps)

---

## 🔑 Authentication Setup
1. Go to [Dropbox App Console](https://www.dropbox.com/developers/apps).
2. Create a new app (**Scoped Access**, **Full Dropbox** or **Team Data**).
3. Enable these scopes:
   - `team_info.read`
   - `account_info.read`
   - `team_data.member`
   - `team_data.audit`
4. Generate an **access token** (short-lived).
5. Copy the token into `Main.java`:
   ```java
   private static final String ACCESS_TOKEN = "sl.BC...your_token_here";
