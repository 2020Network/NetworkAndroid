package com.example.mvvmproject.viewmodel

import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.lifecycle.MutableLiveData
import com.example.mvvmproject.base.BaseViewModel
import com.example.mvvmproject.netwrok.api.UserAPI
import com.example.mvvmproject.widget.SingleLiveEvent

class SignUpViewModel(private val service : UserAPI) : BaseViewModel() {
    val onSuccessEvent = SingleLiveEvent<Unit>()
    val onFailEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Unit>()
    val onSignUpEvent = SingleLiveEvent<Unit>()

    val name = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val password2 = MutableLiveData<String>()
    val age = MutableLiveData<String>()
    val gender = MutableLiveData<RadioGroup>()
    val clicksListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            parent?.getItemAtPosition(position) as String
        }
    }

    fun checkSign(){
        Log.d("TEST", "T")

    }
}