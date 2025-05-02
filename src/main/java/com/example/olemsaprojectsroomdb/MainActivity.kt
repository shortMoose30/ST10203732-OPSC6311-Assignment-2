package com.example.olemsaprojectsroomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.olemsaprojectsroomdb.Navigation.BottomNavBar
import com.example.olemsaprojectsroomdb.navigation.AppNavGraph
import com.example.olemsaprojectsroomdb.ui.theme.BudgetAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) { innerPadding ->
        AppNavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
