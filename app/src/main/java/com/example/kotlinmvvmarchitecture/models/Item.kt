package com.example.kotlinmvvmarchitecture.models

import com.google.gson.annotations.SerializedName

class Item {
    var status: Int =0
    var message: String?=null

    @SerializedName("items")
    var itemsList: ArrayList<Items>? =null

    class Items {
        @SerializedName("name")
        var name: String?=null
        @SerializedName("full_name")
        var fullName: String?=null
        @SerializedName("owner")
        var owner: Owners? =null
        @SerializedName("description")
        var description: String?=null
        @SerializedName("url")
        var url: String?=null
        @SerializedName("clone_url")
        var clone_url: String?=null
        @SerializedName("open_issues")
        var open_issues: Long?=0
        @SerializedName("forks")
        var forks: Long?=0
        @SerializedName("watchers")
        var watchers: Long?=0
        @SerializedName("default_branch")
        var default_branch: String?=null
        @SerializedName("score")
        var score: Double =0.0
    }

    class Owners {
        @SerializedName("login")
        var login: String?=null
        @SerializedName("avatar_url")
        var avatar_url: String?=null
    }

}