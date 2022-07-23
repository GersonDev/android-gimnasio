package com.example.android_gimnasio.domain.models.trainers

import androidx.annotation.DrawableRes

data class TrainerCardModel(
    val title: String,
    @DrawableRes val image: Int
)