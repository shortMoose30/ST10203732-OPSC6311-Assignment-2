package com.example.olemsaprojectsroomdb

import Expense
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.olemsaprojectsroomdb.ViewModel.ExpenseViewModel
import com.example.olemsaprojectsroomdb.navigation.NavRoutes


@Composable
fun ExpenseScreen(navController: NavController) {
    var date by remember { mutableStateOf("") }
    var startTime by remember { mutableStateOf("") }
    var endTime by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var categoryId by remember { mutableStateOf(0) }
    val expenseViewModel: ExpenseViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // added padding
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text("Expense Screen", color = Color.Gray)

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { navController.navigate(NavRoutes.HOME) }) {
            Text("Back to Home")
        }
        Button(onClick = { navController.navigate(NavRoutes.EXPENSE) }) {
            Text("Go to Expenses")
        }
        Button(onClick = { navController.navigate(NavRoutes.GOAL) }) {
            Text("Go to Goals")
        }
        Button(onClick = { navController.navigate(NavRoutes.CATEGORY) }) {
            Text("Go to Category")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 💡 Expense Entry Form
        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Date (e.g. 2024-05-01)") }
        )

        OutlinedTextField(
            value = startTime,
            onValueChange = { startTime = it },
            label = { Text("Start Time (e.g. 09:00)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = endTime,
            onValueChange = { endTime = it },
            label = { Text("End Time (e.g. 10:30)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") }
        )

        OutlinedTextField(
            value = if (categoryId == 0) "" else categoryId.toString(),
            onValueChange = {
                categoryId = it.toIntOrNull() ?: 0
            },
            label = { Text("Category ID") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )



        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            val newExpense = Expense(
                date = date,
                startTime = startTime,
                endTime = endTime,
                description = description,
                categoryId = categoryId
            )

            
            expenseViewModel.insertExpense(newExpense)
        }) {
            Text("Save Expense")
        }

    }
    }









