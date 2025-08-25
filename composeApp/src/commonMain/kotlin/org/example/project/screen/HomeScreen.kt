package org.example.project.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.component.dialog.LogoutDialog
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(){
    val viewmodel : HomeViewModel = koinViewModel()

    Surface {
        Scaffold { innerPadding ->
            Box(modifier = Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.Center){
                Button(onClick = {
                    viewmodel.showDialog = true
                }){
                    Text(
                        text = "Open Dialog"
                    )
                }
            }
        }
    }

    if(viewmodel.showDialog){
        LogoutDialog { viewmodel.showDialog = false }
    }
}