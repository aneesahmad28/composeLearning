package com.example.composelearning

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composelearning.components.CustomToolBar

@Composable
fun SignupScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()

    )
    {
        ScaffoldWidthTopBar(navController = navController)
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldWidthTopBar(navController: NavHostController) {
    Scaffold(
        modifier = Modifier
            .background(Color.White),
        backgroundColor = Color.White,
        topBar = {
            CustomToolBar(
                navController = navController,
                title = stringResource(R.string.text_sign_up),
                showBackIcon = true
            )
        },
        content =
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(
                    text = stringResource(R.string.text_sign_up),
                    fontSize = 30.sp,
                    color = Color.Black
                )
                Button(
                    onClick = { navController.navigate(Screens.ConstraintLayout.route) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = stringResource(R.string.text_constraint_layout),
                        modifier = Modifier.padding(10.dp),
                        color = Color.White
                    )
                }
                Button(
                    onClick = { navController.navigate(Screens.InstagramProfile.route) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = stringResource(R.string.text_instagram_profile),
                        modifier = Modifier.padding(10.dp),
                        color = Color.White
                    )
                }
            }
        }
    )
}