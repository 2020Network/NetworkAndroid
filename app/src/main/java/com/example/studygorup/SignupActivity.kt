package com.example.studygorup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.studygorup.API.RetrofitHelper
import com.example.studygorup.DTO.Responsesign
import com.example.studygorup.DTO.Signup
import kotlinx.android.synthetic.main.activity_signup.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        Sign()

        val spinner = findViewById(R.id.spinner) as Spinner
        val adapter = ArrayAdapter.createFromResource(this, R.array.field_array, android.R.layout.simple_spinner_item)


        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                 spinner.selectedItem.toString()
            }
        }

    }
    fun Sign(){
        button.setOnClickListener {
            RetrofitHelper().getUserAPI().signUp(Signup(editId.text.toString(), editPW.text.toString(), editPW2.text.toString(), editPW4.text.toString(), "" ,spinner.selectedItem.toString())).enqueue(
                object : Callback<Responsesign> {
                    override fun onResponse(call: Call<Responsesign>, response: Response<Responsesign>) {
                        when(response.code()){
                            200 -> {
                                val intent = Intent(this@SignupActivity,LoginActivity::class.java)
                                startActivity(intent)
                            }
                            403 -> {
                                Toast.makeText(this@SignupActivity,"아이디가 중복입니다.",Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    override fun onFailure(call: Call<Responsesign>, t: Throwable) {

                        Toast.makeText(this@SignupActivity,"서버 에러", Toast.LENGTH_SHORT).show()
                    }

                }
            )
        }
    }

}