package com.teste.personal_tool_app.presentation.navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

//import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppBar(navController: NavController, color: Color = Color.DarkGray) {
//    val backStackEntry = navController.currentBackStackEntryAsState()
    if (navController.backQueue.count() > 1) {
        TopAppBar(
            title = { Text(text = "") },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(Icons.Rounded.ArrowBack, "")
                }
            },
            backgroundColor = MaterialTheme.colors.primary
        )
    } else {
        TopAppBar(
            title = { Text(text = "") },
            backgroundColor = MaterialTheme.colors.primary
        )

    }
}