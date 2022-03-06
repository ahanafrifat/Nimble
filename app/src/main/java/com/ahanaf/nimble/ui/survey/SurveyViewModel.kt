package com.ahanaf.nimble.ui.survey

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahanaf.nimble.common.ResponseModel
import com.ahanaf.nimble.model.Attributes

class SurveyViewModel : ViewModel() {
    val message = MutableLiveData<String>()
    val refresh = MutableLiveData<Boolean>()
    val isSuccessFul = MutableLiveData<Boolean>()
    val attributesMutableLiveData = MutableLiveData<List<Attributes>>()


    fun loadQuestions(){

        val attributesList = mutableListOf<Attributes>()
        attributesList.add(Attributes(null, null, null, "How fulfilled did you feel during this WFH period?", null, null, null, null, null, null))
        attributesList.add(Attributes(null, null, null, "How did WFH change your productivity?", null, null, null, null, null, null))
        attributesMutableLiveData.postValue(attributesList)
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