package com.example.android_gimnasio.presentation.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.android_gimnasio.R

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
fun UserPicture(@DrawableRes userImage: Int) {
    Image(
        painter = painterResource(userImage),
        contentDescription = "profile",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Gray, CircleShape)
    )
}