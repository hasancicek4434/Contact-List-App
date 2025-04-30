# Contact List Test Automation Framework

This project is an automated testing framework built with **Java**, **Selenium WebDriver**, **TestNG**, and **Maven** for the website:  
[https://thinking-tester-contact-list.herokuapp.com/](https://thinking-tester-contact-list.herokuapp.com/)

## 🚀 Technologies Used

- Java 17  
- Selenium 4  
- TestNG  
- Maven  
- WebDriverManager  
- IntelliJ IDEA

## 📁 Project Structure

src └── test └── java └── tests ├── PositiveFlowTest.java ├── InvalidLoginTest.java ├── InvalidSignUpTest.java └── InvalidAddContactTest.java └── pages ├── LoginPage.java ├── SignUpPage.java ├── ContactPage.java └── AddContactPage.java └── base └── BaseTest.java testng.xml README.md pom.xml


## ✅ Test Scenarios

### Positive:
- User registration (Sign up)
- Logout and login
- Add a new contact

### Negative:
- Invalid login attempts
- Invalid or empty signup form
- Adding a contact with empty fields

## ⚙️ How to Run the Project

### 1. Install dependencies
```bash
mvn clean install

## Run all tests via TestNG XML
mvn test -DsuiteXmlFile=testng.xml

## Run from IntelliJ
Right-click testng.xml and select Run.


