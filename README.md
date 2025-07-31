# 🔐 Smart Password Assistant for Android  
### Final Degree Project – Universidad Politécnica de Madrid

> **Author**: Ángel Briones Muñoz  
> **Degree**: Grado en Ingeniería Informática  
> **University**: Universidad Politécnica de Madrid (UPM)  
> **Supervisor**: [Tutor Name]  
> **Date**: July 2025  

---

## 📱 Project Summary

This Android application is part of a Final Degree Project focused on **improving password recommendation and auto-generation systems** in mobile environments.

It addresses the common challenge of weak or reused passwords in mobile apps by integrating:
- Real-time password strength feedback
- Secure password generation
- Autofill integration with Android's system manager

The project seeks to **enhance both usability and security**, following best practices in mobile UX and cybersecurity.

---

## 🎯 Objectives

- ✅ Provide a native Android interface for secure user registration
- ✅ Recommend strong, memorable passwords without external libraries
- ✅ Generate strong passwords with a single tap
- ✅ Show password strength dynamically as users type
- ✅ Leverage Android's Autofill Framework for enhanced UX
- ✅ Improve awareness of good password practices

---

## 🧩 Features Overview

| Feature                           | Description                                                                 |
|----------------------------------|-----------------------------------------------------------------------------|
| 🔐 Autofill with `AutofillManager` | Requests password suggestions from Android system autofill services         |
| ⚙️ Password generator              | One-click generation of secure 12-character passwords                       |
| 🧠 Strength indicator              | Real-time feedback on password strength (Weak, Medium, Strong)              |
| 👁️ Visibility toggle              | Show/hide password input for better accessibility                           |
| 📋 Copy to clipboard              | Users can copy generated passwords with one tap                             |
| 📱 Responsive Android UI         | Built with native components for compatibility and simplicity               |


---

## 🧠 Password Policy

Passwords are considered **strong** when they include:

- ✅ Minimum 12 characters
- ✅ At least 1 lowercase letter
- ✅ At least 1 uppercase letter
- ✅ At least 1 digit
- ✅ At least 1 special character

The app provides **real-time validation** and ensures that generated passwords follow this policy.

---

## ⚙️ Technologies Used

- **Kotlin** – For modern, concise Android development
- **Android SDK (API 26+)** – Supports Autofill Framework and system integrations
- **XML Layout** – Clean and accessible interface
- **Clipboard API** – For copying passwords securely
- **TextWatcher** – For live input analysis

---

## 🧪 Tested & Verified

✔️ Compatible with Android 8.0 (API 26) and up  
✔️ Works with Google Autofill and other system managers  
✔️ No third-party dependencies  
✔️ Passes usability and accessibility checks  
✔️ Reviewed in context of TFG academic evaluation

---

## 🔒 Security Notes

This app is **client-side only** and does not connect to any server or store data persistently.  
It's intended as a demonstrative educational tool for password guidance and usability.

---

## 📚 References

- [Android Autofill Framework](https://developer.android.com/guide/topics/text/autofill)
- OWASP Mobile Security Guidelines
- NIST SP 800-63B – Password Recommendations
- UX Research on Mobile Security (NNGroup, Google Security Team)

---

## 📜 License & Academic Context

This project was developed as part of a Final Degree Project (TFG) at the **Universidad Politécnica de Madrid**.

It is intended for academic use. If you reuse or reference this project, please cite:

> *Ángel Briones Muñoz, Universidad Politécnica de Madrid (2025)*

---




