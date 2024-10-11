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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.outlined.ArrowDownward
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


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

    // Variable para controlar la visibilidad del modal
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
                    .background(Color(0xFFDB0082), shape = RoundedCornerShape(4.dp))
                    .clickable {
                        showDialog = true
                    },
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

    if (showDialog) {
        FullScreenModal(onDismiss = {
            showDialog = false
        })
    }
}


@Composable
fun FullScreenModal(onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xE6FFFFFF)),
            contentAlignment = Alignment.BottomEnd
        ) {
            Box(
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    ItemsModal("+ Servicios", Icons.Outlined.GridView, color = 0xFF5A9EFA)
                    ItemsModal("Saca", Icons.Outlined.ArrowDownward, color =  0xFFDB0082)
                    ItemsModal("Pide", Icons.Default.ArrowBack, color = 0xFFDB0082)
                    ItemsModal("Envia", Icons.Default.ArrowForward, color = 0xFFDB0082)
                    ItemsModal("Codigo QR", Icons.Default.QrCode, color = 0xFFDB0082)
                    ItemsModal("Recarga Nequi", Icons.Default.ArrowUpward, color = 0xFFDB0082)
                    Box(
                        modifier = Modifier
                            .shadow(
                                elevation = 6.dp,
                                shape = RoundedCornerShape(8.dp),
                                clip = false
                            )
                            .background(
                                Color(0xFFECE7F5),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(12.dp)
                            .clickable { onDismiss() }
                        ,
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Outlined.Close,
                            contentDescription = "hola",
                            tint = Color.Black,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ItemsModal(
    text: String,
    icon: ImageVector,
    color: Long,
    modifier: Modifier = Modifier
) {
    Row(
        modifier.padding(top = 10.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = text, color = Color.Black)
        Box(
            modifier = modifier
                .background(
                    Color(color),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = Color.White,
                modifier = modifier.size(24.dp)
            )
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
