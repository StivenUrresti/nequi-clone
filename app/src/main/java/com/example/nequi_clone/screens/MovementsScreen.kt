package com.example.nequi_clone.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nequi_clone.domain.model.transaction.Transaction
import com.example.nequi_clone.screens.viewmodel.TransactionViewModel

@Composable
fun MovementsScreen(
    modifier: Modifier = Modifier,
    viewModel: TransactionViewModel = TransactionViewModel(),
) {
    var searchText by remember { mutableStateOf("") }
    Surface(
        color = Color.White,
        modifier = modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)) {
            Text(text = "Movimientos", color = Color.Black)
            Spacer(modifier = Modifier.padding(8.dp))
            SearchTextField(
                value = searchText,
                onValueChange = { searchText = it }
            )
            Spacer(modifier = Modifier.padding(8.dp))

            val filteredTransactions = viewModel.transactions.filter { transaction ->
                transaction.description.contains(searchText, ignoreCase = true)
            }
            TransactionList(filteredTransactions)
        }
    }
}

@Composable
private fun SearchTextField(value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier) {

    TextField(
        value = value,
        onValueChange =  onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
                clip = false
            )
            .background(Color.White, shape = RoundedCornerShape(8.dp)),
        placeholder = { Text("Buscar") },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedContainerColor = Color(0xFFF5F5F5),
            focusedContainerColor = Color.White,
            unfocusedPlaceholderColor = Color.Black,
            focusedPlaceholderColor = Color.Black,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                contentDescription = "Search Icon",
                tint = Color.Black
            )
        },
    )
}

@Composable
fun TransactionList(transactions: List<Transaction>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(30.dp),

    ) {
        items(transactions) { transaction ->
            CardMovement(transaction)
        }
    }
}

@Composable
private fun CardMovement(transaction: Transaction, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp),
                clip = false
            )
            .background(Color.White, shape = RoundedCornerShape(8.dp))

    ) {
        Row(
            modifier
                .fillMaxWidth()
                .background(
                    Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(top = 30.dp, bottom = 30.dp, start = 16.dp, end = 16.dp)
        ) {
            Column {
                Row(
                    modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        val icon = if (transaction.isWithdrawal) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp
                        val color = if (transaction.isWithdrawal) Color(0xFFDB0082) else Color.Black
                        Row {


                            Icon(
                                imageVector = icon,
                                contentDescription = "Transaction Icon",
                                tint = color
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = transaction.description, color = Color.Black)
                        }

                        Text(
                            text = if (transaction.isWithdrawal) "-$${transaction.amount}" else "$${transaction.amount}",
                            color = color,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }


                }
            }
        }
    }
}

@Preview()
@Composable
fun MovementsScreenPreview() {
    MovementsScreen()
}
