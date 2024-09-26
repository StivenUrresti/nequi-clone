package com.example.nequi_clone.data.transaction

import com.example.nequi_clone.domain.model.transaction.Transaction
import java.util.Calendar

object FakeTransactionData {
    fun getFakeTransactions(): List<Transaction> {
        val calendar = Calendar.getInstance()
        calendar.set(2023, Calendar.JULY, 10, 13, 0, 0)

        return listOf(
            Transaction(
                id = 1,
                date = "2023-07-10",
                transactionRef = "REF001",
                amount = 2500.00,
                description = "Supermercado",
                isWithdrawal = true
            ),
            Transaction(
                id = 2,
                date = "2023-07-12",
                transactionRef = "REF002",
                amount = 3200.00,
                description = "Servicios",
                isWithdrawal = false
            ),
            Transaction(
                id = 3,
                date = "2023-07-15",
                transactionRef = "REF003",
                amount = 1500.00,
                description = "Recarga móvil",
                isWithdrawal = false
            ),
            Transaction(
                id = 4,
                date = "2023-07-20",
                transactionRef = "REF004",
                amount = 4000.00,
                description = "Paquete datos",
                isWithdrawal = true
            ),
            Transaction(
                id = 5,
                date = "2023-07-25",
                transactionRef = "REF005",
                amount = 2800.00,
                description = "Transferencia",
                isWithdrawal = false
            ),
            Transaction(
                id = 6,
                date = "2023-08-01",
                transactionRef = "REF006",
                amount = 3000.00,
                description = "Pago alquiler",
                isWithdrawal = true
            ),
            Transaction(
                id = 7,
                date = "2023-08-05",
                transactionRef = "REF007",
                amount = 1000.00,
                description = "Tienda ropa",
                isWithdrawal = true
            ),
            Transaction(
                id = 8,
                date = "2023-08-10",
                transactionRef = "REF008",
                amount = 3500.00,
                description = "Seguro médico",
                isWithdrawal = false
            ),
            Transaction(
                id = 9,
                date = "2023-08-12",
                transactionRef = "REF009",
                amount = 500.00,
                description = "Cafetería",
                isWithdrawal = true
            ),
            Transaction(
                id = 10,
                date = "2023-08-15",
                transactionRef = "REF010",
                amount = 4200.00,
                description = "Gimnasio",
                isWithdrawal = false
            )

        )
    }
}
