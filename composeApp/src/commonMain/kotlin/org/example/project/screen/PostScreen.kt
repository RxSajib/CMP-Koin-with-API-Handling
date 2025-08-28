package org.example.project.screen

import Notify
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import org.example.project.component.PostItem
import org.example.project.data.model.Post
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PostScreen() {

    val viewModel: HomeViewModel = koinViewModel()
    val postResponse = viewModel.mutableStateFlowFlowResponse
    val lifecycle = LocalLifecycleOwner.current

    LaunchedEffect(lifecycle) {
        lifecycle.lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            postResponse.collect { post ->
                Notify(message = post.body, duration = NotificationDuration.SHORT)
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center
    ) {

        Column {
            Button(onClick = {
                viewModel.sendPost(
                    post = Post(
                        body = "this is sample body",
                        id = 1,
                        title = "title",
                        userId = 3
                    )
                )
            }) {
                Text("Update")
            }

            if (viewModel.isProgress) {
                Spacer(modifier = Modifier.height(10.dp))
                CircularProgressIndicator()
            }
        }

    }
}

@Preview
@Composable
fun PreviewPostScreen() {
    PostScreen()
}