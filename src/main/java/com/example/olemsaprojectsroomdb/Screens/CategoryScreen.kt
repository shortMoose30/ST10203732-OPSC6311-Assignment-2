package com.example.olemsaprojectsroomdb.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.olemsaprojectsroomdb.Category
import com.example.olemsaprojectsroomdb.ViewModel.CategoryViewModel
import com.example.olemsaprojectsroomdb.navigation.NavRoutes


@Composable
fun CategoryScreen(navController: NavHostController, viewModel: CategoryViewModel = viewModel()) {
    var categoryName by remember { mutableStateOf("") }
    var editingCategory by remember { mutableStateOf<Category?>(null) }
    val categoriesState = viewModel.categories.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text("Category Screen", color = Color.Gray)

        OutlinedTextField(
            value = categoryName,
            onValueChange = { categoryName = it },
            label = { Text("Category Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (categoryName.isNotBlank()) {
                    editingCategory?.let {
                        viewModel.updateCategory(it.copy(name = categoryName))
                        editingCategory = null
                    } ?: viewModel.addCategory(categoryName)

                    categoryName = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (editingCategory != null) "Update Category" else "Add Category")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Categories:", style = MaterialTheme.typography.titleMedium)

        categoriesState.value.forEach { category ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("- ${category.name}", modifier = Modifier.weight(1f))

                Button(onClick = {
                    editingCategory = category
                    categoryName = category.name
                }) {
                    Text("Edit")
                }

                Button(onClick = { viewModel.deleteCategory(category) }) {
                    Text("Delete")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Navigation Buttons
        Button(onClick = { navController.navigate(NavRoutes.HOME) }) {
            Text("Back to Home")
        }
        Button(onClick = { navController.navigate(NavRoutes.SUMMARY) }) {
            Text("Go to Summary")
        }
        Button(onClick = { navController.navigate(NavRoutes.EXPENSE) }) {
            Text("Go to Expenses")
        }
        Button(onClick = { navController.navigate(NavRoutes.GOAL) }) {
            Text("Go to Goals")
        }
    }
}






