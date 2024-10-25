package com.example.walkthroughviewmodelkotlin.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.walkthroughviewmodelkotlin.ui.theme.WalkthroughViewModelKotlinTheme
import com.example.walkthroughviewmodelkotlin.ui.viewmodel.Todo
import com.example.walkthroughviewmodelkotlin.ui.viewmodel.TodoViewModel

/*
Walkthrough. Todo – Creating Viewmodel (part 1)
Todo sample app and related walkthroughs contains three parts:
1. Creating basic Todo app using hardcoded values (list) from a ViewModel class.
2. Connecting to the internet and reading JSON data using Retrofit and Gson
libraries. Creating MVVM architecture for Android app.
3. Handling possible errors and displaying them on UI. Displaying loading message
while data is retrived from the API service.
App will read and display data from open API available on
https://jsonplaceholder.typicode.com/todos. Service returns list of Todo objects
(containing just some random trivial generated data).
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WalkthroughViewModelKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TodoScreen(
                        modifier = Modifier.padding(innerPadding),
                        todoViewModel = TodoViewModel()
                    )
                }
            }
        }
    }
}

@Composable
fun TodoScreen(modifier: Modifier = Modifier, todoViewModel: TodoViewModel) {
    TodoList(todos = todoViewModel.todos, modifier = modifier)
}

@Composable
fun TodoList(modifier: Modifier = Modifier, todos: List<Todo>) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp),
    ) {
        items(todos) { todo ->
            Text(
                text = todo.title,
                modifier = Modifier.padding(8.dp)
            )
            // Värit teeman mukaan ni ei tarvi ite miettiä ulkonäköä tässä vaiheessa
            HorizontalDivider(color = MaterialTheme.colorScheme.outline)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoScreenPreview() {
    WalkthroughViewModelKotlinTheme {
        TodoScreen(todoViewModel = TodoViewModel())
    }
}