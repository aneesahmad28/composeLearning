package com.example.composelearning

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class NavigationGraph

@Composable
fun setNavigationGraph(navigationController: NavHostController)
{
    NavHost(navController = navigationController, startDestination = Screens.Splash.route )
    {
        composable(route = Screens.Splash.route)
        {
            SplashScreen(navController = navigationController)
        }
        composable(route = Screens.Login.route)
        {
            LoginScreen(navHostController = navigationController)
        }
        composable(route = Screens.Home.route)
        {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Hello World",
                    color = Color.Black
                )
            }
        }
        composable(route = Screens.SignUp.route)
        {
            SignupScreen(navController = navigationController)
        }
        composable(route = Screens.ForgotPassword.route){
        ForgotPasswordScreen(navHostController = navigationController)
        }
        composable(route = Screens.ListView.route){
            ListViewScreen(navHostController = navigationController)
        }
        composable(route = Screens.ConstraintLayout.route){
            ConstraintLayout(navHostController = navigationController)
        }
        composable(route = Screens.InstagramProfile.route){
            InstagramProfile(navHostController = navigationController)
        }

    }
}
