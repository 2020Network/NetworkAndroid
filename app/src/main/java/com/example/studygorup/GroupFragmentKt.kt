package com.example.studygorup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studygorup.API.RetrofitHelper
import com.example.studygorup.DTO.Group
import com.example.studygorup.DTO.Responsegroup
import kotlinx.android.synthetic.main.fragment_group_kt.view.*
import retrofit2.Call
import retrofit2.Response

class GroupFragmentKt : Fragment() {
    var arrayList = ArrayList<Group>()
    private var root : View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_group_kt, container, false)
        val userID = arguments!!.getInt("userID",0)
        setList()
        root!!.makeGroup.setOnClickListener {
            val intent = Intent(context,PostContentActivity::class.java)
            intent.putExtra("userID",userID)
            startActivity(intent)
        }
        return  root
    }
    override fun onResume() {
        super.onResume()
        setList()
    }
    fun setList(){
        RetrofitHelper().getGroupAPI().allgroup().enqueue(object : retrofit2.Callback<Responsegroup>{
            override fun onResponse(call: Call<Responsegroup>, response: Response<Responsegroup>) {
                if(response.isSuccessful){

                    arrayList = response.body()!!.groupInfo
                    Log.d("LIST", response.body().toString())
                    root!!.recycler.adapter = GroupAdapterKt(context!!, arrayList)
                }
            }

            override fun onFailure(call: Call<Responsegroup>, t: Throwable) {
            }

        })
    }

}