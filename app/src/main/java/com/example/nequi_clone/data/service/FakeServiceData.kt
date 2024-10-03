package com.example.nequi_clone.data.service

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PhoneIphone
import androidx.compose.material.icons.outlined.Savings
import androidx.compose.material.icons.outlined.Shop
import androidx.compose.material.icons.outlined.Smartphone
import androidx.compose.material.icons.outlined.Store
import androidx.compose.material.icons.outlined.Wallet
import com.example.nequi_clone.domain.model.service.Service

object FakeServiceData {
    fun getFakeService(): List<Service> {
        return listOf(
            Service(
                id = 1,
                name = "Mercado",
                icon = Icons.Outlined.Store
            ),
            Service(
                id = 2,
                name = "Paquetes de celular",
                icon = Icons.Outlined.PhoneIphone
            ),
            Service(
                id = 3,
                name = "Metas",
                icon = Icons.Outlined.Savings
            ),
            Service(
                id = 4,
                name = "Bolsillos",
                icon = Icons.Outlined.Wallet
            ),
        )
    }
}