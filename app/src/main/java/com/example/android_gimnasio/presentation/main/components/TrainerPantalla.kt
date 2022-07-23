package com.example.android_gimnasio.presentation.main.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
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
import androidx.compose.ui.res.colorResource
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
import com.example.android_gimnasio.domain.models.Trainer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView


@Composable
fun TrainerPantalla() {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.trainers__primary))
    ) {
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

            VideoPlayer(modifier = Modifier.fillMaxWidth())

            Column {
                SectionTitle(
                    title = "Trainers",
                    subTitle = "See all",
                    colorTitle = Color.White,
                    colorSubtitle = colorResource(id = R.color.trainers_gray)
                )
                TrainersBubble(
                    listOf(
                        Trainer(R.drawable.trainers, "Amaka"),
                        Trainer(R.drawable.trainers, "Stella"),
                        Trainer(R.drawable.trainers, "Derick"),
                        Trainer(R.drawable.trainers, "Tayao"),
                        Trainer(R.drawable.trainers, "Sean"),
                    )
                )
            }

            Column {
                SectionTitle(
                    title = "Trainers",
                    subTitle = "See all",
                    colorTitle = Color.White,
                    colorSubtitle = colorResource(id = R.color.trainers_gray)
                )
                TrainersBubble(
                    listOf(
                        Trainer(R.drawable.trainers, "Amaka"),
                        Trainer(R.drawable.trainers, "Stella"),
                        Trainer(R.drawable.trainers, "Derick"),
                        Trainer(R.drawable.trainers, "Tayao"),
                        Trainer(R.drawable.trainers, "Sean"),
                    )
                )
            }

            Column {
                SectionTitle(
                    title = "Videos",
                    subTitle = "See all",
                    colorTitle = Color.White,
                    colorSubtitle = colorResource(id = R.color.trainers_gray)
                )
                VideoBody(
                    listOf(
                        R.drawable.img_video_pelado,
                        R.drawable.img_video_pelado,
                        R.drawable.img_video_pelado,
                        R.drawable.img_video_pelado,
                        R.drawable.img_video_pelado
                    )
                )
            }
            Column {
                SectionTitle(
                    title = "Tutorials",
                    subTitle = "See all",
                    colorTitle = Color.White,
                    colorSubtitle = Color.White
                )
                TutorialBody(
                    listOf(
                        R.drawable.ima_tutorials2,
                        R.drawable.img_tutorials1,
                        R.drawable.ima_tutorials2,
                        R.drawable.img_tutorials1
                    )
                )

            }
        }
    }
}

@Composable
private fun TrainersBubble(trainers: List<Trainer>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        trainers.forEach { trainer ->
            Column {
                Image(
                    painter = painterResource(id = trainer.imagen),
                    contentDescription = "trainers",
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                )
                Text(text = trainer.nombre)
            }
        }
    }
}


@Composable
private fun VideoBody(imagenes: List<Int>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        imagenes.forEach { imagen ->
            Card(
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Box(
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = imagen),
                        contentDescription = "Imagen de login",
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp),
                        painter = painterResource(id = R.drawable.ic_li_play_circle),
                        contentDescription = "Imagen de login",
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
        }
    }
}

@Composable
private fun TutorialBody(imagenes: List<Int>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        imagenes.forEach { imagen ->
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(120.dp)
                    .padding(end = 15.dp)
                ,
                shape = RoundedCornerShape(30.dp)
            ) {
                Box(
                    contentAlignment = Alignment.BottomCenter,
                    modifier = Modifier
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                        ,
                        painter = painterResource(id = imagen),
                        contentDescription = "Imagen de login",
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
        }
    }
}


@Composable
fun VideoPlayer(modifier: Modifier) {
    val sampleVideo =
        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
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
    AndroidView(
        factory = {
            playerView
        },
    )
}

@Composable
private fun Trainers(Trainers: List<Trainer>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(start = 10.dp)
    ) {
        Trainers.forEach { trainer ->
            Card(
                modifier = Modifier
                    .width(140.dp)
                    .padding(10.dp)
                    .size(65.dp)
                    .clip(CircleShape),
            ) {
                Box(
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(id = trainer.imagen),
                        contentDescription = "Imagen de los trainers",
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        trainer.nombre,
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
}

@Preview
@Composable
private fun TrainerPantallaPreview() {
    TrainerPantalla()
}