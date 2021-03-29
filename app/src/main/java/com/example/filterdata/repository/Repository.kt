package com.example.filterdata.repository

import com.example.filterdata.database.FakeDataBase
import com.example.filterdata.model.UserData

class Repository() {
    private val database = FakeDataBase()

    fun getData() = database.getData()
}