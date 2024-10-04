package com.example.nequi_clone.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material.icons.outlined.QrCode
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFF1f0020)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Header(modifier = Modifier.fillMaxWidth(), navController)
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                PersonalInfo()
                Spacer(modifier = Modifier.height(10.dp))
                Options(text = "Ajustes", icon = Icons.Outlined.Settings)
                Options(text = "Documentos y Certificados", icon = Icons.Outlined.Description)
                Options(text = "Ayuda", icon = Icons.Outlined.HelpOutline)
            }

            Spacer(modifier = Modifier.weight(1f))

            Footer()
        }
    }
}



@Composable
private fun Header(modifier: Modifier = Modifier, navController: NavHostController,) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = modifier.clickable { navController.navigate("home") }
    ) {
        Icon(
            Icons.Filled.ArrowBack,
            contentDescription = "Back Icon",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Text(text = "Tu perfil", color = Color.White, fontSize = 18.sp)
    }
}

@Composable
fun PersonalInfo(modifier: Modifier = Modifier) {
    Box(
        modifier
            .background(
                Color(0xFFDB0082),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
            .width(280.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        Color(0xFFECE7F5),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
                    .size(64.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Outlined.CameraAlt,
                    contentDescription = "Camera Icon",
                    tint = Color(0xFF1f0020),
                    modifier = Modifier.size(32.dp)
                )
            }
            Text(
                text = "EDINSON URRESTI",
                color = Color.White,
                modifier = Modifier.padding(top = 8.dp),
                fontSize = 20.sp
            )
            Divider(
                color = Color(0xFFECE7F5),
                thickness = 1.dp,
                modifier = Modifier
                    .padding(vertical = 8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "# de tu Nequi", color = Color(0xFFECE7F5))
                    Text(text = "316 897 6185", color = Color.White, style = MaterialTheme.typography.bodyMedium)
                }
                Icon(
                    Icons.Outlined.QrCode,
                    contentDescription = "QR Code Icon",
                    tint = Color(0xFF1f0020),
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

@Composable
fun Options(modifier: Modifier = Modifier, text:String, icon: ImageVector) {
    Box(
        modifier
            .fillMaxWidth()
            .background(color = Color(0xFF71506c), shape = RoundedCornerShape(8.dp))
            .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp)

    )  {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "QR Code Icon",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
                Text(text = text, color = Color.White, fontSize = 18.sp)

            }
            Icon(
                Icons.Filled.ChevronRight,
                contentDescription = "QR Code Icon",
                tint = Color.White,
                modifier = Modifier.size(36.dp)
            )
        }
    }
}

@Composable
private fun Footer(modifier: Modifier = Modifier) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
            Icon(
                Icons.Filled.PowerSettingsNew,
                contentDescription = "QR Code Icon",
                tint = Color.White,
                modifier = Modifier.size(36.dp)
            )
            Text(text = "Salir", color = Color.White)
        }
        Divider(
            color = Color(0xFFECE7F5),
            thickness = 1.dp,
            modifier = Modifier
                .padding(vertical = 12.dp))
        Row( horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier.fillMaxWidth()) {
            Text(text = "ultima conexion el 13 septiembre", color =  Color.White)
            Column {
                Text(text = "version", color =  Color.White, fontWeight = FontWeight.Bold)
                Text(text = "1.0.0", color =  Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}


