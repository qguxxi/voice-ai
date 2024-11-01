package com.qguxxi.tapper.untils.permission

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import com.qguxxi.tapper.navigation.Screen

const val STORAGE_PERMISSION_REQUEST_CODE = 1001

fun checkAndRequestReadPermission(navController: NavController, activity: Activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        if (ActivityCompat.checkSelfPermission(
                activity,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Quyền đã được cấp
            navController.navigate(Screen.PREHOME.name) {
                popUpTo(Screen.READEXTERNAL.name) {
                    inclusive = true
                }
            }
        } else {
            // Chưa có quyền, yêu cầu quyền
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                STORAGE_PERMISSION_REQUEST_CODE
            )
            navController.navigate(Screen.PREHOME.name) {
                popUpTo(Screen.READEXTERNAL.name) {
                    inclusive = true
                }
            }

        }
    } else {
        navController.navigate(Screen.PREHOME.name) {
            popUpTo(Screen.READEXTERNAL.name) {
                inclusive = true
            }
        }
        // Trường hợp không cần quyền trên Android < 13
        Toast.makeText(activity, "Không cần yêu cầu quyền trên Android < 13", Toast.LENGTH_SHORT).show()
    }
}