ReadMe file

#  Budget Tracker App

This is a fully offline **Budget Tracking App** built with **Kotlin**, **Jetpack Compose**, and **RoomDB** using **Android Studio Meerkat**. The app helps users record daily expenses, categorize them, and optionally track monthly spending goals.

---

##  Features

###  Core Functionalities (Completed)
- **User Login & Registration**
- **Expense Creation**
  - Date, Start/End Time, Description, Category, Amount
- **Category Management**
  - Add/View/Delete Categories per User
- **List of All Expenses**
  - Displayed with timestamp and category
- **Green & Grey Theme**
  - Custom Jetpack Compose UI theme

###  Planned / Optional Features
-  **Attach Photo** to Expenses
-  **Set Monthly Spending Goals**
-  **Filter Expenses** by Date or Category
-  **Dashboard Summaries** of spending

---

##  Database Schema (RoomDB)

This project uses **Room Database** with the following tables:

### 1. `User`
Stores login credentials for each app user.
```kotlin
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
    val password: String
)
The application: 
Tracks expense categories created by users.
Allows users to set monthly spending limits.

