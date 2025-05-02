package com.example.olemsaprojectsroomdb.Navigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val label: String, val icon: ImageVector) {
    object Home : BottomNavItem("home", "Home", Icons.Default.Home)
    object Goal : BottomNavItem("goal", "Goal", Icons.Default.Flag)
    object Expense : BottomNavItem("expense", "Expense", Icons.Default.AttachMoney)
    object Category : BottomNavItem("category", "Category", Icons.Default.Category)
    object Summary : BottomNavItem("summary", "Summary", Icons.Default.BarChart)
}
