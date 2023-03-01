package com.example.whatsappfeatureapp.model

data class ChatDetail(
    val id: String? = "",
    val userPhoneNumber: Long = 0L,
    val message: String = "",
    val time: String = "",
    val isFavourite: Boolean = false
)