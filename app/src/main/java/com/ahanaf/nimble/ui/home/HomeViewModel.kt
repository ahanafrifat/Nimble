package com.ahanaf.nimble.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahanaf.nimble.R
import com.ahanaf.nimble.common.HomeIntroModel
import com.ahanaf.nimble.common.ResponseModel

class HomeViewModel : ViewModel() {

    val message = MutableLiveData<String>()
    val refresh = MutableLiveData<Boolean>()
    val isSuccessFul = MutableLiveData<Boolean>()
    val homeIntroMutableList = MutableLiveData<List<HomeIntroModel>>()

    fun loadHomeScreen(){
        val homeIntroList = mutableListOf<HomeIntroModel>()
        homeIntroList.add(HomeIntroModel("Monday, JUNE 15", "Today", "Working from home Check-In", "We would like to know how you feel about our work from home...", R.drawable.ic_home_background_1_image))
        homeIntroList.add(HomeIntroModel("Monday, JUNE 15", "Today", "Career training and development", "We would like to know what are your goals and skills you wanted...", R.drawable.ic_home_background_2_image))
        homeIntroList.add(HomeIntroModel("Monday, JUNE 15", "Today", "Inclusion and belonging", "Building a workplace culture that prioritizes belonging and inclusio...", R.drawable.ic_home_background_3_image))
        homeIntroMutableList.postValue(homeIntroList)
    }

    private fun onSuccess() {
        isSuccessFul.postValue(true)
//        message.postValue(response.message)
    }

    private fun onFailure(error: ResponseModel) {
        isSuccessFul.postValue(true)
        message.postValue(error.message)
    }
}