package com.adaptivehandyapps.hamappbotnav.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class HamSampleViewModel : ViewModel() {
    private var sampleLiveData = MutableLiveData<String>()

    fun getSample():MutableLiveData<String>{
        return sampleLiveData
    }
    fun setSample(sample: String){
        sampleLiveData.value = sample
    }
}
