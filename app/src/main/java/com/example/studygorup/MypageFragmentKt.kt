package com.example.studygorup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import com.example.studygorup.API.RetrofitHelper
import com.example.studygorup.DTO.ResponsemyUser
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_mypage_kt.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MypageFragmentKt : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_mypage_kt, container, false)
        val userID = arguments!!.getInt("userID",0)
        myInfo()
        tab()
        return view
    }
    fun myInfo(){
        val userID = arguments!!.getInt("userID",0)
        RetrofitHelper().getUserAPI().getUser(userID).enqueue(object : Callback<ResponsemyUser>{
            override fun onResponse(
                call: Call<ResponsemyUser>,
                response: Response<ResponsemyUser>
            ) {
                textImage.text = response.body()!!.userInfo[0].UserName!!.substring(0)
                textName.text = response.body()!!.userInfo[0].UserName
                textAge.text = response.body()!!.userInfo[0].Age
                textGender.text = response.body()!!.userInfo[0].Gender
                textField.text = response.body()!!.userInfo[0].StudyField
            }

            override fun onFailure(call: Call<ResponsemyUser>, t: Throwable) {

            }

        })
    }
    fun tab(){
        val fragmentAdapter = FragmentAdapter(childFragmentManager)
        container.adapter = fragmentAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                if (tab != null){
                    container.currentItem = tab.position
                }
            }

        })
    }
}