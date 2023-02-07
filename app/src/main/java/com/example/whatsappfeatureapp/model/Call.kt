package com.example.whatsappfeatureapp.model

import androidx.annotation.DrawableRes
import java.util.Date

data class Call(
    val userName: String,
    val linkStatus: Boolean,
    val lastCallTime: Date,
    val unreadCount: Int,
    val callType: Boolean,
    @DrawableRes val userPic: Int
)