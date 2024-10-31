package com.qguxxi.tapper.untils.permission

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat


const val NOTIFICATION_PERMISSION_REQUEST_CODE = 1001

fun requestNotificationPermission(activity: Activity) {
    if (ActivityCompat.checkSelfPermission(activity,Manifest.permission.POST_NOTIFICATIONS) !=PackageManager.PERMISSION_GRANTED ){
        ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.POST_NOTIFICATIONS),NOTIFICATION_PERMISSION_REQUEST_CODE)
    }
}
