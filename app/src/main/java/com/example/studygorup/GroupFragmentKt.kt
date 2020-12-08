package com.example.studygorup

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studygorup.API.RetrofitHelper
import com.example.studygorup.DTO.Responsegroup
import kotlinx.android.synthetic.main.fragment_group_kt.view.*
import retrofit2.Call
import retrofit2.Response

class GroupFragmentKt : Fragment() {
    var arrayList = ArrayList<Responsegroup>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_group_kt, container, false)

        view.makeGroup.setOnClickListener {
            val intent = Intent(context,GroupContentsActivity::class.java)
            startActivity(intent)
        }
        return  view
        setList()
    }
    override fun onResume() {
        super.onResume()
        setList()
    }
    fun setList(){
        RetrofitHelper().getGroupAPI().allgroup().enqueue(object : retrofit2.Callback<Responsegroup>{
            override fun onResponse(call: Call<Responsegroup>, response: Response<Responsegroup>) {
                arrayList = (response.body() as ArrayList<Responsegroup>?)!!

                view!!.recycler.adapter = GroupAdapterKt(context!!, arrayList)
            }

            override fun onFailure(call: Call<Responsegroup>, t: Throwable) {
            }

        })
    }

}