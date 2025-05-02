package com.example.olemsaprojectsroomdb.data

import Expense
import ExpenseDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.olemsaprojectsroomdb.Category
import com.example.olemsaprojectsroomdb.Dao.CategoryDao
import com.example.olemsaprojectsroomdb.Dao.GoalDao
import com.example.olemsaprojectsroomdb.Dao.UserDao
import com.example.olemsaprojectsroomdb.MonthlyGoal

@Database(entities = [User::class, Category::class, Expense::class, MonthlyGoal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun categoryDao(): CategoryDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun goalDao(): GoalDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "olemsa_database"
                ).build()
                INSTANCE = instance
                instance



            }
        }
    }
}

