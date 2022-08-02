package com.example.android_gimnasio.presentation.ui.home.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
            .background(colorResource(id = R.color.trainers_primary))
    ) {

        GymTitle(stringResource(id = R.string.trainers), R.drawable.img_user_profile)
        VideoPlayer()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(start = 10.dp)
        ) {
            Column {
                SectionTitle(
                    stringResource(id = R.string.trainers_men),
                    subTitle = stringResource(id = R.string.see_all),
                    colorTitle = Color.White,
                    colorSubtitle = colorResource(id = R.color.trainers_gray)
                )
                TrainersBubble(
                    listOf(
                        Trainer(R.drawable.trainer_1, "Diego"),
                        Trainer(R.drawable.trainer_2, "Jeff"),
                        Trainer(R.drawable.trainer_3, "Josue"),
                        Trainer(R.drawable.trainer_1, "Tiago"),
                        Trainer(R.drawable.trainer_2, "Juan"),
                        Trainer(R.drawable.trainer_3, "Juan"),
                        Trainer(R.drawable.trainer_1, "Juan"),
                        Trainer(R.drawable.trainer_1, "Juan")
                    )
                )
            }
            Column {
                SectionTitle(
                    title = stringResource(id = R.string.trainers_women),
                    subTitle = stringResource(id = R.string.see_all),
                    colorTitle = Color.White,
                    colorSubtitle = colorResource(id = R.color.trainers_gray)
                )
                TrainersBubble(
                    listOf(
                        Trainer(R.drawable.trainer_girl_1, "Amaka"),
                        Trainer(R.drawable.trainer_girl_2, "Stella"),
                        Trainer(R.drawable.trainer_girl_1, "Derick"),
                        Trainer(R.drawable.trainer_girl_2, "Tayao"),
                        Trainer(R.drawable.trainer_girl_1, "Sean"),
                        Trainer(R.drawable.trainer_girl_2, "Sean"),
                        Trainer(R.drawable.trainer_girl_1, "Sean"),
                        Trainer(R.drawable.trainer_girl_1, "Sean")
                    )
                )
            }
            Column {
                SectionTitle(
                    title = stringResource(id = R.string.videos),
                    subTitle =stringResource(id = R.string.see_all),
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
                    title = stringResource(id = R.string.tutorials),
                    subTitle = stringResource(id = R.string.see_all),
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
fun VideoPlayer() {
    val context = LocalContext.current

    val playWhenReady by rememberSaveable {
        mutableStateOf(true)
    }

    val sampleVideo =
        "https://www.muscleandstrength.com/video/highinvertedrow.mp4"
    val mediaItem = MediaItem.fromUri(sampleVideo)

    val exoPlayer = SimpleExoPlayer.Builder(context).build()
    val playerView = PlayerView(context)


    exoPlayer.setMediaItem(mediaItem)
    playerView.player = exoPlayer
    LaunchedEffect(exoPlayer) {
        exoPlayer.prepare()
        exoPlayer.playWhenReady = playWhenReady

    }
    AndroidView(
        factory = {
            playerView
        },
    )
}

@Composable
private fun TrainersBubble(trainers: List<Trainer>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        trainers.forEach { trainer ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                            .fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )
                }
                Text(text = trainer.nombre, color = Color.DarkGray, fontSize = 13.sp)
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
                    .width(150.dp)
                    .height(150.dp)
                    .padding(end = 15.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Box(
                    contentAlignment = Alignment.BottomStart
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = imagen),
                        contentDescription = "Imagen de login",
                        contentScale = ContentScale.FillBounds
                    )
                    Image(
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)
                            .padding(start = 10.dp, bottom = 10.dp),
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