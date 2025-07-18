# 💳 Bank Management System
A simple yet powerful Java-based **Bank Management Software** with a user-friendly **Swing GUI** and **MongoDB Atlas** integration. It allows users to **create accounts**, **deposit**, **withdraw**, and **view accounts** — all backed by a NoSQL cloud database.

![Java Swing + MongoDB](https://img.shields.io/badge/Java-Swing-green?style=flat-square)
![MongoDB](https://img.shields.io/badge/MongoDB-Atlas-green?style=flat-square)
![License](https://img.shields.io/badge/license-MIT-blue.svg?style=flat-square)

## 🚀 Features 
- 📋 Create new bank accounts with:
 - Name, DOB (with date picker), Address, State, PIN, Phone, Marital Status
- 💰 Deposit & Withdraw funds
- 🧾 View all accounts with scrollable UI
- ☁️ Data is persisted securely in MongoDB Atlas - 🧠 Organized, modular, object-oriented Java code

## 📸 Screenshots >
![image](https://github.com/user-attachments/assets/2f348d5c-6d74-4a7b-b40d-090b82e9f6f9)
## Create Account
![image](https://github.com/user-attachments/assets/628aaab6-c18f-4602-82c6-16ee282cb331)
## Account Created
![image](https://github.com/user-attachments/assets/e2072306-62b1-48f3-9a05-e5eb9f26f52b)
## Deposit
![image](https://github.com/user-attachments/assets/77be2fb1-6c33-45ea-a1bd-19e514fee7c1)
![image](https://github.com/user-attachments/assets/f1436522-7503-413d-8448-98d22a5fb263)




## 🛠️ Tech Stack 
| Layer            | Technology            |
|------------------|------------------------|
| GUI              | Java Swing             |
| Backend Logic    | Java (OOP principles)  |
| Database         | MongoDB Atlas (NoSQL)  |
| Build Tool       | Maven                  |
| IDE              | VS Code / IntelliJ     |

## 📂 Project Structure` 

Bank-Management-System/  
│  
├── src/  
│ └── main/  
│ └── java/  
│ ├── main/  
│ │ ├── BankApp.java # Entry point  
│ │ ├── GUI.java # Swing GUI logic  
│ │ ├── Bank.java # Account operations  
│ │ ├── Account.java # Model class  
│ │ └── MongoUtil.java # MongoDB integration  
│  
├── pom.xml # Maven dependencies  
└── README.md

 ## 🧪 Setup Instructions 
 ### ✅ Prerequisites 
 - Java 17+
 - Maven
 - MongoDB Atlas account (free tier works!)
### 🔧 Clone & Build ```bash git clone https://github.com/yourusername/Bank-Management-System.git cd Bank-Management-System mvn compile` 

### ▶️ Run the App

`mvn exec:java -Dexec.mainClass="main.BankApp"` 

* * *

☁️ MongoDB Configuration
------------------------

1.  Go to [MongoDB Atlas](https://www.mongodb.com/cloud/atlas)
    
2.  Create a **Database User** with read/write access
    
3.  Whitelist your IP in Network Access
    
4.  Replace the URI in `MongoUtil.java`:
    

`private static final String URI = "mongodb+srv://<username>:<password>@cluster0.mongodb.net/BankDB?retryWrites=true&w=majority";` 

* * *

✨ Future Improvements
---------------------

*   🧾 Transaction history
    
*   🔐 Authentication/login system
    
*   📊 GUI charts for account summaries
    
*   🌐 Deploy as a desktop app using JAR or JavaFX
    

* * *

👨‍💻 Author
------------

**Sujoy Paul**  
_B.Tech CSE_  
[LinkedIn](https://www.linkedin.com/) | [GitHub](https://github.com/yourusername)

* * *

📄 License
----------

This project is licensed under the MIT License.

* * *

> ⭐ _Feel free to star the repo and share your suggestions or issues!_

yaml

 ``--- ### 📌 Tips: - Replace `"yourusername"` with your actual GitHub username. - You can include **GIFs or screenshots** under `📸 Screenshots` for better visual appeal. - Add a `LICENSE` file to match the MIT License badge. Let me know if you want a Hindi version or a more advanced dev/prod deployment guide!`` 

![Export to Google Doc](chrome-extension://iapioliapockkkikccgbiaalfhoieano/assets/create.svg)![Copy with formatting](chrome-extension://iapioliapockkkikccgbiaalfhoieano/assets/copy.svg)![Select for Multi-select](chrome-extension://iapioliapockkkikccgbiaalfhoieano/assets/multi-select.svg)
