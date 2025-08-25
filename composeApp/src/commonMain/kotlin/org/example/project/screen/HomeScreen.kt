package org.example.project.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.project.component.PersonItem
import org.example.project.component.dialog.LogoutDialog
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen() {
    val viewmodel: HomeViewModel = koinViewModel()
    val listOfPerson = viewmodel.personList.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {

    }

    Surface {
        Scaffold { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding).fillMaxSize().padding(10.dp)) {
                LazyColumn {
                    items(listOfPerson.value) {
                        PersonItem(person = it)
                    }
                }
            }
        }
    }

    if (viewmodel.showDialog) {
        LogoutDialog { viewmodel.showDialog = false }
    }
}