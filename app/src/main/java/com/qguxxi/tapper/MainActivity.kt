package com.qguxxi.tapper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.qguxxi.tapper.ui.screen.permission.NotificationPerScreen
import com.qguxxi.tapper.ui.theme.TapperTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TapperTheme {
                TapperApp()
            }
        }
    }
}

