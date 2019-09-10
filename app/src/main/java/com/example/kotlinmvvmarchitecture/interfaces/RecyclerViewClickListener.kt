package com.example.kotlinmvvmarchitecture.interfaces

interface RecyclerViewClickListener {
    fun onClick(where: EnumClick,data:Any,position:Int)
}