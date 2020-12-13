package com.example.studygorup

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.studygorup.API.RetrofitHelper
import com.example.studygorup.DTO.Group
import com.example.studygorup.DTO.MyGroup
import com.example.studygorup.DTO.MyJoinGroup
import kotlinx.android.synthetic.main.activity_group_contents.view.*
import kotlinx.android.synthetic.main.group_row.view.*
import kotlinx.android.synthetic.main.group_row.view.textContents
import kotlinx.android.synthetic.main.group_row.view.textTag
import kotlinx.android.synthetic.main.group_row.view.textTitle
import kotlinx.android.synthetic.main.mypage_chat_row.view.*
import kotlinx.android.synthetic.main.mypage_group_row.view.*

class MyGroupAdapterKt(context: Context, dataList: ArrayList<MyGroup>) : BaseAdapter(){
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
        val converterView = inflater.inflate(R.layout.mypage_group_row,p2, false)

        converterView.textTitle1.text = mDataList[p0].Title
        converterView.textContents1.text = mDataList[p0].Content
        converterView.textTag1.text = "#남은인원:${mDataList[p0].People}"

        return converterView
    }


}