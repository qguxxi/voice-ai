package com.qguxxi.tapper.ui.screen.signin

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.qguxxi.tapper.R
import com.qguxxi.tapper.navigation.Screen
import com.qguxxi.tapper.ui.components.button.GoogleButton
import com.qguxxi.tapper.ui.components.under.PrivacyPolicy
import com.qguxxi.tapper.ui.theme.figmaTypography
import com.qguxxi.tapper.untils.google.GoogleSignInViewModel

@Composable
fun SignInScreen(navController: NavController,viewModel: GoogleSignInViewModel) {

    // Tạo ActivityResultLauncher để xử lý kết quả đăng nhập
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            viewModel.handleSignInResult(result.data)
            navController.navigate(Screen.NOTIFICATION.name)
        } else {
            // Handle error
        }
    }
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
        GoogleButton(onClick = { launcher.launch(viewModel.signInIntent()) })
        PrivacyPolicy(
            privacyOnClick = { /*TODO*/ },
            termServiceOnClick = { /*TODO*/ },
            stringIdRes = R.string.google_permission,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }
}
