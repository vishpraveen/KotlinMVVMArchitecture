package com.example.kotlinmvvmarchitecture.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvmarchitecture.R
import com.example.kotlinmvvmarchitecture.databinding.RepoListViewBinding
import com.example.kotlinmvvmarchitecture.interfaces.RecyclerViewClickListener
import com.example.kotlinmvvmarchitecture.models.Item
import java.util.ArrayList

class AdapterRepoList(
    private var repoList: ArrayList<Item.Items>?,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<AdapterRepoList.RepoViewHolder>() {
    private lateinit var viewBinding: RepoListViewBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        viewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.repo_list_view,parent,false)
        return RepoViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return repoList!!.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
//        holder.bind(repoList?.get(position),listener,position)
        val item = repoList?.get(position)
        holder.bindingView.setVariable(BR.item,item)
        holder.bindingView.setVariable(BR.position,position)
        holder.bindingView.setVariable(BR.listener,listener)
        holder.bindingView.executePendingBindings()
    }

    inner class RepoViewHolder(val bindingView: RepoListViewBinding): RecyclerView.ViewHolder(bindingView.root){
        /* fun bind(items: Item.Items?,listener: RecyclerViewClickListener, position: Int) {
            viewBinding.position = position
            viewBinding.setVariable(BR.item,items)
            viewBinding.listener = listener
            viewBinding.executePendingBindings()
        }*/

    }
}
