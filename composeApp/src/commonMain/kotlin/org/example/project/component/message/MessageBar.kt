package org.example.project.component.message

import Notify
import androidx.compose.runtime.Composable
import org.koin.core.logger.MESSAGE

@Composable
fun MessageBar(message: String){
    Notify(message= message, duration=NotificationDuration.SHORT)
}