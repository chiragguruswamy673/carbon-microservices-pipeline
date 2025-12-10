# 🌍 Carbon Microservices Pipeline

[![CI](https://github.com/chiragguruswamy673/carbon-microservices-pipeline/actions/workflows/ci.yml/badge.svg)](https://github.com/your-username/carbon-microservices-pipeline/actions/workflows/ci.yml)

## 📖 Overview
The **Carbon Microservices Pipeline** is a showcase project that demonstrates how QA engineers can design, test, and deploy microservices with CI/CD pipelines.  
It measures sustainability metrics of websites (page size, load time, estimated CO₂ emissions) and presents them in a frontend dashboard.

---

## ✨ Features
- **Microservices architecture** → Separate API (`carbon-api`) and Web (`carbon-web`) services.
- **Sustainability metrics** → Backend calculates page size, load time, and CO₂ emissions.
- **Frontend dashboard** → Displays results in a recruiter‑friendly UI.
- **CI/CD pipeline** → Automated builds and tests with GitHub Actions.
- **Containerization** → Docker images for both services.
- **Orchestration** → Kubernetes deployments + NodePort services.
- **Automation ready** → Selenium/TestNG tests validate frontend against live API.

---

## 🛠 Tech Stack
- **Java + Spring Boot** → Backend API
- **HTML/JS frontend** → Web dashboard
- **Selenium + TestNG** → Automation tests
- **Docker & Kubernetes** → Containerization & orchestration
- **GitHub Actions** → CI/CD workflows

---
## 🌐 Accessing Services
- API → http://localhost:32124/api/metrics
- Frontend → http://localhost:32123

## 📌 CI/CD

GitHub Actions workflow (ci.yml) runs:
- Build & test backend
- Build & test frontend
- Run Selenium automation
- Build Docker images
- Push artifacts

## 🧪 Testing

Run Selenium/TestNG tests
and check for errors

## 🌱 Sustainability Context

This project demonstrates how QA engineers can integrate environmental impact validation into CI/CD pipelines, making sustainability a first‑class metric alongside performance and accessibility.

### Author: Chirag Guruswamy