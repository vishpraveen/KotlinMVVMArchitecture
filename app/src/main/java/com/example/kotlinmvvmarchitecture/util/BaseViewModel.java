package com.example.kotlinmvvmarchitecture.util;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {
    public MutableLiveData<Boolean> isNetworkAvailable = new MutableLiveData<>();
    public MutableLiveData<Boolean> isDataLoading = new MutableLiveData<>();
//    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
}
