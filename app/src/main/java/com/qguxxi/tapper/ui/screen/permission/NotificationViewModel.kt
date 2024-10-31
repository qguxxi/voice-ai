package com.qguxxi.tapper.ui.screen.permission

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel

class NotificationViewModel : ViewModel() {
    fun requestNotificationPermission(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    context, android.Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    context as Activity, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 1
                )
            } else {
                // Quyền đã được cấp, có thể tiếp tục xử lý thông báo
                Toast.makeText(context, "Quyền thông báo đã được cấp", Toast.LENGTH_SHORT).show()
            }
        } else {
            // Không cần xin quyền cho các phiên bản Android thấp hơn
            Toast.makeText(
                context,
                "Quyền không cần thiết trên phiên bản Android này",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}