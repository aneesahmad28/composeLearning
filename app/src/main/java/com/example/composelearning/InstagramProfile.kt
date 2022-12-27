package com.example.composelearning

import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun InstagramProfile(navHostController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
    ) {
        //professional dashboard
//        Spacer(modifier = Modifier.size(20.dp))
//        AnimatedBorderDemo()
        Spacer(modifier = Modifier.size(20.dp))
        ProfessionalDashBoard()
        Spacer(modifier = Modifier.size(10.dp))
        Divider(
            color = Color.DarkGray,
            thickness = 0.2.dp
        )
        // Profile picture and username
        Row(Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
            usernameAndProfilePicture()
            Spacer(Modifier.size(16.dp))
            // Posts, followers, and following count
            followerAndPostsCounter()
        }
        Spacer(modifier = Modifier.size(10.dp))
        //profile bio text
        profileBioText()
        //Follow and message buttons
        Spacer(modifier = Modifier.size(10.dp))
        profileActionButtons()
        //stories highlights
        Spacer(modifier = Modifier.size(10.dp))
        StoriesHighlights()
        //profile tabs
        profileTabs()
        //Grid of posts
        InstagramPostGrid()
    }
}

@Composable
fun usernameAndProfilePicture() {

    Image(
        painter = painterResource(id = R.drawable.profile_image),
        contentDescription = "Profile Image",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .border(1.dp, Color.White, CircleShape)
    )
}

@Composable
fun followerAndPostsCounter() {
    Row(Modifier.padding(16.dp)) {
        Column {
            CounterValueText(text = "60", Modifier.align(Alignment.CenterHorizontally))
            CounterLabelsText(text = "Posts", Modifier.align(Alignment.CenterHorizontally))

        }
        Spacer(Modifier.size(16.dp))
        Column {
            CounterValueText(text = "300", Modifier.align(Alignment.CenterHorizontally))
            CounterLabelsText(text = "Followers", Modifier.align(Alignment.CenterHorizontally))
        }
        Spacer(Modifier.size(16.dp))
        Column {
            CounterValueText(text = "156", Modifier.align(Alignment.CenterHorizontally))
            CounterLabelsText(text = "Following", Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Composable
fun ProfessionalDashBoard() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Professional Dashboard",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Tools and resources just for creators.",
                color = Color.White,
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.ic_round_arrow_forward),
            contentDescription = "forward arrow",

            )
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun profileBioText() {
    Column(modifier = Modifier.padding(end = 30.dp, start = 16.dp)) {
        val colors = listOf(Color.Cyan, Color.Green, Color.Magenta)
        val infiniteTransition = rememberInfiniteTransition()
        val offset by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 2000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        val brush = remember(offset) {
            object : ShaderBrush() {
                override fun createShader(size: Size): Shader {
                    val widthOffset = size.width * offset
                    val heightOffset = size.height * offset
                    return LinearGradientShader(
                        colors = colors,
                        from = Offset(widthOffset, heightOffset),
                        to = Offset(widthOffset + size.width, heightOffset + size.height),
                        tileMode = TileMode.Mirror
                    )
                }
            }

        }
        Text(
            text = "Anees Ahmad",
            color = Color.White,
            style = TextStyle(brush = brush)

        )
        Text(
            text = "Photographer",
            color = Color.Gray,
            fontSize = 14.sp,
            style = MaterialTheme.typography.overline,
        )
        Text(
            text = "Your bio goes here.\n You can also include your website.",
            style = MaterialTheme.typography.body2,
            color = Color.White
        )
        Text(
            text = "www.website.com",
            style = MaterialTheme.typography.caption,
            color = Color.Blue
        )
    }
}

@Composable
fun profileActionButtons() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Button(
            onClick = { /* Handle follow action */ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            modifier = Modifier
                .height(35.dp)
                .weight(2f)
        ) {
            ButtonText(text = "Follow", Modifier)
        }
        Spacer(Modifier.size(8.dp))
        Button(
            onClick = { /* Handle message action */ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            modifier = Modifier
                .height(35.dp)
                .weight(2f)
        ) {
            ButtonText(text = "Contact", Modifier)
        }
        Spacer(modifier = Modifier.size(8.dp))
        Button(
            onClick = { /* Handle follow action */ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            modifier = Modifier
                .height(35.dp)
                .weight(2f)
        ) {
            ButtonText(text = "Message", Modifier)
        }
    }
}

@Composable
fun Profile() {

}

@Composable
fun profileTabs() {
    var selectedTab by remember { mutableStateOf(-1) }
    val tabsList = listOf("Posts", "Reels", "Saved")
    TabRow(
        selectedTabIndex = selectedTab,
        backgroundColor = Color.Black,
        modifier = Modifier.padding(vertical = 10.dp),
        indicator = { tabPositions: List<TabPosition> ->
            Box {}
        }
    ) {
        tabsList.forEachIndexed { index, s ->
            val selected = selectedTab == index
            Tab(modifier = if (selected) Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(
                    Color.Gray
                )
            else Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Black),
                selected = selected,
                onClick = { selectedTab = index },
                text = { Text(text = s, color = Color.White) }

            )

        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InstagramPostGrid() {
    // Replace with your own logic for loading and displaying posts
    val number = (0..30).toList()
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(1.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp)
    )
    {
        items(number.size) {
            Image(
                painter = painterResource(id = R.drawable.profile_image),
                contentDescription = "posts"
            )
        }
    }
}

@Composable
fun StoriesHighlights() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        for (i in 1..10) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = "storiesHighlight",
                    Modifier
                        .clip(CircleShape)
                        .size(60.dp)
                )
                Spacer(modifier = Modifier.size(10.dp))
                CounterLabelsText(text = "Story $i")
            }

            Spacer(modifier = Modifier.size(20.dp, 50.dp))
        }
    }
}

@Composable
fun ButtonText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        color = Color.White,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun CounterLabelsText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
fun CounterValueText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.h4,
        color = Color.White,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Preview
@Composable
fun AnimatedBorderDemo() {
    val colors = listOf(Color.Cyan, Color.Green, Color.Magenta)
    val infiniteTransition = rememberInfiniteTransition()
    val offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val brush = remember(offset) {
        object : ShaderBrush() {
            override fun createShader(size: Size): Shader {
                val widthOffset = size.width * offset
                val heightOffset = size.height * offset
                return LinearGradientShader(
                    colors = colors,
                    from = Offset(widthOffset, heightOffset),
                    to = Offset(widthOffset + size.width, heightOffset + size.height),
                    tileMode = TileMode.Mirror
                )
            }
        }

    }
    Box(modifier = Modifier
        .size(height = 120.dp, width = 200.dp)
        .clip(RoundedCornerShape(24.dp))
        .border(width = 2.5.dp, brush = brush, shape = RoundedCornerShape(24.dp)))

}



