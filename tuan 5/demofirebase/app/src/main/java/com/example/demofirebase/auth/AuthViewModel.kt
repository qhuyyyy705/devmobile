package com.example.demofirebase.auth


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.demofirebase.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider

class AuthViewModel : ViewModel() {

    private val auth = FirebaseAuth.getInstance()
    var authState by mutableStateOf<AuthState>(AuthState.Initial)
        private set

    val currentUser: FirebaseUser?
        get() = auth.currentUser

    fun getGoogleSignInClient(context: Context): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        return GoogleSignIn.getClient(context as Activity, gso)
    }


    fun handleGoogleSignInResult(data: Intent?) {
        authState = AuthState.Loading
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        try {
            val account = task.getResult(ApiException::class.java)
            val idToken = account?.idToken

            if (idToken != null) {
                firebaseAuthWithGoogle(idToken)
            } else {
                Log.e("AuthViewModel", "ID Token is missing.")
                authState = AuthState.Error("ID Token is missing.")
            }
        } catch (e: ApiException) {
            Log.e("AuthViewModel", "Google Sign-in failed", e)
            authState = AuthState.Error("Google Sign-in failed: ${e.statusCode}")
        }
    }

    fun resetState() {
        authState = AuthState.Initial
    }


    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sau khi đăng nhập thành công, currentUser sẽ tự động được cập nhật
                    authState = AuthState.Success
                } else {
                    Log.w("AuthViewModel", "Firebase Auth failed", task.exception)
                    authState = AuthState.Error(task.exception?.localizedMessage ?: "Firebase Auth failed.")
                }
            }
    }
}