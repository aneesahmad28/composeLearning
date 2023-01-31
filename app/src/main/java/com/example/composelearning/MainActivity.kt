package com.example.composelearning

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composelearning.components.BottomNavItem
import com.example.composelearning.components.BottomNavigationBar
import com.example.composelearning.navigation.Screens
import com.example.composelearning.ui.theme.ComposeLearningTheme
import com.example.composelearning.utils.AppConfig
import java.security.MessageDigest
import java.security.SecureRandom
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class MainActivity : ComponentActivity() {
    var currentRoute: String? = null

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var encryptedData: String = AppConfig.encrypt(
            "Anees Ahmad UnusedMaterialScaffoldPaddingParameter UnusedMaterialScaffoldPaddingParameterUnusedMaterialScaffoldPaddingParameterUnusedMaterialScaffoldPaddingParameter",
            "1234abcdkdsfksdfiisuesfkksjdfkjd"
        )
        Log.d("encrypted data", "onCreate: $encryptedData")

        var decryptedData: String = AppConfig.decrypt(encryptedData, "1234abcdkdsfksdfiisuesfkksjdfkjd")
        Log.d("decrypted data", "onCreate: $decryptedData")
        setContent {

            ComposeLearningTheme {
                val navController = rememberNavController()
                currentRoute = currentRoute(navController = navController)
                if (currentRoute(navController = navController) != Screens.Splash.route) {
                    BottomBar(navController = navController)
                } else {
                    setNavigationGraph(navigationController = navController)
                }
            }
        }
    }

    override fun onBackPressed() {
        if (currentRoute.equals(Screens.Login.route, true))
            finishAffinity()
        else
            super.onBackPressed()

    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route

}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Composable
fun BottomBar(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "Todo",
                        route = Screens.ToDoList.route,
                        icon = Icons.Filled.Home
                    ),
                    BottomNavItem(
                        name = "Instagram",
                        route = Screens.InstagramProfile.route,
                        icon = Icons.Filled.AccountBox
                    )

                ),
                modifier = Modifier.background(Color.Magenta, RoundedCornerShape(20.dp)),
                navHostController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }

            )
        }
    ) {
        setNavigationGraph(navigationController = navController)
    }


}


