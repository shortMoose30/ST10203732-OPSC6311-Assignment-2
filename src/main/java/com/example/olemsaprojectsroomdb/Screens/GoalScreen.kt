package com.example.olemsaprojectsroomdb.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.olemsaprojectsroomdb.navigation.NavRoutes

@Composable
fun GoalScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("Goal Screen", color = Color.Gray)
        Button(onClick = { navController.navigate(NavRoutes.HOME) }) {
            Text("Back to Home")
        }
        Button(onClick = { navController.navigate(NavRoutes.SUMMARY) }) {
            Text("Go to Summary")
        }
        Button(onClick = { navController.navigate(NavRoutes.EXPENSE) }) {
            Text("Go to Expenses")
            }
        Button(onClick = { navController.navigate(NavRoutes.CATEGORY) }) {
            Text("Go to Category")
        }
    }

}

