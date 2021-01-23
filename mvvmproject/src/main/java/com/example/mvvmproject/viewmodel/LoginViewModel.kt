package com.example.mvvmproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mvvmproject.base.BaseViewModel
import com.example.mvvmproject.netwrok.DTO.Login
import com.example.mvvmproject.netwrok.DTO.Responselogin
import com.example.mvvmproject.netwrok.api.UserAPI
import com.example.mvvmproject.widget.SingleLiveEvent
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginViewModel (private val service : UserAPI) : BaseViewModel() {

    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onFailEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Unit>()
    val onSignUpEvent = SingleLiveEvent<Unit>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun checkLogin(){
        Log.d("TEST", "T")
        if (email.value != null && password.value != null) {
            if (email.value!!.isNotEmpty() && password.value!!.isNotEmpty()) {
                service.login(Login( userEmail = email.value.toString() ,userPwd = password.value.toString())).enqueue(object : retrofit2.Callback<Responselogin>{
                    override fun onResponse(
                        call: Call<Responselogin>,
                        response: Response<Responselogin>
                    ) {
                        if (response.isSuccessful){
                            onSuccessEvent.call()
                        }
                        else{
                            Log.d("LoginError",response.message())
                            onFailEvent.call()
                        }
                    }

                    override fun onFailure(call: Call<Responselogin>, t: Throwable) {
                        Log.d("LoginError",t.toString() )
                        onFailEvent.call()
                    }

                })
            }
            else {
                onErrorEvent.call()
            }
        } else {
            onErrorEvent.call()
        }
    }
    fun SignUp() {
        onSignUpEvent.call()
    }
}