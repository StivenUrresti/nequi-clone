package com.example.nequi_clone.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Article
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomNavigationBar() {
    var selectedItem by remember { mutableIntStateOf(0) }

    val items = listOf("Inicio", "Movimientos", "Servicios")
    val icons = listOf(Icons.Outlined.Home, Icons.Outlined.Article, Icons.Outlined.GridView)

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        containerColor = Color(0xFFF5F5F5),
        contentColor = Color.Black
    ) {
        items.forEachIndexed { index, item ->
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable { selectedItem = index }
                    .background(
                        if (selectedItem == index) Color(0xFFD1C4E9) else Color.Transparent
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = icons[index],
                    contentDescription = item,
                    tint = if (selectedItem == index) Color(0xFF6200EA) else Color.Black,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = item,
                    fontSize = 12.sp,
                    fontWeight = if (selectedItem == index) FontWeight.Bold else FontWeight.Normal,
                    color = if (selectedItem == index) Color(0xFF6200EA) else Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar()
}
