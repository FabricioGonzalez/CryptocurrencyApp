package com.teste.personal_tool_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.navigation.compose.rememberNavController
import com.teste.personal_tool_app.presentation.navigation.AppBar
import com.teste.personal_tool_app.presentation.navigation.BottomNavItem
import com.teste.personal_tool_app.presentation.navigation.components.BottomNavigationBar
import com.teste.personal_tool_app.presentation.theme.CriptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CriptocurrencyAppTheme {
                val navController = rememberNavController()
                Scaffold(/*topBar = {
                    AppBar(navController)
                },*/ bottomBar = {
                    BottomNavigationBar(
                        items = listOf(
                            BottomNavItem(
                                name = "cripto",
                                route = Screen.CoinListScreen.route,
                                icon = Icons.Default.Info
                            ),
                            BottomNavItem(
                                name = "notifications",
                                route = Screen.NotificationScreen.route,
                                icon = Icons.Default.Notifications
                            )
                        ),
                        navController = navController,
                        onItemClick = {
                            navController.navigate(it.route)
                        }
                    )
                }) {
                    com.teste.personal_tool_app.presentation.navigation.components.Navigation(
                        navController = navController
                    )
                }
            }
        }
    }
}
