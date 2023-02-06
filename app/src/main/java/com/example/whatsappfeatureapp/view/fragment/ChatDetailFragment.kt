package com.example.whatsappfeatureapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappfeatureapp.R
import com.example.whatsappfeatureapp.databinding.FragmentChatDetailBinding
import com.example.whatsappfeatureapp.model.AccountInfo
import com.example.whatsappfeatureapp.model.ChatDataSource
import com.example.whatsappfeatureapp.model.ChatDataSource.placeholderMinePhoneNumber
import com.example.whatsappfeatureapp.model.ChatDetail
import com.example.whatsappfeatureapp.view.adapter.ChatDetailAdapter
import com.google.android.material.divider.MaterialDividerItemDecoration
import java.time.LocalDateTime

class ChatDetailFragment : DialogFragment() {
    private lateinit var binding: FragmentChatDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentChatDetailBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chatView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ChatDetailAdapter(
                ChatDataSource.chatDetail1,
                ::checkMinePhoneNumber,
                ::getAccountInfo,
                ::removeMessage
            )
            addItemDecoration(
                MaterialDividerItemDecoration(context, RecyclerView.VERTICAL).apply {
                    dividerThickness = resources.getDimension(R.dimen.chat_row_divider_thickness).toInt()
                }
            )
        }

        binding.sendMessageButton.setOnClickListener {
            binding.newMessageInput.apply {
                if (text?.isNotBlank() == true) {
                    sendMessage(
                        ChatDetail(
                            placeholderMinePhoneNumber,
                            text.toString(),
                            "1/1"
                        )
                    )
                    text?.clear()
                }
            }
        }
    }

    private fun checkMinePhoneNumber(num: Long): Boolean = num == placeholderMinePhoneNumber
    private fun getAccountInfo(num: Long): AccountInfo? = ChatDataSource.placeholderAccounts[num]

    private fun removeMessage(index: Int) {
        ChatDataSource.chatDetail1.removeAt(index)
        binding.chatView.adapter?.notifyItemRemoved(index)
    }

    private fun sendMessage(data: ChatDetail) = binding.chatView.apply {
        ChatDataSource.chatDetail1.add(data)
        adapter?.notifyItemInserted(ChatDataSource.chatDetail1.size-1)
    }

    companion object {
        const val INTENT_ACCOUNTNUMBER = "phone_number"
    }
}