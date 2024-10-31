package com.qguxxi.tapper.ui.screen.permission

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.qguxxi.tapper.R
import com.qguxxi.tapper.ui.components.button.PermissionButton
import com.qguxxi.tapper.ui.components.under.PrivacyPolicy
import com.qguxxi.tapper.ui.theme.figmaTypography

@Composable
fun NfcPerScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier =  Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(3f))
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.block_1),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.weight(5f))
            Text(text = "Quick Share with NFC", style = figmaTypography.bodyMedium)
            Text(text = "Quick Scan with QR Code", style = figmaTypography.labelLarge)
            Spacer(modifier = Modifier.weight(5f))
            PermissionButton(
                permClick = { /*TODO*/ },
                idIcon = R.drawable.nfc,
                idString = R.string.nfc_per,
                modifier = Modifier.align(Alignment.CenterHorizontally).width(320.dp),
                )
            PrivacyPolicy(
                privacyOnClick = { /*TODO*/ },
                termServiceOnClick = { /*TODO*/ },
                stringIdRes = R.string.nfc_permission,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
private fun NfcPreview() {
    NfcPerScreen()
}