package com.example.composelearning.data

data class ToDo (
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
        )

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
const val RANDOM_USER_GENERATOR = "https://randomuser.me/"

