package com.example.nequi_clone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nequi_clone.R
import com.example.nequi_clone.ui.theme.Nequi_cloneTheme

@Composable
fun LoginScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Nequi_cloneTheme {
        Surface(
            modifier = modifier.fillMaxWidth(),
            color = Color(0xFF000000)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Header()
                Spacer(modifier = Modifier.weight(1f))
                CenteredLogo()
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SimpleOutlinedTextFieldSample()
                    Spacer(modifier = Modifier.height(16.dp))
                    FilledButtonExample(onClick = { navController.navigate("home")
                    {
                        popUpTo("login") { inclusive = true }
                    }
                    })
                    Spacer(modifier = Modifier.height(16.dp))
                    Footer()
                }
            }
        }
    }
}

@Composable
private fun Header(modifier: Modifier = Modifier) {
    Row(
        modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Icon(Icons.Filled.QuestionMark, contentDescription = "Help Icon", tint = Color.White)
            Icon(Icons.Filled.VerifiedUser, contentDescription = "Help Icon", tint = Color.White)
        }
        Box(
            modifier
                .background(
                    Color(0xFF4D334D),
                    shape = RoundedCornerShape(14.dp)
                )
                .padding(10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = "Clave dinamica", color = Color.White)
                Text(text = "123456", color = Color.White , fontSize = 16.sp,fontWeight = FontWeight.Bold )
                Icon(Icons.Filled.ContentCopy, contentDescription = "Help Icon", tint = Color.White)
            }
        }
    }
}

@Composable
fun CenteredLogo(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.nequi_logo_ligth),
            contentDescription = "Logo Nequi",
            modifier = Modifier.size(200.dp)
        )
    }
}

@Composable
fun SimpleOutlinedTextFieldSample(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier
            .fillMaxWidth(),
        placeholder =  { Text("Número de teléfono") },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedContainerColor = Color(0xFF4D334D),
            focusedContainerColor = Color(0xFF4D334D),
            unfocusedPlaceholderColor = Color.White,
            focusedPlaceholderColor = Color.White,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,

        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        leadingIcon = {
            Text(
                text = "57",
                modifier = Modifier.padding(10.dp),
                fontSize = 18.sp,
                color = Color.Gray
            )
        },
    )
}

@Composable
fun FilledButtonExample(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFDB0082),
            contentColor = Color.White
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp),

    ) {
        Text("Entrar")
    }
}

@Composable
private fun Footer(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Filled.QrCode,
                contentDescription = "Help Icon",
                tint = Color.White
            )
            Column {
                Text(text = "usar", color = Color.White)
                Text(text = "codigo QR", color = Color.White)
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(Icons.Filled.AccountBalanceWallet, contentDescription = "Help Icon", tint = Color.White)
            Column {
                Text(text = "paga en", color = Color.White)
                Text(text = "datafono", color = Color.White)
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "by", color = Color.Gray)
            Image(
                painter = painterResource(id = R.drawable.by_bancolombia),
                contentDescription = "logo bancolombia",
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Gray)
                    .padding(4.dp)
            )
        }
    }
}


