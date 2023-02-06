package com.example.whatsappfeatureapp.model

data class ChatDetail(
    val userPhoneNumber: Long,
    val message: String,
    val time: String,
    val isFavourite: Boolean = false
)