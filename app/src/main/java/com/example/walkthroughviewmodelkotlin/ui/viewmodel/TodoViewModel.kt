package com.example.walkthroughviewmodelkotlin.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class TodoViewModel: ViewModel() {
    val todos = mutableStateListOf<Todo>()

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi!!.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
            } catch (e: Exception) {
                Log.d("TodoViewModelError", e.message.toString())
            }
        }
    }
}