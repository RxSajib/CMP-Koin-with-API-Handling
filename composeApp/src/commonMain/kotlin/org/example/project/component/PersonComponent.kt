package org.example.project.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import koinexample.composeapp.generated.resources.Res
import koinexample.composeapp.generated.resources.placeholder
import org.example.project.data.model.Person
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PersonItem(person: Person) {
    Box(
        modifier = Modifier.fillMaxWidth().background(color = MaterialTheme.colorScheme.background)
            .clip(shape = RoundedCornerShape(size = 10.dp))
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = person.profileImage,
                error = painterResource(Res.drawable.placeholder),
                placeholder = painterResource(Res.drawable.placeholder),
                contentDescription = null,
                modifier = Modifier.size(60.dp).clip(shape = CircleShape),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = person.name,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = person.emailAddress,
                    modifier = Modifier.fillMaxWidth(),
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
@Preview
fun PersonItemPreview() {
    PersonItem(
        person = Person(
            name = "Sajib",
            emailAddress = "sajibroY206@gmail.com",
            profileImage = ""
        )
    )

}