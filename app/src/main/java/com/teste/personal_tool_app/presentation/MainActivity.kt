package com.teste.personal_tool_app.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookOnline
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.teste.personal_tool_app.presentation.navigation.BottomNavItem
import com.teste.personal_tool_app.presentation.navigation.components.BottomNavigationBar
import com.teste.personal_tool_app.presentation.navigation.components.Navigation
import com.teste.personal_tool_app.presentation.theme.CriptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val permissionLauncher: ActivityResultLauncher<Array<String>> = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {

        }
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )

        setContent {
            CriptocurrencyAppTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()

                val navController = rememberNavController()
                Scaffold(
                   /* scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(onNavigationIconClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        })
                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
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
                    },*/
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "cripto",
                                    route = Screen.CoinListScreen.route,
                                    icon = Icons.Default.Info
                                ),
                                BottomNavItem(
                                    name = "mangas",
                                    route = Screen.MangaListScreen.route,
                                    icon = Icons.Default.BookOnline
                                ),
                                /*  BottomNavItem(
                                      name = "notifications",
                                      route = Screen.NotificationScreen.route,
                                      icon = Icons.Default.Notifications
                                  ),*/
                                BottomNavItem(
                                    name = "weather",
                                    route = Screen.WeatherScreen.route,
                                    icon = Icons.Default.Refresh
                                )
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }) {
                    Navigation(
                        navController = navController,
                        this
                    )
                }
            }
        }
    }
}
