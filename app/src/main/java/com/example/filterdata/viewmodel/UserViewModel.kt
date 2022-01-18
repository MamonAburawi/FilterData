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

    private val _users = MutableLiveData<ArrayList<UserData>>()
    val users : LiveData<ArrayList<UserData>> = _users

    private val _resultsCount = MutableLiveData<Int>()
    val resultCount: LiveData<Int> = _resultsCount


    init {
        val data = repository.getData()
        _users.value = data
        _resultsCount.value = data.size
    }



     fun filterList(charSequence:String): ArrayList<UserData> {
         var filter = ArrayList<UserData>()
             val filterPattern = charSequence.trim()
             filter = if (filterPattern.isNotEmpty()){
                 _users.value!!.filter { it.name.contains(filterPattern) } as ArrayList<UserData>
             }else{
                 repository.getData()
             }
         _resultsCount.value = filter.size
         return filter
    }


    override fun onCleared() {
        super.onCleared()

        viewModelScope.cancel()
    }


}


