# Hospital Management System

A simple Hospital Management System built using **Java** and **MySQL**.

## Features
- Add, view, and manage patients
- Add and view doctors
- Book appointments between patients and doctors

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/Hospital-Management-System.git
   
Technologies Used
Java
MySQL
JDBC

2. Database structure

CREATE DATABASE hospital;
USE hospital;

CREATE TABLE patient (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100),
age INT,
gender VARCHAR(10)
);

CREATE TABLE doctor (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100),
specialization VARCHAR(100)
);

CREATE TABLE appointment (
id INT PRIMARY KEY AUTO_INCREMENT,
patient_id INT,
doctor_id INT,
date DATE,
FOREIGN KEY (patient_id) REFERENCES patient(id),
FOREIGN KEY (doctor_id) REFERENCES doctor(id)
);
