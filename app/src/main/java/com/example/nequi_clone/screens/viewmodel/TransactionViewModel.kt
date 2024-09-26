package com.example.nequi_clone.screens.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.nequi_clone.data.transaction.FakeTransactionData
import com.example.nequi_clone.domain.model.transaction.Transaction

class TransactionViewModel : ViewModel() {

    var transactions = mutableStateListOf<Transaction>()
    init {
        transactions.addAll(FakeTransactionData.getFakeTransactions())
    }
}