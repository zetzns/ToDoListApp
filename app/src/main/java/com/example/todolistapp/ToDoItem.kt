package com.example.todolistapp

data class TodoItem(
    val task: String,
    var isDone: Boolean = false
)