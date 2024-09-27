package com.example.nequi_clone.screens.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.nequi_clone.data.service.FakeCategoryData
import com.example.nequi_clone.domain.model.service.Category

class ServiceViewModel : ViewModel() {
     var categories = mutableStateListOf<Category>()
    init {
        categories.addAll(FakeCategoryData.getFakeCategory())
    }
}

