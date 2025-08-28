package org.example.project.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.example.project.data.model.Post
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PostItem(post: Post){
    Box(modifier = Modifier.fillMaxWidth().padding(10.dp)){
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = post.title,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = post.body,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}

@Preview
@Composable
fun PreviewPost(){
    PostItem(
        post = Post(
            body = "asd asda sd aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            id = 10,
            title = "Title",
            userId = 2
        )
    )
}
