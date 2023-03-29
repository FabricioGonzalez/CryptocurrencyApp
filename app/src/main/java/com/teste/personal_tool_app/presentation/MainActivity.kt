package com.teste.personal_tool_app.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
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
                val navController = rememberNavController()
                val systemUiController = rememberSystemUiController()

                systemUiController.setSystemBarsColor(
                    color = MaterialTheme.colorScheme.primaryContainer
                )

                val currentNavState = navController.currentBackStackEntryAsState()
                val navState = remember {
                    currentNavState
                }

                val screens = listOf(
                    BottomNavItem(
                        name = "cripto",
                        route = Screen.CoinListScreen.route,
                        icon = Icons.Default.Abc
                    ),
                    BottomNavItem(
                        name = "mangas",
                        route = Screen.MangaListScreen.route,
                        icon = Icons.Default.BookOnline
                    ),
                    BottomNavItem(
                        name = "animes",
                        route = Screen.AnimeListScreen.route,
                        icon = Icons.Default.BookOnline
                    ),
                    BottomNavItem(
                        name = "player",
                        route = Screen.AnimePlayerScreen.route,
                        icon = Icons.Default.PlayArrow,
                        hidden = true,
                        hideBottomBar = true
                    ),
                    BottomNavItem(
                        name = "weather",
                        route = Screen.WeatherScreen.route,
                        icon = Icons.Default.Refresh
                    )
                )
                val item = screens.firstOrNull {
                    navState.value?.destination?.route?.split("/")?.first()
                        ?.equals(it.route) == true
                }

                this.requestedOrientation =
                    item?.Orientation?.type ?: ScreenOrientation.Portrait.type
                Scaffold(
                    bottomBar = {
                        if (item?.hideBottomBar != true)
                            BottomNavigationBar(
                                items = screens,
                                backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                }
                            )
                    }) {
                    val padding = it.calculateBottomPadding()
                    Navigation(
                        navController = navController,
                        this,
                        Modifier.padding(top = 0.dp, start = 0.dp, end = 0.dp, bottom = padding)
                    )
                }
            }
        }
    }
}
