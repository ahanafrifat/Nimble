package com.ahanaf.nimble.ui.login

import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahanaf.nimble.common.ResponseModel
import com.ahanaf.nimble.util.Validator

class LoginViewModel : ViewModel() {

    val message = MutableLiveData<String>()
    val refresh = MutableLiveData<Boolean>()
    val isSuccessFul = MutableLiveData<Boolean>()

    fun validateEmail(email: EditText):Boolean{
//        return true
        return Validator.isValidEmail(email)
    }

    fun validatePassword(password: EditText):Boolean{
//        return true
        return Validator.isValidPassword(password)
    }

    fun login(email:String, password:String){
        refresh.postValue(false)
    }

    private fun onSuccess() {
        isSuccessFul.postValue(true)
//        message.postValue(response.message)
    }

    private fun onFailure(error: ResponseModel) {
        isSuccessFul.postValue(true)
        message.postValue(error.message)
    }
}