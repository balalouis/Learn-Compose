package com.project.learn_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.learn_compose.ui.theme.LearnComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GreetingCard(Message(author = "Arun", body = "Hello World"))
                }
            }
        }
    }
}

@Composable
fun GreetingCard(msg:Message) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.baby_yellow),
            contentDescription = "Contact Profile Picture",
            modifier = Modifier
                .size(80.dp)
                .padding(5.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = "Hello ${msg.author}!",
                modifier = Modifier.padding(2.dp),
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = msg.author,
                    modifier = Modifier.padding(all=2.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGreetingCard() {
    LearnComposeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            GreetingCard(Message(author = "Arun", body = "Hello World"))
        }
    }
}

data class Message(val author:String, val body:String)