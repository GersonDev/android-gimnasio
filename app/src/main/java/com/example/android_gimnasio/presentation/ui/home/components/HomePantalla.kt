package com.example.android_gimnasio.presentation.ui.home.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_gimnasio.R
import com.example.android_gimnasio.domain.models.trainers.TrainerCardModel
import com.example.android_gimnasio.presentation.common.components.UserPicture

@Composable
fun HomePantalla() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(colorResource(id = R.color.trainers__primary))
            .padding(start = 10.dp, bottom = 60.dp, top = 60.dp)
    ) {

        UserSection(description = "Let's start your day")

        Spacer(modifier = Modifier.height(30.dp))

        TodayWorkOutPlan(
            title = "Today Workout Plan",
            subTitle = "6am-8am",
            colorSubtitle = colorResource(R.color.trainers_yellow),
            workoutPlans = listOf(
                TrainerCardModel("Jogging", R.drawable.img_jogging),
                TrainerCardModel("Push-up", R.drawable.img_push_up),
                TrainerCardModel("Jogging", R.drawable.img_jogging),
                TrainerCardModel("Push-up", R.drawable.img_push_up)
            ),
            cardModifier = Modifier
                .width(180.dp)
                .height(220.dp)
                .padding(end = 15.dp)
        )

        TodayWorkOutPlan(
            title = "Categories",
            subTitle = "See all",
            workoutPlans = listOf(
                TrainerCardModel("Gym", R.drawable.img_category_gym),
                TrainerCardModel("Yoga", R.drawable.img_category_yoga),
                TrainerCardModel("Fitness", R.drawable.img_category_fitness),
                TrainerCardModel("Aerobics", R.drawable.img_category_aerobics),
                TrainerCardModel("Aerobics", R.drawable.img_category_aerobics)
            ),
            cardModifier = Modifier
                .width(120.dp)
                .height(160.dp)
                .padding(end = 15.dp)
        )

        TodayWorkOutPlan(
            title = "Trending",
            subTitle = "See all",
            workoutPlans = listOf(
                TrainerCardModel("Gym Centres", R.drawable.img_trending_gym_centres),
                TrainerCardModel("Trainer centres", R.drawable.img_trending_gym_centres)
            ),
            cardModifier = Modifier
                .width(300.dp)
                .height(180.dp)
                .padding(end = 15.dp)
        )

        TodayWorkOutPlan(
            title = "Discover",
            subTitle = "See all",
            workoutPlans = listOf(
                TrainerCardModel("Jogging", R.drawable.img_discover_1),
                TrainerCardModel("Jogging", R.drawable.img_discover_1)
            ),
            cardModifier = Modifier
                .width(300.dp)
                .height(160.dp)
                .padding(end = 15.dp)
        )
    }
}

@Composable
private fun UserSection(description: String) {
    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        Column {
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.White
                        )
                    ) {
                        append("Hello ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = colorResource(R.color.trainers_yellow)
                        )
                    ) {
                        append("Carlos")
                    }
                }
            )

            Text(
                description,
                fontSize = 28.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h1
            )
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )
        UserPicture(R.drawable.img_user_profile)
    }
}



@Composable
private fun TodayWorkOutPlan(
    title: String,
    subTitle: String,
    colorTitle: Color = Color.White,
    colorSubtitle: Color = colorResource(R.color.trainers_gray),
    workoutPlans: List<TrainerCardModel>,
    cardModifier: Modifier,
    cardShape: Shape = RoundedCornerShape(30.dp)
) {

    Column {
        SectionTitle(title, subTitle, colorTitle, colorSubtitle)
        SectionBody(workoutPlans, cardModifier, cardShape)
    }
}

@Composable
fun SectionTitle(
    title: String,
    subTitle: String,
    colorTitle: Color,
    colorSubtitle: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            title,
            color = colorTitle
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        Text(
            subTitle,
            color = colorSubtitle
        )
    }
}

@Composable
private fun SectionBody(workoutPlans: List<TrainerCardModel>, modifier: Modifier, shape: Shape) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        workoutPlans.forEach { workoutPlan ->
            Card(
                modifier = modifier,
                shape = shape
            ) {
                Box(
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = workoutPlan.image),
                        contentDescription = "Imagen de login",
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        workoutPlan.title,
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
private fun HomePantallaPreview() {
    TodayWorkOutPlan(
        title = "Demo",
        subTitle = "See all",
        colorSubtitle = colorResource(R.color.trainers_gray),
        workoutPlans = listOf(TrainerCardModel("demo", R.drawable.img_push_up)),
        cardModifier = Modifier.width(120.dp).padding(15.dp),
        cardShape = RoundedCornerShape(15.dp)
    )
}