package com.example.filterdata.database

import com.example.filterdata.model.UserData

class FakeDataBase() {

    private val fakeDataBase = ArrayList<UserData>() // init list ..

    init {
        fakeDataBase.add(UserData("mohamed",20,1.000))
        fakeDataBase.add(UserData("ali",20,5.000))
        fakeDataBase.add(UserData("mohamed",52,1.000))
        fakeDataBase.add(UserData("ali",36,2.000))
        fakeDataBase.add(UserData("mohamed",20,1.000))
        fakeDataBase.add(UserData("mohamed",12,1.500))
        fakeDataBase.add(UserData("samer",20,6.500))
        fakeDataBase.add(UserData("ali",44,1.780))
        fakeDataBase.add(UserData("waled",47,2.000))
        fakeDataBase.add(UserData("ali",36,2.850))
        fakeDataBase.add(UserData("salem",32,1.000))
        fakeDataBase.add(UserData("salem",12,1.545))
        fakeDataBase.add(UserData("omar",12,6.500))
        fakeDataBase.add(UserData("waled",44,1.505))
        fakeDataBase.add(UserData("waled",41,2.000))
    }



    fun getData():ArrayList<UserData>{
        return fakeDataBase
    }


}