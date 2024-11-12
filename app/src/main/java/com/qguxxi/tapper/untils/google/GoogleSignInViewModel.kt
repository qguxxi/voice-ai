package com.qguxxi.tapper.untils.google

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.qguxxi.tapper.R


@Suppress("DEPRECATION")
class GoogleSignInViewModel(application: Application) : AndroidViewModel(application) {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val googleSignInClient: GoogleSignInClient by lazy {
        GoogleSignIn.getClient(
            application,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(application.getString(R.string.your_web_client_id))
                .requestEmail()
                .build()
        )
    }

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> get() = _isLoggedIn

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    init {
        // Kiểm tra nếu người dùng đã đăng nhập
        _isLoggedIn.value = auth.currentUser != null
    }

    fun signInIntent(): Intent = googleSignInClient.signInIntent

    fun handleSignInResult(data: Intent?) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        try {
            val account = task.getResult(ApiException::class.java)
            account?.idToken?.let { firebaseAuthWithGoogle(it) }
        } catch (e: ApiException) {
            _isLoggedIn.value = false
            _error.value = "Đăng nhập thất bại: ${e.localizedMessage}"
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _isLoggedIn.value = true
                    _error.value = null
                } else {
                    _isLoggedIn.value = false
                    _error.value = "Xác thực với Firebase thất bại."
                }
            }
    }

    fun signOut() {
        auth.signOut()
        googleSignInClient.signOut()
        _isLoggedIn.value = false
    }
}
