package com.example.whatsappfeatureapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappfeatureapp.R
import com.example.whatsappfeatureapp.databinding.ChatItemBinding
import com.example.whatsappfeatureapp.model.Chat

class ChatAdapter(
    private val chats: List<Chat>,
    private val gotoDetailFunc: (Long) -> Unit
) : RecyclerView.Adapter<ChatAdapter.ChatViewsHolder>() {
    private lateinit var binding: ChatItemBinding

    override fun getItemCount() = chats.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewsHolder {
        binding = ChatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewsHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ChatViewsHolder, position: Int) = holder.apply {
        holder.itemView.setOnClickListener {
            gotoDetailFunc(0)
        }
    }.bind(chats[position])

    inner class ChatViewsHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(chat: Chat) {
            chat.apply {
                binding.apply {
                    userName.text = username
                    userMessage.text = message
                    messCount.text = messageCount
                    senderImage.setImageResource(senderIcon)
                    if (isPinned) {
                        pinIcon.setImageResource(R.drawable.baseline_push__pinned_pin_24)
                    } else {
                        pinIcon.setImageResource(R.drawable.baseline_push_pin_24)
                    }
                    if (isMuted) {
                        muteIcon.setImageResource(R.drawable.baseline_volume_off_24)
                    } else {
                        muteIcon.setImageResource(R.drawable.baseline_volume_up_24)
                    }
                }
            }
        }
    }
}