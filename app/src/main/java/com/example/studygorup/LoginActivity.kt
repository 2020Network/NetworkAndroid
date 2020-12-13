package com.example.studygorup

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.studygorup.API.RetrofitHelper
import com.example.studygorup.DTO.Login
import com.example.studygorup.DTO.Responselogin
import com.example.studygorup.DTO.Responsesign
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button.setOnClickListener {
            RetrofitHelper().getUserAPI().login(Login(editId.text.toString(), editPW.text.toString())).enqueue(object : Callback<Responselogin>{
                override fun onResponse(call: Call<Responselogin>, response: Response<Responselogin>) {
                    when(response.code()){
                        200 -> {
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            Log.d("TEST", response.body()!!.user.toString())
                            intent.putExtra("userID", response.body()!!.user)
                            intent.putExtra("userName",response.body()!!.userName)
                            startActivity(intent)
                            finish()
                        }
                        204 -> {
                            Toast.makeText(this@LoginActivity,response.body()!!.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(call: Call<Responselogin>, t: Throwable) {
                    Log.e("error",t.toString())
                    Toast.makeText(this@LoginActivity,"서버 에러", Toast.LENGTH_SHORT).show()
                }

            })
        }

        textSignup.setOnClickListener {
            val intent = Intent(this@LoginActivity,SignupActivity::class.java)
            startActivity(intent)
        }

    }
}