package com.example.walkthroughviewmodelkotlin.ui.viewmodel

import androidx.lifecycle.ViewModel


class TodoViewModel: ViewModel() {
    val todos = mutableListOf<String>()

    init {
        todos.add("Todo 1")
        todos.add("Todo 2")
        todos.add("Todo 3")
    }

}