package com.example.whatsappfeatureapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whatsappfeatureapp.model.ChatDetail
import com.google.firebase.database.*

class ChatDetailViewModel : ViewModel() {
    private val ref: DatabaseReference = FirebaseDatabase.getInstance().getReference("CHAT")
    private var items: MutableList<ChatDetail> = mutableListOf()
    val allChats = MutableLiveData<List<ChatDetail>>()

    fun addMoreChats(chat: ChatDetail) {
        val chatId = ref.push().key.toString()
        val newChat = ChatDetail(
            id = chatId,
            userPhoneNumber = chat.userPhoneNumber,
            message = chat.message,
            time = chat.time,
            isFavourite = chat.isFavourite
        )

        ref.child(chatId).setValue(newChat).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                fetchNotes()
            }
        }
    }

    val dummyChat = ChatDetail("noID", 9599652867,
        "Hey guys", "13/32")

    fun fetchNotes() {
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    items.clear()
                    for (h in snapshot.children) {
                        val chat = h.getValue(ChatDetail::class.java)
                        items.add(chat ?: dummyChat)
                    }
                    allChats.postValue(items)
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    fun deleteChat(chat: ChatDetail) {
        chat.id?.let {
            ref.child(chat.id).removeValue()
            fetchNotes()
        }
    }
}