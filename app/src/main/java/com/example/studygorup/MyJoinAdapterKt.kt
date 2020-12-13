package com.example.studygorup

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.studygorup.API.RetrofitHelper
import com.example.studygorup.DTO.Group
import com.example.studygorup.DTO.MyJoinGroup
import com.example.studygorup.DTO.ResponseMygroup
import kotlinx.android.synthetic.main.group_row.view.*
import kotlinx.android.synthetic.main.group_row.view.textContents
import kotlinx.android.synthetic.main.group_row.view.textTitle
import kotlinx.android.synthetic.main.notice_row.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyJoinAdapterKt(context: Context, dataList : ArrayList<MyJoinGroup>) : BaseAdapter(){
    val mContext = context
    val mDataList = dataList
    override fun getCount(): Int {
        return mDataList.size
    }

    override fun getItem(p0: Int): Any {
        return mDataList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = LayoutInflater.from(mContext)
        val converterView = inflater.inflate(R.layout.notice_row, p2, false)
        Log.d("TEST", mDataList[p0].toString())
        RetrofitHelper().getGroupAPI().yougroup(mDataList[p0].groupID).enqueue(object :
            Callback<ResponseMygroup> {
            override fun onResponse(
                call: Call<ResponseMygroup>,
                response: Response<ResponseMygroup>
            ) {
                if(response.body()!!.code == 200) {
                    converterView.textTitle.text = response.body()!!.groupInfo[0].Title
                    converterView.textContentsJoin.text = response.body()!!.groupInfo[0].Content
                }
            }

            override fun onFailure(call: Call<ResponseMygroup>, t: Throwable) {
            }

        })


        return converterView
    }
}