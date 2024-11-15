package com.qguxxi.synthvoice.untils.permission

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import com.qguxxi.synthvoice.navigation.Screen


const val NOTIFICATION_PERMISSION_REQUEST_CODE = 1001

object NotificationPermission {
    fun checkAndRequestNotificationPermission(navController : NavController , activity : Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(
                    activity ,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                // Quyền đã được cấp
                navController.navigate(Screen.CAMERAPER.name) {
                    popUpTo(Screen.NOTIFICATION.name) {
                        inclusive = true
                    }
                }

            } else {
                // Chưa có quyền, yêu cầu quyền
                ActivityCompat.requestPermissions(
                    activity ,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS) ,
                    NOTIFICATION_PERMISSION_REQUEST_CODE
                )
                navController.navigate(Screen.CAMERAPER.name) {
                    popUpTo(Screen.NOTIFICATION.name) {
                        inclusive = true
                    }
                }
            }
        } else {
            // Trường hợp không cần quyền trên Android < 13
            Toast.makeText(activity , "Không cần yêu cầu quyền trên Android < 13" , Toast.LENGTH_SHORT).show()
        }
    }

}
