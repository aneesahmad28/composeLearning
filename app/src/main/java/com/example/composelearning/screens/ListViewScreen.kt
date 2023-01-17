package com.example.composelearning

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composelearning.components.CustomToolBar

@Composable
fun ListViewScreen (navHostController: NavHostController){
    Box(modifier = Modifier.fillMaxSize())
    {
        ScaffoldWithTopBar(navController = navHostController)
    }


}
@Composable
fun ScaffoldWithTopBar(navController: NavHostController)
{
    Scaffold (
        topBar = { CustomToolBar(navController = navController, title = "ListView", showBackIcon = true)},
        content = {
            LazyColumn{
                itemsIndexed(
                    listOf("This", "is", "jetpack", "compose", "This", "is", "jetpack", "compose")
                ) {
                    index, item ->
                    run {
                        showText(i = item)
                    }
                }
            }
        }
        )
}

@Composable
fun showText(i: String)
{
    Text(text = i,
    fontSize = 24.sp,
    fontWeight = FontWeight.Bold,
    textAlign = TextAlign.Center,
    modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 24.dp))
}