package com.example.olemsaprojectsroomdb.ViewModel

import Expense
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.olemsaprojectsroomdb.Repository.ExpenseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ExpenseViewModel(private val repository: ExpenseRepository) : ViewModel() {

    private val _expenses = MutableStateFlow<List<Expense>>(emptyList())
    val expenses: StateFlow<List<Expense>> get() = _expenses

    fun loadExpenses() {
        viewModelScope.launch {
            _expenses.value = repository.getAllExpenses()
        }
    }

    fun addExpense(expense: Expense) {
        viewModelScope.launch {
            repository.insert(expense)
            loadExpenses()
        }
    }
}