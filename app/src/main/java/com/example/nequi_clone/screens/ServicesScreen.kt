package com.example.nequi_clone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nequi_clone.R
import com.example.nequi_clone.domain.model.service.Category
import com.example.nequi_clone.screens.viewmodel.ServiceViewModel

@Composable
fun ServicesScreen(
    modifier : Modifier = Modifier,
    viewModel: ServiceViewModel = ServiceViewModel(),
) {
    var searchText by remember { mutableStateOf("") }
    Surface(color = Color.White) {
        Column(
            modifier
                .fillMaxSize()
                .padding(12.dp)
            ,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Servicios",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            SearchTextField(value = searchText,onValueChange = { searchText = it })
            val filteredCategories = viewModel.categories.filter { category ->
                category.name.contains(searchText, ignoreCase = true)
            }
            ServiceList(filteredCategories)
            ImageCarouselExample()
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
private fun ServiceList( categories: List<Category>, modifier: Modifier = Modifier) {
    Row (horizontalArrangement = Arrangement.spacedBy(4.dp),) {
        Icon(
            Icons.Filled.GridView,
            contentDescription = "Search Icon",
            tint = Color.Black,
            modifier = Modifier.size(22.dp)
        )
        Text(
            text = "Categorias",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 6.dp, top = 6.dp)
    ) {
        items(categories.size) { index ->
            CategoryItem(category = categories[index])
        }
    }
}


@Composable
fun CategoryItem(category: Category, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(74.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
                clip = true
            )
            .background(Color.White)
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                imageVector = category.icon,
                contentDescription = category.name,
                modifier = Modifier.size(28.dp),
                tint = Color(0xFFDB0082)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = category.name,
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}

@Composable
fun ImageCarousel(imageResIds: List<Int>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(imageResIds.size) { index ->
            CarouselImageItem(imageResId = imageResIds[index])
        }
    }
}

@Composable
fun CarouselImageItem(imageResId: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .width(300.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray)
    )
}


@Composable
fun ImageCarouselExample() {
    val imageResIds = listOf(
        R.drawable.bannernequi,
        R.drawable.bannnernequi2,
        R.drawable.banernequi3,
        R.drawable.bannernequi4
    )

    ImageCarousel(imageResIds = imageResIds)
}






@Preview()
@Composable
fun ServicesScreenPreview() {
    ServicesScreen()
}