package com.example.whatsappfeatureapp.model

import androidx.annotation.DrawableRes

data class Call(
    val userName: String,
    val linkStatus: Boolean,
    val lastCallTime: String,
    @DrawableRes val userPic: Int
)