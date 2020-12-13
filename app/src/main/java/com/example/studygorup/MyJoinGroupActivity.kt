package com.example.studygorup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.studygorup.API.RetrofitHelper
import com.example.studygorup.DTO.MyGroup
import com.example.studygorup.DTO.MyJoinGroup
import com.example.studygorup.DTO.ResponseJoinGroup
import com.example.studygorup.DTO.ResponseMygroup
import kotlinx.android.synthetic.main.activity_my_join_group.*
import kotlinx.android.synthetic.main.fragment_mypage_kt.*
import kotlinx.android.synthetic.main.fragment_mypage_kt.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyJoinGroupActivity : AppCompatActivity() {
    var arrayList = ArrayList<MyJoinGroup>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_join_group)

        setList()
    }

    override fun onResume() {
        super.onResume()
        setList()
    }
    fun setList(){
        val userID = intent.getIntExtra("userID",0)
        RetrofitHelper().getGroupAPI().joinGroup(userID).enqueue(object : Callback<ResponseJoinGroup> {
            override fun onResponse(call: Call<ResponseJoinGroup>, response: Response<ResponseJoinGroup>) {
                Log.d("userID",response.body()!!.groupInfo.toString())
                if(response.isSuccessful){

                    arrayList = response.body()!!.groupInfo
                    Log.d("TEST", arrayList.toString())
                    joinList.adapter = MyJoinAdapterKt(this@MyJoinGroupActivity,arrayList)

                }
            }

            override fun onFailure(call: Call<ResponseJoinGroup>, t: Throwable) {

            }

        })
    }
}