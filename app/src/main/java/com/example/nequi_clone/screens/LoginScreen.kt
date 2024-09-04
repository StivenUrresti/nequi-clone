package com.example.nequi_clone.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nequi_clone.R
import com.example.nequi_clone.ui.theme.Nequi_cloneTheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
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
                    FilledButtonExample(onClick = { /*TODO*/ })
                    Spacer(modifier = Modifier.height(16.dp))
                    Footer()
                }
            }
        }
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Row(
        modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Icon")
        Text(text = "Dynamic password")
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
fun Footer(modifier: Modifier = Modifier) {
    Row( modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "hola")
        Text(text = "hola")
        Text(text = "hola")
    }
}



@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun LoginScreenPreview() {
    Nequi_cloneTheme(darkTheme = false) {
        LoginScreen()
    }
}
