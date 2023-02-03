package com.example.whatsappfeatureapp.model

import androidx.annotation.DrawableRes

data class Chat(
    val username:String,
    val message:String,
    val time:String,
    val messageCount:String,
    val isPinned:Boolean,
    @DrawableRes val senderIcon:Int)
