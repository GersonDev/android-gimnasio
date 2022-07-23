package com.example.android_gimnasio.presentation.main.components

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.android_gimnasio.R
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView


@Composable
fun TrainerPantalla() {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.trainers),
                contentDescription = "Imagen pantalla de trainers",
                contentScale = ContentScale.FillWidth
            )
            Spacer(
                modifier =Modifier
                    .weight(1f)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RectangleShape)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colors.secondaryVariant
                        ),
                        startY = 0f,
                        endY = 640f
                    )
                )
            )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(40.dp)
        ) {
            Text(
                "YOUR BEST OPTION\n " +
                        "IN TRAINERS",
                letterSpacing = 0.1.em,
                fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h1
            )
            VideoPlayer(modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 15.dp),

                ) {
                Text(
                    "Trainers Men",
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        color = Color.White
                    ),
                    fontSize = 19.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                ClickableText(
                    text = AnnotatedString(" See all"),
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 19.sp
                    ),
                    onClick = { }
                )
            }
            Row {
                Image(
                    painter = painterResource(id = R.drawable.hombre),
                    contentDescription = "trainers",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.hombre),
                    contentDescription = "trainers",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.hombre),
                    contentDescription = "trainers",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.hombre),
                    contentDescription = "trainers",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.hombre),
                    contentDescription = "trainers",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 15.dp),

                ) {
                Text(
                    "Trainers Women",
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        color = Color.White
                    ),
                    fontSize = 19.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                ClickableText(
                    text = AnnotatedString(" See all"),
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 19.sp
                    ),
                    onClick = { }
                )
            }
            Row {
                Image(
                    painter = painterResource(id = R.drawable.mujer),
                    contentDescription = "trainers",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.mujer),
                    contentDescription = "trainers",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.mujer),
                    contentDescription = "trainers",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.mujer),
                    contentDescription = "trainers",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.mujer),
                    contentDescription = "trainers",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}

@Composable
fun VideoPlayer(modifier:Modifier){
    val sampleVideo = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    val context = LocalContext.current
    val player = SimpleExoPlayer.Builder(context).build()
    val playerView = PlayerView(context)
    val mediaItem = MediaItem.fromUri(sampleVideo)
    val playWhenReady by rememberSaveable {
        mutableStateOf(true)
    }
    player.setMediaItem(mediaItem)
    playerView.player = player
    LaunchedEffect(player) {
        player.prepare()
        player.playWhenReady = playWhenReady

    }
    AndroidView(factory = {
        playerView
    },

    )
}

@Preview
@Composable
private fun TrainerPantallaPreview() {
    TrainerPantalla()
}