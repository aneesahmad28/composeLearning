package com.example.composelearning.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.composelearning.components.CustomToolBar
import com.example.composelearning.viewmodel.ToDoViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ToDoList(navHostController: NavHostController) {
    val toDoViewModel: ToDoViewModel = viewModel()

    LaunchedEffect(Unit, block = {
        toDoViewModel.getTodoList()
    })
    Scaffold(
        topBar = {
            CustomToolBar(
                navController = navHostController, title = "Todo List", showBackIcon = true
            )
        },
        content =
        { padding ->

            Column(Modifier.padding(padding)) {
                if (toDoViewModel.errorMessage.isEmpty()) {
                    LazyColumn(modifier = Modifier.fillMaxHeight()) {
                        items(toDoViewModel.todoList) { todo ->
                            Column {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(0.dp, 0.dp, 16.dp, 0.dp)
                                    )
                                    {
                                        Text(
                                            todo.title,
                                            maxLines = 2,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Checkbox(checked = todo.completed, onCheckedChange = null)
                                }
                                Spacer(modifier = Modifier.size(16.dp))
                            }
                        }
                    }
                } else {
                    Text(text = toDoViewModel.errorMessage)
                }
            }

        }
    )
}
