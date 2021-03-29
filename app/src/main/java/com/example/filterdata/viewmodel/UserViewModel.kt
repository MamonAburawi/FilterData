package com.example.filterdata.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filterdata.model.UserData
import com.example.filterdata.repository.Repository
import kotlinx.coroutines.*


class UserViewModel(): ViewModel() {

    private val repository = Repository()


    private val viewModelScope = CoroutineScope(Dispatchers.Main + Job())



    private val _filterList = MutableLiveData<ArrayList<UserData>>()
    val filterList : LiveData<ArrayList<UserData>> = _filterList


    init {
        _filterList.value = repository.getData()
    }



     fun filterList(charSequence:String): ArrayList<UserData> {
         var filter = ArrayList<UserData>()
             val filterPattern = charSequence.trim()
             filter = if (filterPattern.isNotEmpty()){
                 _filterList.value!!.filter { it.name.contains(filterPattern) } as ArrayList<UserData>
             }else{
                 repository.getData()
             }
         return filter
    }


    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }


}


