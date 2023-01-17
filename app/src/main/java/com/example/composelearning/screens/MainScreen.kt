package com.example.composelearning

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Splash.route)
    {
        composable(Screens.Splash.route)
        {
            SplashScreen(navController = navController)
        }
        composable(Screens.Login.route)
        {
            LoginScreen(navHostController = navController)
        }
        composable(Screens.Home.route)
        {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
                contentAlignment = Alignment.Center) {
                Text(text = "Hello World",
                    color = Color.Black)
            }
        }
        composable(Screens.ListView.route)
        {
            ListViewScreen(navHostController = navController)
        }
    }
}