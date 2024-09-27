package com.example.nequi_clone.screens.viewmodel

import androidx.lifecycle.ViewModel
import com.example.nequi_clone.data.notification.FakeCategoryData
import com.example.nequi_clone.data.notification.FakeNotificationData
import com.example.nequi_clone.domain.model.notification.Notification

class NotificationViewModel : ViewModel() {

    var notifications = FakeNotificationData.getNotification()
    var notificationCategory = FakeCategoryData.getCategories()

    fun getNotificationCountByCategory(): Map<Int, Int> {
        val categoryCountMap = notifications.groupingBy { it.categoryId }.eachCount().toMutableMap()

        categoryCountMap[0] = notifications.size

        return categoryCountMap
    }

    fun getNotificationsByCategory(categoryId: Int): List<Notification> {
        return if (categoryId == 0) {
            notifications
        } else {
            notifications.filter { it.categoryId == categoryId }
        }
    }
}
