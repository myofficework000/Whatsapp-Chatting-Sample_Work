package com.example.whatsappfeatureapp.model

import androidx.annotation.DrawableRes
import com.example.whatsappfeatureapp.R

data class AccountInfo(
    @DrawableRes val avatar: Int = R.drawable.empty,
    val nickname: String
)
