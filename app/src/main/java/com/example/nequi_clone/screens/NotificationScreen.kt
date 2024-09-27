package com.example.nequi_clone.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nequi_clone.screens.viewmodel.NotificationViewModel
import com.example.nequi_clone.domain.model.notification.Notification
import com.example.nequi_clone.domain.model.notification.NotificationCategory

@Composable
fun NotificationScreen(
    modifier: Modifier = Modifier,
    viewModel: NotificationViewModel = NotificationViewModel()
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val categories = viewModel.notificationCategory
    val tabs = listOf(NotificationCategory(0, "Recibidas")) + categories

    val notificationCounts = viewModel.getNotificationCountByCategory()

    Surface(color = Color.White){
        Column(modifier = modifier.fillMaxSize().padding(16.dp)) {

            Text(
                text = "Notificaciones",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                tabs.forEachIndexed { index, category ->
                    val count = notificationCounts[category.id] ?: 0
                    CategoryButton(
                        category = category,
                        isSelected = selectedTabIndex == index,
                        notificationCount = count,
                        onClick = { selectedTabIndex = index }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            val filteredNotifications = viewModel.getNotificationsByCategory(tabs[selectedTabIndex].id)

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(filteredNotifications) { notification ->
                    NotificationItem(notification = notification)
                }
            }
        }
    }
}

@Composable
fun CategoryButton(
    category: NotificationCategory,
    isSelected: Boolean,
    notificationCount: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color(0xFFDB0082) else Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, if (isSelected) Color.Transparent else Color.Gray),
        modifier = Modifier
            .padding(horizontal = 2.dp)
    ) {
        Text(
            text = "${category.name} ($notificationCount)",
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 11.sp
        )
    }
}

@Composable
fun NotificationItem(notification: Notification) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = notification.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = notification.message, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Categoría ID: ${notification.categoryId}", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview
@Composable
fun NotificationScreenPreview() {
    NotificationScreen()
}
