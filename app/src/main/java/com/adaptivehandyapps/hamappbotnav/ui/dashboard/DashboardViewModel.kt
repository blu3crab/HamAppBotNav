package com.adaptivehandyapps.hamappbotnav.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private var _text = MutableLiveData<String>().apply {
        value = "--"
    }
    val text: LiveData<String> = _text

    fun setValue(text: String) {
        _text.value = text
    }
}
