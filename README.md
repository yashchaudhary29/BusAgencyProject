# 🚌 Bus Agency Management System

Java + JDBC + MySQL se bana hua Console Based Project.
Isme User Bus Book kar sakta hai, Cancel kar sakta hai aur Admin Bus ko Add / Remove kar sakta hai.

## 🚀 Features

- Add New User
- View All Users
- Add New Bus
- Search Bus by Bus ID
- Remove Bus
- Book Ticket
- View All Bookings
- Cancel Ticket

## 🛠️ Tech Stack

- Language: Java
- Database: MySQL
- Connectivity: JDBC
- IDE: VS Code

## 📁 Project Structure

BusAgencyProject/

├── dao/

│   ├── DBConnection.java

│   ├── BusDao.java

│   ├── UserDao.java

│   └── BookingDao.java

├── model/

│   ├── Bus.java

│   ├── User.java

│   └── Booking.java

├── lib/

│   └── mysql-connector-j-26.10.0.jar

├── Main.java

└── README.md

## 🗄️ Database Setup

MySQL me pehle ye chala lo:

```sql
CREATE DATABASE busagency;
USE busagency;

CREATE TABLE buses (
    bus_id INT PRIMARY KEY AUTO_INCREMENT,
    bus_name VARCHAR(100)
);

CREATE TABLE bookings (
    booking_id INT PRIMARY KEY AUTO_INCREMENT,
    bus_id INT
);
