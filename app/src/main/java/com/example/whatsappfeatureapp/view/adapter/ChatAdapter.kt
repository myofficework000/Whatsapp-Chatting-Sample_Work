package com.example.whatsappfeatureapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappfeatureapp.databinding.ChatItemBinding
import com.example.whatsappfeatureapp.model.Chat

class ChatAdapter(private val chats: List<Chat>):  RecyclerView.Adapter<ChatAdapter.ChatViewsHolder>() {
    private lateinit var binding: ChatItemBinding

    override fun getItemCount() = chats.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewsHolder {
        val layoutinflater = LayoutInflater.from(parent.context)
        binding = ChatItemBinding.inflate(layoutinflater,parent, false)
        return ChatViewsHolder(binding.root)
    }
    override fun onBindViewHolder(holder: ChatViewsHolder, position: Int) {
        holder.bind(chats[position])
    }
    inner class ChatViewsHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(chat: Chat){
            chat.apply{
                binding.apply{
                    userName.text = username
                    userMessage.text = message
                }
            }
        }
    }
}