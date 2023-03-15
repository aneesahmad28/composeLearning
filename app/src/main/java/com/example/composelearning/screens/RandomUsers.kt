package com.example.composelearning.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composelearning.R
import com.example.composelearning.components.RandomUserListItem
import com.example.composelearning.components.UserBottomSheet
import com.example.composelearning.data.RandomUserData
import kotlinx.coroutines.launch

@Composable
fun RandomUsers(navHostController: NavHostController, users: List<RandomUserData>) {

    var selectedUser by remember { mutableStateOf<RandomUserData?>(null) }
    var bottomSheetVisible by remember { mutableStateOf(false) }
    var coroutineScope = rememberCoroutineScope()
    var userList = remember { users }
    LazyColumn(modifier = Modifier.paddingFromBaseline(0.dp, 100.dp)) {
        fun onUserClick(user: RandomUserData) {
            // Set the selected user as a state variable
            selectedUser = user
            // Open the bottom sheet
            bottomSheetVisible = true
        }
        items(userList) { user ->
            Box(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .clickable { onUserClick(user) }) {
                RandomUserListItem(
                    name = user.userName, email = user.userEmail, painter = painterResource(
                        id = R.drawable.profile_image
                    )
                )
            }

        }
    }
    // Display the bottom sheet if it's visible
    if (bottomSheetVisible && selectedUser != null) {
        UserBottomSheet(selectedUser!!, onClose = {
            coroutineScope.launch {
                selectedUser = null
                bottomSheetVisible = false
                userList = users
            }
            // Set the selected user to null and close the bottom sheet
        })
    }


}


