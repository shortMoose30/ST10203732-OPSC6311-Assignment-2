package com.example.olemsaprojectsroomdb.Navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Goal,
        BottomNavItem.Expense,
        BottomNavItem.Category,
        BottomNavItem.Summary
    )

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar(containerColor = Color.DarkGray) {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Green,
                    unselectedIconColor = Color.LightGray
                )
            )
        }
    }
}
