package com.example.uthsmarttasks

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SharedViewModel : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _verificationCode = MutableStateFlow("")
    val verificationCode: StateFlow<String> = _verificationCode.asStateFlow()

    private val _newPassword = MutableStateFlow("")
    val newPassword: StateFlow<String> = _newPassword.asStateFlow()

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword: StateFlow<String> = _confirmPassword.asStateFlow()

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun updateVerificationCode(code: String) {
        _verificationCode.value = code
    }

    fun updateNewPassword(password: String) {
        _newPassword.value = password
    }

    fun updateConfirmPassword(password: String) {
        _confirmPassword.value = password
    }

    fun resetData() {
        _email.value = ""
        _verificationCode.value = ""
        _newPassword.value = ""
        _confirmPassword.value = ""
    }
}