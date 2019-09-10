package com.example.kotlinmvvmarchitecture.api

import androidx.lifecycle.MutableLiveData
import com.example.kotlinmvvmarchitecture.models.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import util.Utility

class ApiRepositories {
    val TAG = ApiRepositories::class.java.simpleName
    var items: MutableLiveData<Item> = MutableLiveData()

    fun getRepoListApi(query: String): MutableLiveData<Item>{
        val item = Item()
        ApiClient.instance.getRepoList(query)
            .enqueue(object: Callback<Item>{
                override fun onFailure(call: Call<Item>, t: Throwable) {
                    if (t.message!!.toString().equals("Unable to resolve host \"api.github.com\": No address associated with hostname",true)){
                        item.status = 500
                        item.message = "No Internet Available."
                        items.value = item
                    }else{
                        item.status = 404
                        item.message = t.message!!
                        items.value = item
                    }
                }

                override fun onResponse(call: Call<Item>, response: Response<Item>) {
                    Utility.showCalledApi(TAG,call.request())
                    if (response.isSuccessful){
                        if (response.body()!=null){
                            item.status = 200
                            item.message = response.message()
                            item.itemsList = response.body()?.itemsList
                            items.value = item
                        }else{
                            item.status = 400
                            item.message = response.message()
                            items.value = item
                        }
                    }else{
                        item.status = 402
                        item.message = response.message()
                        items.value = item
                    }
                }
            })

        return items
    }
}