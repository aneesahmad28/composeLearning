package com.example.composelearning

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composelearning.navigation.Screens
import com.example.composelearning.ui.theme.Purple500



//@Composable
//fun LoginScreen(navHostController: NavHostController) {
//
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    val context = LocalContext.current
//    Box {
//        Image(
//            painter = painterResource(id = R.drawable.icn_bg_spash),
//            contentDescription = "background",
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.FillBounds
//        )
//        ClickableText(
//            text = AnnotatedString("Sign up here"),
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(20.dp),
//            onClick = { navHostController.navigate(Screens.SignUp.route) },
//            style = TextStyle(
//                fontSize = 14.sp,
//                fontFamily = FontFamily.Default,
//                textDecoration = TextDecoration.Underline,
//                color = Purple500
//            )
//        )
//    }
//    Column(
//        modifier = Modifier
//            .padding(20.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    )
//    {
//
//        Text(text = "Login", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))
//        Spacer(modifier = Modifier.height(40.dp))
//        OutlinedTextField(
//            value = email,
//            shape = RoundedCornerShape(24.dp),
//            label = { Text(text = "Username", color = Color.Black) },
//            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = Color.White,
//                focusedIndicatorColor = Color.Transparent,
//                cursorColor = Color.Black,
//                textColor = Color.DarkGray
//            ),
//            onValueChange = {
//                email = it
//                Log.d(TAG, "LoginScreen: " + email)
//            })
//        Spacer(modifier = Modifier.height(10.dp))
//        OutlinedTextField(
//            value = password,
//            shape = RoundedCornerShape(24.dp),
//            label = { Text(text = "Password", color = Color.Black) },
//            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = Color.White,
//                focusedIndicatorColor = Color.Transparent,
//                cursorColor = Color.Black,
//                textColor = Color.DarkGray
//            ),
//            visualTransformation = PasswordVisualTransformation(),
//            onValueChange = {
//                password = it
//            },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//        )
//        Spacer(modifier = Modifier.height(10.dp))
//        ClickableText(
//            text = AnnotatedString("Forgot Password?"),
//            onClick = { navHostController.navigate(Screens.ForgotPassword.route) },
//            style = TextStyle(
//                fontSize = 16.sp,
//                fontFamily = FontFamily.Default,
//                color = Color.White,
//                fontWeight = FontWeight.SemiBold
//            ),
//            modifier = Modifier
//                .align(Alignment.End)
//                .padding(end = 20.dp)
//        )
//        Spacer(modifier = Modifier.size(10.dp))
//        Box(
//            modifier = Modifier
//                .padding(0.dp, 0.dp, 0.dp, 0.dp)
//                .height(50.dp)
//                .background(
//                    brush = Brush.horizontalGradient(
//                        colors = listOf(
//                            Color.Blue,
//                            Color.Black
//                        )
//                    ),
//                    shape = RoundedCornerShape(24.dp)
//                )
//
//
//        ) {
//            OutlinedButton(
//                onClick = {
//                    if (email.equals("anees1") && password.equals("123456"))
//                        navHostController.navigate(Screens.SignUp.route)
//                    else
//                        Toast.makeText(context, "Inavalid Credantials", Toast.LENGTH_LONG).show()
//                },
//                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
//                modifier = Modifier
//                    .fillMaxSize()
//                    .height(50.dp)
//                    .background(Color.Transparent),
//                shape = RoundedCornerShape(30.dp)
//            ) {
//                Text(
//                    text = "Login",
//                    fontWeight = FontWeight.SemiBold, color = Color.White,
//                    fontSize = 16.sp,
//                    textAlign = TextAlign.Center
//                )
//            }
//        }
//        Spacer(modifier = Modifier.height(20.dp))
//
//    }
//}


@Composable
fun LoginScreen(navHostController: NavHostController) {

    var switchOn by remember { mutableStateOf(false) }
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F0EB))
            .padding(26.dp, 0.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "English", color = Color.Black)
            Spacer(modifier = Modifier.size(5.dp))
            Switch(
                checked = switchOn, onCheckedChange = { switchOn_ -> switchOn = switchOn_ },
                modifier = Modifier
                    .scale(scale = 1.1f),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFF213060),
                    checkedTrackColor = Color(0xFFF7F8F9),
                    uncheckedThumbColor = Color(0xFF213060),
                    uncheckedTrackColor = Color(0xFFF7F8F9)
                )
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = "Arabic", color = Color.Black)

        }
        Spacer(modifier = Modifier.size(40.dp))
        Image(
            modifier = Modifier.fillMaxWidth().size(206.dp,58.dp),
            painter = painterResource(id = R.drawable.ic_splash_logo),
            contentDescription = "app name logo",
            alignment = Alignment.Center
        )
        Text(
            text = "Transforming Social Security in MENA",
            color = Color(0xFF999999),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(30.dp))

        Image(
            modifier = Modifier.fillMaxWidth().size(68.dp,68.dp),
            painter = painterResource(id = R.drawable.ic_user_login),
            contentDescription = "userIcon"
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = "Welcome Back!",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Please enter your details to login",
            fontSize = 16.sp,
            color = Color(0xFF999999),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(40.dp))
        TextField(value = userName,
            onValueChange = { userName = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    text = "Enter your email", color = Color.White
                )
            },
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFF96AED0),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Black,
                textColor = Color.Black,
            )
        )
        Spacer(modifier = Modifier.size(15.dp))

        TextField(value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            label = {
                Text(
                    text = "Enter password", color = Color.White
                )
            },
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFF96AED0),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Black,
                textColor = Color.Black,
            )
        )
        Spacer(modifier = Modifier.size(10.dp))
        ClickableText(
            text = AnnotatedString("Forgot Password?"),
            onClick = {navHostController.navigate(Screens.ForgotPassword.route)},
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(textAlign = TextAlign.End, color = Color(0xFF124DA5))
        )
        Spacer(modifier = Modifier.size(10.dp))

        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF213060), RoundedCornerShape(24.dp)),
            onClick = { navHostController.navigate(Screens.RandomUsers.route) }) {
            Text(
                text = "Login",
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.size(20.dp))

        Image(
            modifier = Modifier.fillMaxWidth().size(80.dp,80.dp),
            painter = painterResource(id = R.drawable.ic_fingerprint_login),
            contentDescription = "biometricLogo",
            alignment = Alignment.Center
        )


    }

}

@Preview
@Composable
fun loginScreenPreview() {
    LoginScreen(rememberNavController())
}

