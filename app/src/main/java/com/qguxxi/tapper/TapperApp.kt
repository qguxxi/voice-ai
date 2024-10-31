package com.qguxxi.tapper

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.qguxxi.tapper.navigation.TapperNavHost

@Composable
fun TapperApp(activity: Activity) {
    TapperNavHost(activity)
}