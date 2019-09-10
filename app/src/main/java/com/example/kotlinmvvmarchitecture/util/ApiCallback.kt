package com.example.kotlinmvvmarchitecture.util

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import util.Utility
import java.util.*

open class ApiCallback : Callback<Objects> {
    val TAG: String = ApiCallback::class.java.simpleName
    override fun onFailure(call: Call<Objects>, t: Throwable) {
        Utility.LogI(TAG,"Failure: ${t.message!!}")
    }

    override fun onResponse(call: Call<Objects>, response: Response<Objects>) {
        Utility.LogI(TAG,"API Call ${call.request()}")
        Utility.LogI(TAG,"Response: ${response.message()}")
    }
}