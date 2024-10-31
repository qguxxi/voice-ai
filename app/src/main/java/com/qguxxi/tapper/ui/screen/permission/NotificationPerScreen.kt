package com.qguxxi.tapper.ui.screen.permission

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.qguxxi.tapper.R
import com.qguxxi.tapper.ui.components.button.PermissionButton
import com.qguxxi.tapper.ui.components.under.PrivacyPolicy
import com.qguxxi.tapper.ui.theme.figmaTypography
import com.qguxxi.tapper.untils.permission.requestNotificationPermission

@Composable
fun NotificationPerScreen(
    activity: Activity,
    navController : NavController,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFDBDBDB))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(3f))
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.bumel_1),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.weight(5f))
            Text(text = "Quick Share with NFC", style = figmaTypography.bodyMedium)
            Text(text = "Quick Scan with QR Code", style = figmaTypography.labelLarge)
            Spacer(modifier = Modifier.weight(5f))
            PermissionButton(
                permClick = { requestNotificationPermission(activity) },
                idIcon = R.drawable.notification,
                idString = R.string.notification)
            PrivacyPolicy(
                privacyOnClick = { /*TODO*/ },
                termServiceOnClick = { /*TODO*/ },
                stringIdRes = R.string.notification_permission,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
private fun NotificationPreview() {
}