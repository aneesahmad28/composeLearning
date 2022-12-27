package com.example.composelearning

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composelearning.components.CustomToolBar

@Composable
fun ForgotPasswordScreen(navHostController: NavHostController){
    Box(modifier = Modifier.fillMaxSize()){
        ScaffoldWidthTopBarForgotPassword(navController = navHostController)
    }
}
@Composable
fun ScaffoldWidthTopBarForgotPassword(navController: NavHostController)
{
    Scaffold (
        topBar = { CustomToolBar(navController = navController, title = "Forgot Password", showBackIcon = true)},
        content = {
            Column(modifier = Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text ="Forgot Password",
                    fontSize = 30.sp,
                    color = Color.Black
                )
            }
        }
            )
}