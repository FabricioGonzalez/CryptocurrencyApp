package com.teste.personal_tool_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.teste.personal_tool_app.R
import com.teste.personal_tool_app.presentation.navigation.AppBar
import com.teste.personal_tool_app.presentation.navigation.BottomNavItem
import com.teste.personal_tool_app.presentation.navigation.MenuItem
import com.teste.personal_tool_app.presentation.navigation.components.BottomNavigationBar
import com.teste.personal_tool_app.presentation.navigation.components.DrawerBody
import com.teste.personal_tool_app.presentation.navigation.components.DrawerHeader
import com.teste.personal_tool_app.presentation.theme.CriptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CriptocurrencyAppTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()

                val navController = rememberNavController()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(onNavigationIconClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        })
                    },
                    drawerGesturesEnabled = if (scaffoldState.drawerState.isOpen) true else false,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "home",
                                    title = "Home",
                                    contentDescription = "Go to Home Screen",
                                    icon = Icons.Default.Home
                                ), MenuItem(
                                    id = "settings",
                                    title = "Settings",
                                    contentDescription = "Go to Settings Screen",
                                    icon = Icons.Default.Settings
                                ), MenuItem(
                                    id = "help",
                                    title = "Help",
                                    contentDescription = "Get Help",
                                    icon = Icons.Default.Info
                                )
                            ), onItemClick = {
                                println("Clicked on ${it.title}")
                            }
                        )
                    },
                    bottomBar = {
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
