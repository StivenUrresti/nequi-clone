package com.example.nequi_clone.screens.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.nequi_clone.data.service.FakeCategoryData
import com.example.nequi_clone.data.service.FakeServiceData
import com.example.nequi_clone.domain.model.service.Category
import com.example.nequi_clone.domain.model.service.Service

class ServiceViewModel : ViewModel() {
     var categories = mutableStateListOf<Category>()
    var services = mutableStateListOf<Service>()
    init {
        categories.addAll(FakeCategoryData.getFakeCategory())
        services.addAll(FakeServiceData.getFakeService())
    }
}

