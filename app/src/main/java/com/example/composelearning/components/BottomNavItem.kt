package com.example.composelearning.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
)

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navHostController.currentBackStackEntryAsState()
    BottomAppBar(

    ) {
        BottomNavigation(
            modifier = Modifier.background(Color.Magenta, RoundedCornerShape(24.dp)),
        ) {

            items.forEach { item ->
                var selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    onClick = {onItemClick(item)},
                    selectedContentColor = Color(0xFFFFFFFF),
                    unselectedContentColor = Color(0x88FFFFFF),
                    icon = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(imageVector = item.icon , contentDescription = item.name)
                            Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
                        }
                    }

                )
            }
        }
    }

}
