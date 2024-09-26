package com.example.nequi_clone.domain.model.transaction

data class Transaction(
    val id: Int,
    val date: String,
    val transactionRef: String,
    val amount: Double,
    val description: String,
    val isWithdrawal: Boolean
)
