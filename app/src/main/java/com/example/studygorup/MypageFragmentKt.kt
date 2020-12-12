package com.example.studygorup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.studygorup.API.RetrofitHelper
import com.example.studygorup.DTO.ResponsemyUser
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
        var viewPager: ViewPager? = null
        val view = inflater.inflate(R.layout.fragment_mypage_kt, container, false)
        val userID = arguments!!.getInt("userID", 0)

        viewPager = view.findViewById(R.id.container)
        setupViewPager(viewPager)
        myInfo()
        return view
    }

    fun myInfo() {
        val userID = arguments!!.getInt("userID", 0)
        RetrofitHelper().getUserAPI().getUser(userID).enqueue(object : Callback<ResponsemyUser> {
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

    fun setupViewPager(viewPager: ViewPager) {
        val adapter = SectionPageAdapter(childFragmentManager)
        adapter.addFragment(MypageGroupFragment(), "스터디그룹")
        adapter.addFragment(MypageChatFragment(), "채팅")
        viewPager.adapter = adapter
    }
}