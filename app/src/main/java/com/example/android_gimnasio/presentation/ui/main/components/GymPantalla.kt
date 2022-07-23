package com.example.android_gimnasio.presentation.ui.main.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_gimnasio.R
import com.example.android_gimnasio.domain.models.gym.Brand
import com.example.android_gimnasio.domain.models.trainers.TrainerCardModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GymPantalla(brands: List<Brand>) {

    Column(
        modifier = Modifier
            .background(colorResource(R.color.trainers__primary))
    ) {
        GymTitle("Gimnasios", R.drawable.img_user_profile)
        LazyVerticalGrid(
            cells = GridCells.Fixed(2)
        ) {
            items(items = brands, itemContent = { brand ->
                GymCard(brand)
            })
        }
    }
}

@Composable
fun GymTitle(title: String, @DrawableRes userImage: Int) {
    Box(
        modifier = Modifier.height(80.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth(),
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(24.dp),
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Imagen de login",
                contentScale = ContentScale.FillBounds
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            UserPicture(userImage)
        }
    }
}

@Composable
private fun GymCard(brand: Brand) {
    Row(
        modifier = Modifier
            .width(200.dp)
            .height(220.dp)
            .padding(10.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize(),
            shape = RoundedCornerShape(20.dp)
        ) {
            Box(
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    painter = painterResource(id = brand.image),
                    contentDescription = "Imagen de login",
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    brand.title,
                    color = Color.White,
                    modifier = Modifier.padding(10.dp),
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                )
            }
        }
    }
}


@Preview
@Composable
private fun GymPantallaPreview() {
    GymPantalla(
        listOf(
            Brand("hola", R.drawable.brand_1)
        )
    )
}