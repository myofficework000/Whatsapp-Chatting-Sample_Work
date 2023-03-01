package com.example.whatsappfeatureapp.model

import com.example.whatsappfeatureapp.R

object ChatDataSource {
    var placeholderMinePhoneNumber = 123456789L
  /*  val chatDetail1 = mutableListOf(
        ChatDetail("1234567892,"Hey guys","13/32"),
        ChatDetail(2345678901, "What?", "42/69"),
        ChatDetail(1234567890,"Leave me alone! I have a leg cramp!","69/42"),
        ChatDetail(2345678901, "There is a lot of pressure put on me, but I don't put a lot of pressure on myself.  I feel if I play my game, it will take care of itself.", "69/42"),
        ChatDetail(1234567890,"\uD83D\uDD2B","69/42")
    )*/

    val placeholderAccounts = hashMapOf(
        1234567890L to AccountInfo(
            R.drawable.img,
            "Not Lebron"
        ),
        1234567892L to AccountInfo(
            R.drawable.img,
            "Lebron"
        ),
        2345678901L to AccountInfo(
            R.drawable.img,
            "Also Lebron"
        )
    )

    fun getChatList(): List<Chat> = ArrayList<Chat>().apply {
        add(
            Chat(
                "Alex",
                "Hey, how are you?",
                "10:10 AM",
                "2",
                isPinned = true,
                isMuted = false,
                R.drawable.img
            )
        )
        add(
            Chat(
                "Alex",
                "Hey, how are you?",
                "10:10 AM",
                "2",
                isPinned = false,
                isMuted = true,
                R.drawable.img
            )
        )
        add(
            Chat(
                "Alex",
                "Hey, how are you?",
                "10:10 AM",
                "2",
                isPinned = true,
                isMuted = true,
                R.drawable.img
            )
        )
        add(
            Chat(
                "Alex",
                "Hey, how are you?",
                "10:10 AM",
                "2",
                isPinned = false,
                isMuted = false,
                R.drawable.img
            )
        )
    }
}