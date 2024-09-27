package com.example.nequi_clone.domain.model.notification

data class Notification(
    val id: Int,
    val title: String,
    val message: String,
    val categoryId: Int,
)