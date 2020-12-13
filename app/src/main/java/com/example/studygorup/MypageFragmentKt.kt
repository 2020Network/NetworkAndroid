package com.example.studygorup

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.studygorup.API.RetrofitHelper
import com.example.studygorup.DTO.*
import kotlinx.android.synthetic.main.fragment_mypage_kt.*
import kotlinx.android.synthetic.main.fragment_mypage_kt.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MypageFragmentKt : Fragment() {
    var arrayList = ArrayList<MyGroup>()
    private var root : View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_mypage_kt, container, false)
        setList()
        myInfo()

        root!!.myJoinGroup.setOnClickListener {
            val intent = Intent(context!!,MyJoinGroupActivity::class.java)
            intent.putExtra("userID",arguments!!.getInt("userID",0))
            startActivity(intent)
        }

        root!!.btnEditProfile.setOnClickListener {
            val intent = Intent(context!!,ProfileEditActivity::class.java)
            intent.putExtra("userID",arguments!!.getInt("userID", 0))
            intent.putExtra("userName",textName.text.toString())
            intent.putExtra("userAge",textAge.text.toString())
            startActivity(intent)
        }
        return root
    }
    override fun onResume() {
        super.onResume()
        setList()
    }
    fun myInfo() {
        val userID = arguments!!.getInt("userID", 0)
        RetrofitHelper().getUserAPI().getUser(userID).enqueue(object : Callback<ResponsemyUser> {
            override fun onResponse(
                call: Call<ResponsemyUser>,
                response: Response<ResponsemyUser>
            ) {
                textImage.text = response.body()!!.userInfo[0].UserName!!.substring(0,1)
                textName.text = response.body()!!.userInfo[0].UserName
                textAge.text = response.body()!!.userInfo[0].Age

                textGender.text = response.body()!!.userInfo[0].Gender
                textField.text = response.body()!!.userInfo[0].StudyField
            }

            override fun onFailure(call: Call<ResponsemyUser>, t: Throwable) {

            }

        })

    }
    fun setList(){
        val userID = arguments!!.getInt("userID", 0)
        RetrofitHelper().getGroupAPI().mygroup(userID).enqueue(object : Callback<ResponseMygroup>{
            override fun onResponse(call: Call<ResponseMygroup>, response: Response<ResponseMygroup>) {
                Log.d("userID",response.body()!!.groupInfo.toString())
                if(response.isSuccessful){

                    arrayList = response.body()!!.groupInfo
                    root!!.myGroupList.adapter = MyGroupAdapterKt(context!!,arrayList)

                    root!!.myGroupList.setOnItemClickListener { adapterView, view, i, l ->

                        val intent = Intent(context, PostContentActivity2::class.java)
                        intent.putExtra("groupID",response.body()!!.groupInfo[i].GroupID)
                        intent.putExtra("groupTitle",response.body()!!.groupInfo[i].Title)
                        intent.putExtra("groupContent",response.body()!!.groupInfo[i].Content)
                        intent.putExtra("groupAge1",response.body()!!.groupInfo[i].Age1)
                        intent.putExtra("groupLocation",response.body()!!.groupInfo[i].Location)
                        intent.putExtra("groupAge2",response.body()!!.groupInfo[i].Age2)
                        startActivity(intent)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseMygroup>, t: Throwable) {

            }

        })
    }
}