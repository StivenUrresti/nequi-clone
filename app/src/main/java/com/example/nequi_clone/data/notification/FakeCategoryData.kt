package com.example.nequi_clone.data.notification

import com.example.nequi_clone.domain.model.notification.NotificationCategory

object  FakeCategoryData {
    fun getCategories(): List<NotificationCategory> {
        return listOf(
            NotificationCategory(2, "En Espera"),
            NotificationCategory(3, "Transfiya"),
        )
    }
}