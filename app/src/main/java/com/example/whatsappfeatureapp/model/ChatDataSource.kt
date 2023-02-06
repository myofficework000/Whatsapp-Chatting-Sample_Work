package com.example.whatsappfeatureapp.model

import com.example.whatsappfeatureapp.R

object ChatDataSource {
     fun getChatList(): List<Chat> {

        val chatArrayList = ArrayList<Chat>()
        chatArrayList.apply {
            add(
                Chat(
                    "Alex",
                    "Hey, how are you?",
                    "10:10 AM",
                    "2",
                    true,
                    R.drawable.img
                )
            )
            add(
                Chat(
                    "Alex",
                    "Hey, how are you?",
                    "10:10 AM",
                    "2",
                    true,
                    R.drawable.img
                )
            )
            add(
                Chat(
                    "Alex",
                    "Hey, how are you?",
                    "10:10 AM",
                    "2",
                    true,
                    R.drawable.img
                )
            )
            add(
                Chat(
                    "Alex",
                    "Hey, how are you?",
                    "10:10 AM",
                    "2",
                    true,
                    R.drawable.img
                )
            )
        }
        return chatArrayList
    }
}