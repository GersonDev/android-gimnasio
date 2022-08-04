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
import androidx.compose.ui.res.stringResource
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
            .background(colorResource(id = R.color.trainers_primary))
            .padding(start = 10.dp, top = 15.dp, bottom = 10.dp)
    ) {

        UserSection(description = stringResource(id = R.string.lets_start_your_day), modifier = Modifier.padding(end = 10.dp))

        Spacer(modifier = Modifier.height(30.dp))

        TodayWorkOutPlan(
            title = stringResource(id = R.string.today_workout_plan),
            subTitle = "6am-8am",
            colorSubtitle = colorResource(R.color.trainers_yellow),
            workoutPlans = listOf(
                TrainerCardModel(stringResource(id = R.string.jogging), R.drawable.img_jogging),
                TrainerCardModel(stringResource(id = R.string.push_up), R.drawable.img_push_up),
                TrainerCardModel(stringResource(id = R.string.jogging), R.drawable.img_jogging),
                TrainerCardModel(stringResource(id = R.string.push_up), R.drawable.img_push_up)
            ),
            cardModifier = Modifier
                .width(180.dp)
                .height(220.dp)
                .padding(end = 15.dp)
        )

        TodayWorkOutPlan(
            title = stringResource(id = R.string.categories),
            subTitle = stringResource(id = R.string.see_all),
            workoutPlans = listOf(
                TrainerCardModel(stringResource(id = R.string.gym), R.drawable.img_category_gym),
                TrainerCardModel(stringResource(id = R.string.yoga), R.drawable.img_category_yoga),
                TrainerCardModel(stringResource(id = R.string.fitness), R.drawable.img_category_fitness),
                TrainerCardModel(stringResource(id = R.string.aerobics), R.drawable.img_category_aerobics),
                TrainerCardModel(stringResource(id = R.string.aerobics), R.drawable.img_category_aerobics)
            ),
            cardModifier = Modifier
                .width(120.dp)
                .height(160.dp)
                .padding(end = 15.dp)
        )

        TodayWorkOutPlan(
            title = stringResource(id = R.string.trending),
            subTitle = stringResource(id = R.string.see_all),
            workoutPlans = listOf(
                TrainerCardModel(stringResource(id = R.string.gym_centres), R.drawable.img_trending_gym_centres),
                TrainerCardModel(stringResource(id = R.string.trainer_centres), R.drawable.img_trending_gym_centres)
            ),
            cardModifier = Modifier
                .width(300.dp)
                .height(180.dp)
                .padding(end = 15.dp)
        )

        TodayWorkOutPlan(
            title = stringResource(id = R.string.discover),
            subTitle = stringResource(id = R.string.see_all),
            workoutPlans = listOf(
                TrainerCardModel(stringResource(id = R.string.jogging), R.drawable.img_discover_1),
                TrainerCardModel(stringResource(id = R.string.jogging), R.drawable.img_discover_1)
            ),
            cardModifier = Modifier
                .width(300.dp)
                .height(160.dp)
                .padding(end = 15.dp)
        )
    }
}

@Composable
private fun UserSection(description: String, modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Column {
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.White
                        )
                    ) {
                        append(stringResource(id = R.string.hello))
                    }
                    withStyle(
                        style = SpanStyle(
                            color = colorResource(R.color.trainers_yellow)
                        )
                    ) {
                        append(" Carlos")
                    }
                }
            )

            Text(
                description,
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h2
            )
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )
        UserPicture(R.drawable.ic_user_profile_picture)
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
            color = colorTitle,
            fontSize = 14.sp
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        Text(
            subTitle,
            color = colorSubtitle,
            fontSize = 14.sp
        )
    }
}

@Composable
private fun SectionBody(workoutPlans: List<TrainerCardModel>, modifier: Modifier, shape: Shape) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp, top = 15.dp)
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
        cardModifier = Modifier
            .width(120.dp)
            .padding(15.dp),
        cardShape = RoundedCornerShape(15.dp)
    )
}