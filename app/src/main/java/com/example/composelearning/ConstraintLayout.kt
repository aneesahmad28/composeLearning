package com.example.composelearning

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController

@Composable
fun ConstraintLayout (navHostController: NavHostController){

    scaffoldWithTopBar(navController = navHostController)
}

@Composable
fun scaffoldWithTopBar(navController: NavHostController)
{
    val constraints = ConstraintSet{
        val greenBox = createRefFor("green_box")
        val redBox = createRefFor("red_box")
        val blueBox = createRefFor("blue_box")
        val whiteBox = createRefFor("white_box")
        val orangeBox = createRefFor("orange_box")

        constrain(greenBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(70.dp)
            height = Dimension.value(70.dp)
        }
        constrain(redBox) {
            top.linkTo(greenBox.bottom)
            start.linkTo(greenBox.end)
            width = Dimension.value(70.dp)
            height = Dimension.value(70.dp)
        }
        constrain(blueBox) {
            top.linkTo(redBox.bottom)
            start.linkTo(redBox.end)
            width = Dimension.value(70.dp)
            height = Dimension.value(70.dp)
        }
        constrain(whiteBox) {
            top.linkTo(blueBox.bottom)
            start.linkTo(blueBox.end)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(70.dp)
        }
        constrain(whiteBox) {
            top.linkTo(blueBox.bottom)
            start.linkTo(blueBox.end)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(70.dp)
        }
        constrain(orangeBox) {
            top.linkTo(whiteBox.bottom)
            start.linkTo(whiteBox.end)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(70.dp)
        }
    }
    androidx.constraintlayout.compose.ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.background(Color.Green)
            .layoutId("green_box"))
        Box(modifier = Modifier.background(Color.Red)
            .layoutId("red_box"))
        Box(modifier = Modifier.background(Color.Blue)
            .layoutId("blue_box"))
        Box(modifier = Modifier.background(Color.White)
            .layoutId("white_box"))
        Box(modifier = Modifier.background(Color.Cyan)
            .layoutId("orange_box"))

        
    }
}