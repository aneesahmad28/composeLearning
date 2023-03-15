package com.example.composelearning.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelearning.R
import com.example.composelearning.data.RandomUserData

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserBottomSheet(userData: RandomUserData, onClose: ()-> Unit) {
    BottomSheetScaffold(
        sheetContent = {
        Column(
            Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Spacer(modifier = Modifier.size(10.dp))
            Image(
                painter = painterResource(id = R.drawable.profile_image),
                contentDescription = "profileImage",
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .size(300.dp, 300.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = userData.userName,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = userData.userEmail,
                color = Color.White,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.size(100.dp))
        }
    },
        sheetPeekHeight = 0.dp,
        scaffoldState = rememberBottomSheetScaffoldState(
            bottomSheetState = rememberBottomSheetState(
                initialValue = BottomSheetValue.Expanded
            )
        ),
        sheetBackgroundColor = Color.White,
        sheetShape = MaterialTheme.shapes.small,
        backgroundColor = MaterialTheme.colors.background,
        sheetContentColor = MaterialTheme.colors.onBackground,
        sheetElevation = 16.dp,
        sheetGesturesEnabled = true,)
    {
        paddingValues ->
        BackHandler(onBack = onClose)
    }
}