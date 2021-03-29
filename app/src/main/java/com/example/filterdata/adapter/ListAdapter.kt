package com.example.filterdata.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.filterdata.R
import com.example.filterdata.databinding.SingleRowBinding
import com.example.filterdata.model.UserData
import java.util.*
import kotlin.collections.ArrayList


class ListAdapter(private val list: ArrayList<UserData>) : RecyclerView.Adapter<ListAdapter.ViewHolder>(){


    class ViewHolder(item: SingleRowBinding) : RecyclerView.ViewHolder(item.root) {
        val name = item.TextViewUserName
        val age = item.TextViewAge
        val salary = item.TextViewSalary
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.single_row,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        setData(data, holder)
    }

    override fun getItemCount() = list.size

    @SuppressLint("SetTextI18n")
    private fun setData(data: UserData, holder: ViewHolder){
        holder.name.text = "Name: ${data.name.capitalize(Locale.ROOT)}"
        holder.age.text =  "Age: ${data.age}"
        holder.salary.text = "Salary ${data.salary}"
    }


}