package com.example.studygorup

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.studygorup.DTO.Group
import com.example.studygorup.DTO.Responsegroup
import kotlinx.android.synthetic.main.group_row.view.*

class GroupAdapterKt(context: Context, dataList: ArrayList<Group>) : BaseAdapter(){
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
        val converterView = inflater.inflate(R.layout.group_row,p2, false)

        converterView.textTitle.text = mDataList[p0].Title
        converterView.textContents.text = mDataList[p0].Content
        converterView.textTag.text = "#${mDataList[p0].Age2}이상 #${mDataList[p0].Age1}미만 #${mDataList[p0].Gender} #${mDataList[p0].StudyField} #남은인원:${mDataList[p0].People.toInt()}"


        return converterView
    }

}