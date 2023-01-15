package com.example.athena

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.athena.ui.theme.AthenaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sendBroadcast(location("stop logger"))
        setContent {
            AthenaTheme {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    PanicButton()
                }
                Box(
                    contentAlignment = Alignment.BottomCenter,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    SettingsButton()
                }
            }
        }
    }
}

@Preview
@Composable
fun PanicButton() {
    // Grabbing context before entering layout
    val mContext = LocalContext.current
    Button(onClick = {
        val intent = Intent(mContext, PasscodeActivity::class.java)
        mContext.startActivity(intent)
    })
    {
        Text(stringResource(R.string.panic))
    }
}

@Preview
@Composable
fun SettingsButton() {
    // Grabbing context before entering layout
    val mContext = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            val intent = Intent(mContext, SettingsActivity::class.java)
            mContext.startActivity(intent)
        },
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        )
        )
        {
            Text(stringResource(R.string.settings))
        }
    }
}