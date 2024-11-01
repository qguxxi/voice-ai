package com.qguxxi.tapper.ui.screen.permission

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.qguxxi.tapper.MainActivity
import com.qguxxi.tapper.R
import com.qguxxi.tapper.ui.components.button.PermissionButton
import com.qguxxi.tapper.ui.components.under.PrivacyPolicy
import com.qguxxi.tapper.ui.theme.figmaTypography
import com.qguxxi.tapper.untils.permission.checkAndRequestReadPermission

@Composable
fun ReadExternalScreen(
    navController: NavController,
    activity: Activity
) {
    Surface(
        modifier =  Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(3f))
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.bumbel_3),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.weight(5f))
            Text(text = "Learn Quickly with AI", style = figmaTypography.bodyMedium)
            Text(text = "Improve Swiftly with Tapper", style = figmaTypography.labelLarge)
            Spacer(modifier = Modifier.weight(5f))
            PermissionButton(
                permClick = { checkAndRequestReadPermission(navController = navController,activity) },
                idIcon = R.drawable.folder,
                idString = R.string.read_per,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(300.dp)
            )
            PrivacyPolicy(
                privacyOnClick = { /*TODO*/ },
                termServiceOnClick = { /*TODO*/ },
                stringIdRes = R.string.camera_per,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
private fun ReadExternalScreenPreview() {
    ReadExternalScreen(navController = rememberNavController(), activity = MainActivity())
}