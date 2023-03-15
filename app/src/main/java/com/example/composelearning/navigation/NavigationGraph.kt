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
import com.example.composelearning.data.RandomUserData
import com.example.composelearning.navigation.Screens
import com.example.composelearning.screens.RandomUsers
import com.example.composelearning.screens.ToDoList

@Composable
fun setNavigationGraph(navigationController: NavHostController) {
    val dummyUsers = listOf(
        RandomUserData(
            "John Doe",
            1,
            "0300 7386799",
            "john.doe@example.com",
            "https://dummyimage.com/200x200/000/fff"
        ),
        RandomUserData(
            "Jane Smith",
            2,
            "0300 7285789",
            "jane.smith@example.com",
            "https://dummyimage.com/200x200/000/fff"
        ),
        RandomUserData(
            "Bob Johnson",
            3,
            "0300 728479",
            "bob.johnson@example.com",
            "https://dummyimage.com/200x200/000/fff"
        ),
        RandomUserData(
            "John Doe",
            1,
            "0300 7386799",
            "john.doe@example.com",
            "https://dummyimage.com/200x200/000/fff"
        ),
        RandomUserData(
            "Jane Smith",
            2,
            "0300 7285789",
            "jane.smith@example.com",
            "https://dummyimage.com/200x200/000/fff"
        ),
        RandomUserData(
            "Bob Johnson",
            3,
            "0300 728479",
            "bob.johnson@example.com",
            "https://dummyimage.com/200x200/000/fff"
        ),
        RandomUserData(
            "John Doe",
            1,
            "0300 7386799",
            "john.doe@example.com",
            "https://dummyimage.com/200x200/000/fff"
        ),
        RandomUserData(
            "Jane Smith",
            2,
            "0300 7285789",
            "jane.smith@example.com",
            "https://dummyimage.com/200x200/000/fff"
        ),
        RandomUserData(
            "Bob Johnson",
            3,
            "0300 728479",
            "bob.johnson@example.com",
            "https://dummyimage.com/200x200/000/fff"
        ),
        RandomUserData(
            "John Doe",
            1,
            "0300 7386799",
            "john.doe@example.com",
            "https://dummyimage.com/200x200/000/fff"
        ),
        RandomUserData(
            "Jane Smith",
            2,
            "0300 7285789",
            "jane.smith@example.com",
            "https://dummyimage.com/200x200/000/fff"
        ),
        RandomUserData(
            "Bob Johnson",
            3,
            "0300 728479",
            "bob.johnson@example.com",
            "https://dummyimage.com/200x200/000/fff"
        )
    )
    NavHost(navController = navigationController, startDestination = Screens.Splash.route)
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
        composable(route = Screens.ListView.route) {
            ListViewScreen(navHostController = navigationController)
        }
        composable(route = Screens.ConstraintLayout.route) {
            ConstraintLayout()
        }
        composable(route = Screens.InstagramProfile.route) {
            InstagramProfile(navHostController = navigationController)
        }
        composable(route = Screens.ToDoList.route) {
            ToDoList(navHostController = navigationController)
        }
        composable(route = Screens.RandomUsers.route) {
            RandomUsers(navHostController = navigationController, dummyUsers)
        }

    }
}
