package com.qguxxi.tapper.ui.screen.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qguxxi.tapper.R
import com.qguxxi.tapper.ui.components.button.GoogleButton
import com.qguxxi.tapper.ui.components.under.PrivacyPolicy
import com.qguxxi.tapper.ui.theme.figmaTypography

@Composable
fun SignInScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFF0DBDBDB))
            .fillMaxSize()) {
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.logo_main),
            contentDescription = "logo",
            tint = Color.Unspecified,
            modifier = Modifier
                .padding(vertical = 32.dp)
                .align(Alignment.CenterHorizontally)
            )
        Spacer(modifier = Modifier.weight(5f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Welcome to", style = figmaTypography.displayMedium)
            Text(text = "Tapper", style = figmaTypography.displayLarge)
        }
        Spacer(modifier = Modifier.weight(5f))
        GoogleButton(onClick = { /*TODO*/ })
        PrivacyPolicy(
            privacyOnClick = { /*TODO*/ },
            termServiceOnClick = { /*TODO*/ },
            stringIdRes = R.string.google_permission,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    MaterialTheme {
        Surface {
            SignInScreen()

        }
    }
}