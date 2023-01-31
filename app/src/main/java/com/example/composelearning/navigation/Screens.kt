package com.example.composelearning.navigation

sealed class Screens(val route: String){
    object Splash: Screens("Splash_screen")
    object Home: Screens("Home")
    object Login: Screens("Login");
    object SignUp: Screens("Sign_up")
    object ForgotPassword: Screens("Forgot_Password")
    object ListView: Screens("List_view")
    object ConstraintLayout: Screens("constraint_layout")
    object InstagramProfile: Screens("Instagram_profile")
    object ToDoList: Screens("todo_list")
}
