package com.example.athena

import android.content.Intent
import android.os.Bundle
import android.telephony.SmsManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.athena.ui.theme.AthenaTheme


class PasscodeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sendBroadcast(location("start logger"))

        val smsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(
            "+00000000000",
            null,
            "I might be in danger. Here's my location: https://ulogger.lima.zone/#111",
            null,
            null
        )

        setContent {
            AthenaTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Your location is being sent. Enter passcode to turn off:",
                        textAlign = TextAlign.Center,
                    )
                    PasswordTextField()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AthenaTheme {
        Greeting("Android")
    }
}

@Composable
fun PasswordTextField() {
    // Grabbing context before entering layout
    val mContext = LocalContext.current

    var password by rememberSaveable { mutableStateOf("") }
    TextField(
        value = password,
        onValueChange = {
            password = it
            if (password == "1234") {
                val intent = Intent(mContext, MainActivity::class.java)
                mContext.startActivity(intent)
            }
        },
        label = { Text("Enter passcode") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
    )
}
