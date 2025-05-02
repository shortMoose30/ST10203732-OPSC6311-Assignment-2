package com.example.olemsaprojectsroomdb.Screens

import Expense
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.olemsaprojectsroomdb.ViewModel.ExpenseViewModel
import com.example.olemsaprojectsroomdb.navigation.NavRoutes


@Composable
fun ExpenseListScreen(navController: NavController, viewModel: ExpenseViewModel) {
    val expenses by viewModel.expenses.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.loadExpenses()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("All Expenses", color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        // Display the list of expenses
        LazyColumn {
            items(expenses) { expense ->
                ExpenseItem(expense)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Back Button
        Button(onClick = { navController.navigate(NavRoutes.HOME) }) {
            Text("Back to Home")
        }
    }
}

@Composable
fun ExpenseItem(expense: Expense) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text("Date: ${expense.date}")
        Text("Start Time: ${expense.startTime}")
        Text("End Time: ${expense.endTime}")
        Text("Description: ${expense.description}")
        Text("Category ID: ${expense.categoryId}")
        Spacer(modifier = Modifier.height(8.dp))
        Divider(color = Color.Gray)
    }
}
