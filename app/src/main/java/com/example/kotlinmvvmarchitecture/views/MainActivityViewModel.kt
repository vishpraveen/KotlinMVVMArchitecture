package com.example.kotlinmvvmarchitecture.views

import androidx.lifecycle.MutableLiveData
import com.example.kotlinmvvmarchitecture.api.ApiRepositories
import com.example.kotlinmvvmarchitecture.models.Item
import com.example.kotlinmvvmarchitecture.util.BaseViewModel
import util.Utility

class MainActivityViewModel: BaseViewModel() {
    val TAG = MainActivityViewModel::class.java.simpleName
    var userQuery: MutableLiveData<String> = MutableLiveData()

    var repoList : MutableLiveData<Item> = MutableLiveData()

    fun fetchRepoList(): MutableLiveData<Item>{
        val repo = ApiRepositories()
        Utility.LogI(TAG, userQuery.value!!)
        repoList = repo.getRepoListApi(userQuery.value!!)
        return repoList
    }

}