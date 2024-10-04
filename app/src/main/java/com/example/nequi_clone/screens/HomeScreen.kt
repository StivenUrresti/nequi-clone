package com.example.nequi_clone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.ModeEdit
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nequi_clone.R
import com.example.nequi_clone.domain.model.service.Service
import com.example.nequi_clone.screens.viewmodel.ServiceViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: ServiceViewModel = ServiceViewModel(),
) {
    Surface(modifier = modifier.fillMaxSize(), color = Color.White) {
        Column {
            Header(navController= navController)
            Spacer(modifier = Modifier.height(60.dp))
            Favorites()
            ListFavorites(viewModel.services)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ){

                    Text(text = "Segeridos nequi", fontSize = 18.sp, color = Color.Black)
                }

            }
            ListFavorites(viewModel.services)
        }
    }
}

@Composable
private fun Header(modifier: Modifier = Modifier,navController: NavHostController, ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(270.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo_nequi),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column( horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween ,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp),){
                    Box(
                        modifier
                            .background(color = Color(0xFF4C324B), shape = RoundedCornerShape(4.dp))
                            .padding(8.dp)
                            .clickable{ navController.navigate("profile") }
                    ) {
                        Icon(
                            Icons.Outlined.Person,
                            contentDescription = "Help Icon",
                            tint = Color.White,
                            modifier = modifier.size(30.dp)
                        )
                    }
                    Column {
                        Text(
                            text = "Hola",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "Stiven",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Outlined.Notifications,
                        contentDescription = "Help Icon",
                        tint = Color.White,
                        modifier = modifier
                            .size(30.dp)
                            .clickable { navController.navigate("notification") }
                    )
                    Icon(
                        Icons.Outlined.QuestionMark,
                        contentDescription = "Help Icon",
                        tint = Color.White,
                        modifier = modifier.size(30.dp)
                    )
                    Icon(
                        Icons.Outlined.Lock,
                        contentDescription = "Help Icon",
                        tint = Color.White,
                        modifier = modifier.size(14.dp)
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(text = "Deposito de bajo monto", color = Color.White, fontSize = 16.sp)
                Icon(
                    Icons.Outlined.VisibilityOff,
                    contentDescription = "Help Icon",
                    tint = Color.White,
                    modifier = modifier.size(16.dp)
                )
            }
            Text(text = "$ 300.000,00", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "total $ 300.000,00", color = Color.White, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .background(Color.Transparent)
                    .padding(start = 12.dp, top = 6.dp, bottom = 6.dp, end = 12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(text = "Tu plata", color = Color.White, fontSize = 16.sp)
                    Icon(
                        Icons.Outlined.KeyboardArrowDown,
                        contentDescription = "Help Icon",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun Favorites (modifier: Modifier = Modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ){
                Icon(
                    Icons.Outlined.FavoriteBorder,
                    contentDescription = "Help Icon",
                    tint = Color.Black,
                    modifier = Modifier.size(28.dp)
                )

                Text(text = "Tus favoritos", fontSize = 18.sp, color = Color.Black)
            }
            Icon(
                Icons.Outlined.ModeEdit,
                contentDescription = "Help Icon",
                tint = Color.Black,
                modifier = Modifier.size(26.dp)
            )

        }
}

@Composable
private fun ListFavorites(transactions: List<Service>,modifier: Modifier = Modifier) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp),
        modifier = modifier.fillMaxWidth()
    )
    {
        items(transactions) { service ->
            CardFavorites(service)
        }
    }
}

@Composable
private fun CardFavorites(item: Service, modifier: Modifier = Modifier) {
    Column(
        modifier
            .padding(start = 8.dp, end = 8.dp)
            .width(70.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier
                .shadow(
                    elevation = 6.dp,
                    shape = RoundedCornerShape(4.dp),
                    clip = false
                )
                .background(
                    Color.White,
                    shape = RoundedCornerShape(4.dp)
                )
                .fillMaxWidth()
                .height(76.dp),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = "Help Icon",
                tint = Color(0xFFDB0082),
                modifier = Modifier.size(30.dp)
            )
        }
        Text(
            text = item.name,
            fontSize = 14.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = modifier.padding( vertical = 6.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        )
    }
}


