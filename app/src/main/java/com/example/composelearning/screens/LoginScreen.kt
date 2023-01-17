package com.example.composelearning

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composelearning.ui.theme.Purple500


@Preview
@Composable
fun LoginScreen(navHostController: NavHostController) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.icn_bg_spash),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        ClickableText(
            text = AnnotatedString("Sign up here"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = { navHostController.navigate(Screens.SignUp.route) },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = Purple500
            )
        )
    }
    Column(
        modifier = Modifier
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        val userName = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }

        Text(text = "Login", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            value = userName.value,
            shape = RoundedCornerShape(24.dp),
            label = { Text(text = "Username", color = Color.Black) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Black,
            ),
            onValueChange = {
                userName.value = it
                Log.d(TAG, "LoginScreen: " + it + userName.value)
            })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = password.value,
            shape = RoundedCornerShape(24.dp),
            label = { Text(text = "Password", color = Color.Black) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Black
            ),
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {
                password.value = it
                Log.d(TAG, "LoginScreen: " +userName.value)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )
        Spacer(modifier = Modifier.height(10.dp))
        ClickableText(
            text = AnnotatedString("Forgot Password?"),
            onClick = { navHostController.navigate(Screens.ForgotPassword.route) },
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily.Default,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 20.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Box(
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                .height(50.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Blue,
                            Color.Black
                        )
                    ),
                    shape = RoundedCornerShape(24.dp)
                )


        ) {
            OutlinedButton(
                onClick = { navHostController.navigate(Screens.SignUp.route) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                modifier = Modifier
                    .fillMaxSize()
                    .height(50.dp)
                    .background(Color.Transparent),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text(
                    text = "Login",
                    fontWeight = FontWeight.SemiBold, color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

    }
}