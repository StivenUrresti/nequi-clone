package com.example.nequi_clone.screens

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.outlined.Article
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nequi_clone.ui.theme.Nequi_cloneTheme
import androidx.activity.compose.BackHandler
import androidx.compose.material3.TextButton


@Composable
fun ConfirmationDialog(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    androidx.compose.material3.AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Confirm Exit") },
        text = { Text("Are you sure you want to exit the app?") },
        confirmButton = {
            TextButton(onClick = {
                onConfirm()
            }) {
                Text("Yes")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("No")
            }
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainApp() {
    val navController = rememberNavController()
    var showExitDialog by remember { mutableStateOf(false) }
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    BackHandler {
        if (currentRoute in listOf("home", "movements", "services")) {
            showExitDialog = true
        } else {
            navController.popBackStack()
        }
    }

    Scaffold(
        bottomBar = {
            if (currentRoute in listOf("home", "movements", "services")) {
                BottomNavigationBar(navController)
            }
        }
    ) {
        NavHost(navController = navController, startDestination = "login") {
            composable("login") { LoginScreen(navController) }

            composable("home") { HomeScreen(navController) }
            composable("movements") { MovementsScreen(navController) }
            composable("services") { ServicesScreen(navController) }
            composable("profile") { ProfileScreen(navController) }
            composable("notification") { NotificationScreen(navController) }
        }

        if (showExitDialog) {
            ConfirmationDialog(
                onConfirm = {
                    (navController.context as? Activity)?.finish()
                },
                onDismiss = {
                    showExitDialog = false
                }
            )
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf("Inicio", "Movimientos", "Servicios")
    val icons = listOf(Icons.Outlined.Home, Icons.Outlined.Article, Icons.Outlined.GridView)
    val routes = listOf("home", "movements", "services")

    var showDialog by remember { mutableStateOf(false) }

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
            routes.forEachIndexed { index, route ->
                Box(
                    modifier = Modifier
                        .clickable { navController.navigate(route) }
                        .padding(vertical = 7.dp)
                        .background(
                            color = if (navController.currentBackStackEntry?.destination?.route == route) Color(
                                0xFFEAE7F5
                            ) else Color.Transparent,
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
                            contentDescription = items[index],
                            tint = if (navController.currentBackStackEntry?.destination?.route == route) Color(0xFF4C324B) else Color.Black,
                            modifier = Modifier.size(26.dp)
                        )
                        Text(
                            text = items[index],
                            fontSize = 12.sp,
                            color = if (navController.currentBackStackEntry?.destination?.route == route) Color(0xFF4C324B) else Color.Black,
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color(0xFFDB0082), shape = RoundedCornerShape(4.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AttachMoney,
                    contentDescription = "Abrir Modal",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
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
