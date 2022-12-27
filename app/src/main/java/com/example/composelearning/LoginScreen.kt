package com.example.composelearning

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composelearning.ui.theme.Purple500

@Composable
fun LoginScreen (navHostController: NavHostController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)){
        ClickableText(
            text = AnnotatedString("Sign up here"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = {navHostController.navigate(Screens.SignUp.route)},
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = Purple500)
        )
    }
    Column(
        modifier = Modifier
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
     {
        val userName = remember { mutableStateOf(TextFieldValue())}
        val password = remember { mutableStateOf(TextFieldValue())}

            Text(text = "Login", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))
            Spacer(modifier = Modifier.height(20.dp))
             OutlinedTextField(
                value = userName.value,
                shape = RoundedCornerShape(12.dp),
                label = { Text(text = "Username", color = Color.Black)},
                colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Cyan,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Black,),
            onValueChange ={userName.value = it} )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password.value,
            shape = RoundedCornerShape(12.dp),
            label = {Text(text = "Password", color = Color.Black)},
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Cyan,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Black),
            visualTransformation = PasswordVisualTransformation(),
            onValueChange =   {password.value = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier
            .padding(40.dp, 0.dp, 40.dp, 0.dp)
            .height(50.dp)){
            Button(onClick = { navHostController.navigate(Screens.SignUp.route)},
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .fillMaxSize()
                .height(50.dp)) {
                Text(text = "Login")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        ClickableText(
            text = AnnotatedString("Forgot Password"),
            onClick = {navHostController.navigate(Screens.ForgotPassword.route)},
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                color = Color.Blue),
        )
    }
}