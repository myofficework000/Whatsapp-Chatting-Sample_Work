package com.example.whatsappfeatureapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappfeatureapp.R
import com.example.whatsappfeatureapp.databinding.ChatRowMineBinding
import com.example.whatsappfeatureapp.databinding.ChatRowOthersBinding
import com.example.whatsappfeatureapp.model.AccountInfo
import com.example.whatsappfeatureapp.model.ChatDetail
import com.google.android.material.snackbar.Snackbar

class ChatDetailAdapter(
    private val itemList: List<ChatDetail>,
    private val checkMineFunc: (Long) -> Boolean,
    private val getAccountInfoFunc: (Long) -> AccountInfo?,
    private val removeMessageFunc: (ChatDetail) -> Unit
): RecyclerView.Adapter<ChatDetailAdapter.ChatBubbleBase>() {
    private lateinit var binding: ChatRowOthersBinding
    private lateinit var bindingMine: ChatRowMineBinding

    private var selectedItem: ChatDetail? = null

    abstract class ChatBubbleBase(view: View): RecyclerView.ViewHolder(view) {
        abstract fun bind(item: ChatDetail)
    }

    inner class ChatBubbleOthers(view: View): ChatBubbleBase(view) {
        override fun bind (item: ChatDetail)  {
            binding.chatBubbleContentOthers.text = item.message
            binding.chatBubbleDateOthers.text = item.time
            getAccountInfoFunc(item.userPhoneNumber)?.apply {
                binding.avatarOthers.setImageResource(avatar)
                binding.chatBubbleNicknameOthers.text = nickname
            }
        }
    }

    inner class ChatBubbleMine(view: View): ChatBubbleBase(view) {
        override fun bind (item: ChatDetail) {
            bindingMine.chatBubbleContentMine.text = item.message
            bindingMine.chatBubbleDateMine.text = item.time
            getAccountInfoFunc(item.userPhoneNumber)?.apply {
                bindingMine.avatarMine.setImageResource(avatar)
                bindingMine.chatBubbleNicknameMine.text = nickname
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
        if (checkMineFunc(itemList[position].userPhoneNumber)) 1 else 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatBubbleBase =
        if (viewType == 0)
            ChatRowOthersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).apply { binding = this }.run{ ChatBubbleOthers(root) }
        else
            ChatRowMineBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).apply { bindingMine = this }.run{ ChatBubbleMine(root) }

    override fun onBindViewHolder(holder: ChatBubbleBase, position: Int) = with(holder) {
        bind(itemList[position])
        this.itemView.setOnLongClickListener{
            selectedItem = itemList[position]
            PopupMenu(it.context, it).apply {
                menuInflater.inflate(
                    if (checkMineFunc(itemList[position].userPhoneNumber))
                        R.menu.chat_bubble_options_mine
                    else
                        R.menu.chat_bubble_options_other
                    , menu)
                setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.chatBubbleOptionsMineDelete -> {
                            removeMessageFunc(itemList[position])
                            Snackbar.make(it, "Message deleted.", Snackbar.LENGTH_SHORT).show()
                        }
                        R.id.chatBubbleOptionsOtherInfo -> {
                            Snackbar.make(it, "W.I.P.", Snackbar.LENGTH_SHORT).show()
                        }
                    }
                    true
                }
            }.show()
            true
        }
    }
    override fun getItemCount(): Int = itemList.size
}