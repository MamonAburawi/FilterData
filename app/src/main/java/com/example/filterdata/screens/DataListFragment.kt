package com.example.filterdata.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.filterdata.adapter.ListAdapter
import com.example.filterdata.R
import com.example.filterdata.model.UserData
import com.example.filterdata.databinding.FragmentListDataBinding
import com.example.filterdata.viewmodel.UserViewModel
import java.util.*
import kotlin.collections.ArrayList


@Suppress("ReplaceSizeZeroCheckWithIsEmpty")
@SuppressLint("SetTextI18n")
class DataListFragment : Fragment() {

    private lateinit var binding: FragmentListDataBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_data, container, false)


        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        binding.apply {

            /** live data **/
            viewModel.users.observe(viewLifecycleOwner, Observer { users ->
                updateListData(users) // for update recycle view
            })


            /** live data **/
            viewModel.resultCount.observe(viewLifecycleOwner, Observer { results->
                if (results != null){
                    resultsCount.text = "Results: $results"
                }
            })

            /** edit text **/
            search.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    updateListData(viewModel.filterList(charSequence.toString()))
                }

                override fun afterTextChanged(p0: Editable?) {}
            })




        }



        return binding.root
    }


    private fun updateListData(list : ArrayList<UserData>) {
        binding.recyclerView.adapter = ListAdapter(list)
    }







}