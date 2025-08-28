package org.example.project.screen

import Notify
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.aakira.napier.Napier
import org.example.project.component.PersonItem
import org.example.project.component.PostItem
import org.example.project.component.dialog.LogoutDialog
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen() {
    val viewmodel: HomeViewModel = koinViewModel()
    val posts = viewmodel.post.collectAsStateWithLifecycle()


   Surface {
        Scaffold { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding).fillMaxSize().padding(10.dp), contentAlignment = Alignment.Center) {

                if(viewmodel.isProgress){
                    CircularProgressIndicator()
                }
                LazyColumn {
                    items(posts.value) {post ->
                        PostItem(post = post)
                    }
                }



            }
        }
    }

    if (viewmodel.showDialog) {
        LogoutDialog { viewmodel.showDialog = false }
    }
}