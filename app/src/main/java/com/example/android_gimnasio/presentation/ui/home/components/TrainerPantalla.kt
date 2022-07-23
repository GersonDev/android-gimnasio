package com.example.android_gimnasio.presentation.ui.home.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.android_gimnasio.R
import com.example.android_gimnasio.domain.models.Trainer
import com.example.android_gimnasio.presentation.common.components.GymTitle
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView


@Composable
fun TrainerPantalla() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(colorResource(id = R.color.trainers__primary))
            .padding(start = 10.dp, bottom = 60.dp, top = 60.dp)
    ) {

        GymTitle("Session", R.drawable.img_user_profile)

        Spacer(modifier = Modifier.height(30.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 10.dp)
        ) {
            VideoPlayer(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
            )
            Column {
                SectionTitle(
                    title = "Trainers Men",
                    subTitle = "See all",
                    colorTitle = Color.White,
                    colorSubtitle = colorResource(id = R.color.trainers_gray)
                )
                TrainersBubble(
                    listOf(
                        Trainer(R.drawable.mujer, "Diego"),
                        Trainer(R.drawable.mujer, "Jeff"),
                        Trainer(R.drawable.mujer, "Josue"),
                        Trainer(R.drawable.mujer, "Tiago"),
                        Trainer(R.drawable.mujer, "Juan"),
                        Trainer(R.drawable.mujer, "Juan"),
                        Trainer(R.drawable.mujer, "Juan"),
                        Trainer(R.drawable.mujer, "Juan")
                    )
                )
            }

            Column{
                SectionTitle(
                    title = "Trainers Women",
                    subTitle = "See all",
                    colorTitle = Color.White,
                    colorSubtitle = colorResource(id = R.color.trainers_gray)
                )
                TrainersBubble(
                    listOf(
                        Trainer(R.drawable.hombre, "Amaka"),
                        Trainer(R.drawable.hombre, "Stella"),
                        Trainer(R.drawable.hombre, "Derick"),
                        Trainer(R.drawable.hombre, "Tayao"),
                        Trainer(R.drawable.hombre, "Sean"),
                        Trainer(R.drawable.hombre, "Sean"),
                        Trainer(R.drawable.hombre, "Sean"),
                        Trainer(R.drawable.hombre, "Sean")
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
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .padding(10.dp)

                ) {
                    Image(
                        painter = painterResource(id = trainer.imagen),
                        contentDescription = "trainers",
                        modifier = Modifier
                            .clip(CircleShape)
                            .fillMaxSize()
                        ,
                        contentScale = ContentScale.FillBounds
                    )
                }
                Text(text = trainer.nombre, color = Color.DarkGray)
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
                    .height(120.dp)
                    .padding(end = 15.dp),
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
                    .padding(end = 15.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Box(
                    contentAlignment = Alignment.BottomCenter,
                    modifier = Modifier
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize(),
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


@Preview
@Composable
private fun TrainerPantallaPreview() {
    TrainerPantalla()
}