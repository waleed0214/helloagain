# Edit Customer Name - Appium Automation

## Overview
This project automates the process of editing a customer's first name in the **Hello Again Member Club** Android app using **Appium** with Java. It simulates a real user flow — navigating to the profile, editing the name, and saving the changes with proper scrolling and verification.

## Features
- Launches the Android app using Appium.
- Navigates through UI elements (dashboard, profile menu).
- Edits and updates the customer’s first name.
- Handles UI scrolling (both down to Save and up for verification).
- Verifies if the new name has been saved successfully.

## Tech Stack
- **Java**
- **Appium (Java client)**
- **UiAutomator2**
- **Selenium WebDriver**
- Android 14 (tested on device: `RZCW60CJQQM`)

## How to Run
1. Make sure Appium server is running.
2. Connect your Android device via USB.
3. Enable Developer Options & USB Debugging.
4. Install required dependencies (Appium Java client, Selenium).
5. Run the `Editname.java` class from your IDE or command line.

---

## ⚠️ Notes
- The app must be installed on the device before running the test.
- Ensure the user is logged in and on the correct screen context (noReset: true).
- UI elements may vary by screen size or app version — adjust selectors if needed.
