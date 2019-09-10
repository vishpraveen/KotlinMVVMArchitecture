package com.example.kotlinmvvmarchitecture.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvmarchitecture.R
import com.example.kotlinmvvmarchitecture.databinding.ActivityMainBinding
import com.example.kotlinmvvmarchitecture.interfaces.EnumClick
import com.example.kotlinmvvmarchitecture.interfaces.RecyclerViewClickListener
import com.example.kotlinmvvmarchitecture.models.Item
import kotlinx.android.synthetic.main.activity_main.*
import util.Utility

class MainActivity : AppCompatActivity(), RecyclerViewClickListener {
    private val TAG = MainActivity::class.java.simpleName
    lateinit var mainViewModel: MainActivityViewModel
    lateinit var rvRepoList: RecyclerView
    var repoList : ArrayList<Item.Items> = ArrayList()
    lateinit var repoListAdapter: AdapterRepoList
    private lateinit var listener: RecyclerViewClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        listener = this
        mainViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.viewmodel = mainViewModel

        initUI()
        searchButton.setOnClickListener {
            if (etSearch.text.toString().isNotEmpty()){
                Utility.LogI(TAG,"isDataLoading Value1: ${mainViewModel.isDataLoading.value}")
                mainViewModel.isDataLoading.value = true
                mainViewModel.fetchRepoList().observe(this,
                    Observer<Item> { repo ->
                        if(repo?.status == 200){
                            repoList.clear()
                            repoList.addAll(repo.itemsList!!)
                            repoListAdapter.notifyDataSetChanged()
                            mainViewModel.isDataLoading.value =false
                        }
                     else{
                            Utility.showShackBarWithoutAction(constraintMain,repo.message!!)
                            mainViewModel.isDataLoading.value =false
                        }
                    })
            }else{
                Utility.showShackBarWithoutAction(constraintMain,"Please enter text to search.")
                mainViewModel.isDataLoading.value =false
            }
        }

        mainViewModel.isDataLoading.observe(this, Observer<Boolean> { status ->
            binding.progressStatus = status
            Utility.LogI(TAG,"isDataLoading Value2: ${mainViewModel.isDataLoading.value}")
        })
    }

    private fun initUI() {
        rvRepoList = findViewById(R.id.rvRepoList)
        val layoutManager = LinearLayoutManager(rvRepoList.context)
        rvRepoList.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(rvRepoList.context,layoutManager.orientation)
        rvRepoList.addItemDecoration(itemDecoration)
        repoListAdapter = AdapterRepoList(repoList,listener)
        rvRepoList.adapter = repoListAdapter
    }

    override fun onClick(where: EnumClick, data: Any, position: Int) {
        if (where == EnumClick.CELL){
            Utility.ToastDebug(this@MainActivity,"Clicked On: $data $position")
        }
    }
}
