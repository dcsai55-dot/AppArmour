# 🛡️ AppArmour – Real-Time Malware & Fake App Detection System

AppArmour is a prototype Android security application designed to protect users from malicious and fake apps, especially those distributed via SMS, WhatsApp links, and third-party APK downloads.

It works as a lightweight background security layer that analyzes installed applications based on permissions, behavior patterns, and risk factors, and alerts users in real time.

---

## 🚀 Features

- 🔍 APK & Installed App Scanning  
- 🧠 Rule-Based Risk Detection Engine  
- 🚨 Real-Time Risk Alerts (Safe / Suspicious / Dangerous)  
- 🧹 One-Click Uninstall Option for Risky Apps  
- 📩 SMS Alert System (Prototype Demo)  
- ⚡ Lightweight & Fast Performance  

---

## 🏗️ System Architecture

User Action → Detection Layer → APK/Link Scanner → Risk Engine → Decision Module → Alert System → Reporting (Future Scope)

---

## 🔄 Working Flow

1. User installs or opens an APK/link  
2. AppArmour detects the activity  
3. Scanner analyzes permissions & app metadata  
4. Risk Engine calculates risk score  
5. User receives alert notification  
6. Option to uninstall or ignore  

---

## ⚙️ Tech Stack

- 📱 Android (Java)  
- ⚙️ PackageManager API  
- 🔐 Accessibility Service  
- 📩 SMS Manager (Demo Purpose)  
- ☁️ Firebase (Optional for future integration)  

---

## 🧠 Methodology

- Permission-based risk analysis  
- Pattern detection (e.g., fake banking app names)  
- Rule-based scoring system  
- Real-time alert mechanism  

---

## 📂 Project Structure
