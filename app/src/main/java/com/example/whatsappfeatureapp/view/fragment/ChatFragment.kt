package com.example.whatsappfeatureapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappfeatureapp.R
import com.example.whatsappfeatureapp.databinding.FragmentChatBinding
import com.example.whatsappfeatureapp.model.Chat
import com.example.whatsappfeatureapp.model.ChatDataSource
import com.example.whatsappfeatureapp.view.adapter.ChatAdapter

class ChatFragment : Fragment() {
    
    // Placeholder changes. Feel free to revert or reformat on merge
    private lateinit var binding: FragmentChatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentChatBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ChatAdapter(
                ChatDataSource.getChatList(),
                ::gotoDetail
            )
        }

        binding.placeholderButtonGotoChatDetail.setOnClickListener {
            gotoDetail(0)
        }
    }

    fun gotoDetail(chatId: Long) {
        ChatDetailFragment().apply {
            setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog)
        }.show((context as AppCompatActivity).supportFragmentManager, "")
    }
}