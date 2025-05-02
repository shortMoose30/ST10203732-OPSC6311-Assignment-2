package com.example.olemsaprojectsroomdb.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.olemsaprojectsroomdb.ExpenseScreen
import com.example.olemsaprojectsroomdb.Navigation.BottomNavBar
import com.example.olemsaprojectsroomdb.ui.screens.CategoryScreen
import com.example.olemsaprojectsroomdb.ui.screens.GoalScreen
import com.example.olemsaprojectsroomdb.ui.screens.HomeScreen
import com.example.olemsaprojectsroomdb.ui.screens.SummaryScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavGraph(navController: NavHostController,
                modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = { BottomNavBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.HOME,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavRoutes.HOME) { HomeScreen(navController) }
            composable(NavRoutes.GOAL) { GoalScreen(navController) }
            composable(NavRoutes.EXPENSE) { ExpenseScreen(navController) }
            composable(NavRoutes.CATEGORY) { CategoryScreen(navController) }
            composable(NavRoutes.SUMMARY) { SummaryScreen(navController) }
        }
    }
}





