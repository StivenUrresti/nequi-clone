package com.example.nequi_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Article
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nequi_clone.screens.HomeScreen
import com.example.nequi_clone.screens.MovementsScreen
import com.example.nequi_clone.screens.ServicesScreen
import com.example.nequi_clone.ui.theme.Nequi_cloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nequi_cloneTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    var selectedTab by remember { mutableIntStateOf(0) }
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedTab = selectedTab, onTabSelected = { selectedTab = it })
        },
        contentColor = Color.White,
        containerColor = Color.White,
        modifier = Modifier.padding(bottom = 20.dp)
    ) { innerPadding ->
        when (selectedTab) {
            0 -> HomeScreen(modifier = Modifier.padding(innerPadding))
            1 -> MovementsScreen(modifier = Modifier.padding(innerPadding))
            2 -> ServicesScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    val items = listOf("Inicio", "Movimientos", "Servicios")
    val icons = listOf(Icons.Outlined.Home, Icons.Outlined.Article, Icons.Outlined.GridView)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .shadow(elevation = 3.5.dp, shape = RoundedCornerShape(12.dp), clip = false)
            .background(shape = RoundedCornerShape(12.dp), color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                Box(
                    modifier = Modifier
                        .clickable { onTabSelected(index) }
                        .padding(vertical = 8.dp)
                        .background(
                            color = if (selectedTab == index) Color(0xFFEAE7F5) else Color.Transparent,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(8.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = icons[index],
                            contentDescription = item,
                            tint = if (selectedTab == index) Color(0xFF4C324B) else Color.Black,
                            modifier = Modifier.size(26.dp)
                        )
                        Text(
                            text = item,
                            fontSize = 12.sp,
                            color = if (selectedTab == index) Color(0xFF4C324B) else Color.Black
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Nequi_cloneTheme {
        MainApp()
    }
}
