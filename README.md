# 📌 Software Test Automation Framework

## 🧪 Overview

This project is a **Selenium 4 + TestNG automation framework** built in **Java 11**, following the **Page Object Model (POM)** design pattern.

Targeting the demo e-commerce application:

👉 [https://demo.nopcommerce.com](https://demo.nopcommerce.com)

The framework is designed to be:

* Scalable
* Maintainable
* Easy to extend
* Built using industry best practices

---

## 🛠️ Tech Stack

* Java 11+
* Selenium 4
* TestNG
* Maven
* WebDriverManager
* Page Object Model (POM)
* Git

---

## 📁 Project Structure

```
src
 ├── main
 │   ├── java
 │   │   ├── pages          → Page Object classes (POM)
 │   │   ├── utils          → Utility classes (Config, Waits, Screenshots)
 │   │   ├── base           → Base classes (Driver setup, BasePage)
 │   │   └── listeners      → TestNG listeners (Screenshot on failure)
 │
 └── test
     ├── java
     │   └── tests         → Test classes (Registration, Login, Cart)
     └── resources
         └── testng.xml    → Test suite configuration
```

---

## ⚙️ Key Framework Features

### 🏗️ Page Object Model (POM)

Each web page is represented as a separate class containing:

* Locators
* Page actions
* Reusable methods

---

### 🔗 Independent Tests

All test cases are fully independent and do not rely on execution order or shared state.

---

### ⚙️ Externalized Test Data

* URL and configuration stored in `config.properties`
* No hardcoded values inside test methods
* Dynamic test data generation (e.g., unique emails)

---

### 📸 Screenshot on Failure

A TestNG Listener automatically captures screenshots on test failure and stores them in:

```
/screenshots
```

File names include timestamps for traceability.

---

### 🚦 Explicit Wait Strategy

* Uses `WebDriverWait` + `ExpectedConditions`
* No usage of `Thread.sleep()`

---

### 🔄 Setup & Teardown

* `@BeforeMethod` → Driver initialization
* `@AfterMethod` → Driver cleanup
* Ensures no orphan browser sessions

---

## 🧪 Test Coverage

### 1️⃣ Registration Tests

* Successful user registration
* Validation for missing required fields

### 2️⃣ Login Tests

* Successful login with valid credentials
* Login failure with invalid credentials

### 3️⃣ Shopping Cart Tests

* Add product to cart
* Update product quantity
* Remove product from cart

---

## ▶️ How to Run the Tests

### Prerequisites

* Java 11+
* Maven installed
* Chrome browser

---

### Run via Maven

```bash
mvn clean test
```

---

### Run via TestNG Suite

Execute:

```
src/test/resources/testng.xml
```

---

## 📊 TestNG Suite Flow

The tests are executed in the following order:

1. Registration Tests
2. Login Tests
3. Cart Tests

---

## 📸 Failure Evidence

On any test failure:

* Screenshot is automatically captured
* Stored in `/screenshots`
* Named with timestamp for debugging

---

## 📌 Best Practices Followed

* No hardcoded test data
* No test inter-dependencies
* Clean and reusable POM structure
* Meaningful assertions with messages
* Explicit waits only
* Proper driver lifecycle management

---

## 🚀 How to Clone & Use

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
mvn clean test
```

---

## 📤 Submission Notes

This framework was built to demonstrate:

* Real-world automation structure
* Scalability mindset
* Clean code principles
* Test reliability and maintainability

