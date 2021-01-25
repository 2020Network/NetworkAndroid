package com.example.mvvmproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mvvmproject.R
import com.example.mvvmproject.base.BaseActivity
import com.example.mvvmproject.databinding.ActivityLoginBinding
import com.example.mvvmproject.viewmodel.LoginViewModel
import com.example.mvvmproject.widget.extension.longToastMessage
import com.example.mvvmproject.widget.extension.shortToastMessage
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginActivity :BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    override val resource: Int
        get() = R.layout.activity_login
    override val viewModel: LoginViewModel
        get() = getViewModel(LoginViewModel::class)

    override fun init() {

    }

    override fun observerViewModel() {
        with(viewModel){
            onSuccessEvent.observe(this@LoginActivity, {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            })
            onFailEvent.observe(this@LoginActivity, {
                shortToastMessage("이메일 혹은 비밀번호가 맞지않습니다.")
            })
            onErrorEvent.observe(this@LoginActivity, {
                shortToastMessage("로그인 에러 및 서버 오류")
            })

            onSignUpEvent.observe(this@LoginActivity, {
                val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                startActivity(intent)
                finish()
            })
        }
    }

}