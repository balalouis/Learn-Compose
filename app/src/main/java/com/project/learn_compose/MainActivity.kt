package com.project.learn_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val message = Message(author = "Arun", body = "Hello World")
        setContent {
            GreetingCard(message)
        }
    }
}

@Composable
fun GreetingCard(msg:Message) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.baby_yellow),
            contentDescription = "Contact Profile Picture"
        )

        Column {
            Text(text = "Hello ${msg.author}!")
            Text(text = msg.author)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGreetingCard() {
    GreetingCard(Message(author = "Arun", body = "Hello World"))
}

data class Message(val author:String, val body:String)