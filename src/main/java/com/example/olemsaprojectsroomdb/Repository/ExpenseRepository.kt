package com.example.olemsaprojectsroomdb.Repository

import Expense
import ExpenseDao


class ExpenseRepository(private val expenseDao: ExpenseDao) {
    suspend fun insert(expense: Expense) = expenseDao.insertExpense(expense)
    suspend fun getAllExpenses() = expenseDao.getAllExpenses()

}

