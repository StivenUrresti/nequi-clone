package com.example.nequi_clone.data.notification

import com.example.nequi_clone.domain.model.notification.Notification

object FakeNotificationData {
    fun getNotification(): List<Notification> {
        return listOf(
            Notification(
                1, "Pago pendiente", "Aprueba tu pago en [Comercio].", 2
            ),
            Notification(
                2, "Transferencia recibida", "Has recibido una transferencia de $500.", 3
            ),
            Notification(
                3, "Pago en espera", "Tu pago está en espera, espera confirmación.", 2
            ),
            Notification(
                4, "Transfiya solicitada", "Has solicitado una transferencia con Transfiya.", 3
            ),
            Notification(
                5, "Transfiya completada", "Tu Transfiya ha sido completada.", 3
            )
        )
    }
}
