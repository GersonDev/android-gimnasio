package com.example.android_gimnasio.presentation.common.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.android_gimnasio.R

@Composable
fun GymTitle(title: String, @DrawableRes userImage: Int, ocultarImagen: Boolean = false) {
    Box(
        modifier = Modifier.height(60.dp),
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
            if (!ocultarImagen) {
                UserPicture(userImage)
            }
        }
    }
}

@Composable
fun UserPicture(@DrawableRes userImage: Int) {
    Image(
        painter = painterResource(R.drawable.ic_user_profile_picture),
        contentDescription = "profile",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Gray, CircleShape)
    )
}

@Composable
fun GymScaffold(
    @StringRes titleId: Int,
    upAvailable: Boolean,
    onUpClicked: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(titleId)) },
                navigationIcon = {
                    if (upAvailable) {
                        IconButton(onClick = { onUpClicked() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    }
                })
        },
        backgroundColor = Color.Transparent,
        content = content
    )
}