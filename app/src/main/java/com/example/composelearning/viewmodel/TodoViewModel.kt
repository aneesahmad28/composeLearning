package com.example.composelearning.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composelearning.network.RetrofitBuilder
import com.example.composelearning.data.ToDo
import kotlinx.coroutines.launch

class ToDoViewModel: ViewModel() {

    private val _todoList = mutableStateListOf<ToDo>()
    var errorMessage: String by mutableStateOf("")
    val todoList: List<ToDo>
    get() = _todoList

    fun getTodoList() {
        viewModelScope.launch {
            val retrofitBuilder = RetrofitBuilder.getInstance()
            try {
                _todoList.clear()
                _todoList.addAll(retrofitBuilder.getTodos())
            }catch (ex: Exception)
            {
                errorMessage = ex.message.toString()
            }
        }
    }
}