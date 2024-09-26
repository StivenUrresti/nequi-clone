package com.example.nequi_clone.data.service

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalMall
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.SentimentSatisfiedAlt
import androidx.compose.material.icons.filled.Smartphone
import androidx.compose.material.icons.filled.Store
import androidx.compose.material.icons.filled.Wallet
import com.example.nequi_clone.domain.model.service.Category

object FakeCategoryData {
    fun getFakeCategory(): List<Category> {
        return listOf(
            Category(
                name = "Celular y paquetes",
                icon = Icons.Filled.Smartphone
            ),
            Category(
                name = "Donaciones",
                icon = Icons.Filled.SentimentSatisfiedAlt
            ),
            Category(
                name = "Donaciones",
                icon = Icons.Filled.SentimentSatisfiedAlt
            ),
            Category(
                name = "Finazas",
                icon = Icons.Filled.Wallet
            ),
            Category(
                name = "Hogar",
                icon = Icons.Filled.Home
            ),
            Category(
                name = "Neqocios nequi",
                icon = Icons.Filled.Store
            ),
            Category(
                name = "Salud",
                icon = Icons.Filled.MonitorHeart
            ),
            Category(
                name= "Transporte y viajes",
                icon = Icons.Filled.DirectionsCar
            ),
        )
    }
}
