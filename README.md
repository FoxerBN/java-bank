Here's a clean, simple, and brief `README.md` you can use for your GitHub project:

---

````markdown
# 🏦 Simple Java Banking App (Swing + H2)

A minimal console+GUI banking application built in Java using Swing and an embedded H2 database.

## ✨ Features

- User login with PIN authentication
- Deposit and withdraw money
- View all users and their balances
- Auto-initializes a local H2 database with sample users

## 🛠️ Tech Stack

- Java (JDK 8+)
- Swing (GUI)
- H2 Database (embedded)
- JDBC

## 🚀 Getting Started

1. **Clone the repo:**
   ```bash
   git clone https://github.com/your-username/java-banking-app.git
   cd java-banking-app
````

2. **Compile & Run:**

   ```bash
   javac App.java
   java App
   ```

3. **Login PINs (preloaded):**

   ```
   John Doe     -> 0000
   Jane Smith   -> 0001
   Bob Johnson  -> 0002
   ```

## 📁 Project Structure

```
├── App.java
├── config/
│   └── DatabaseConfig.java
├── controllers/
├── models/
├── services/
```

## 📌 Notes

* All data is stored locally in `./database/bankdb.mv.db`
* GUI uses `JOptionPane` for interaction
* No external dependencies required
