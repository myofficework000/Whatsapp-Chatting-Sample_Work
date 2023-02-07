package com.example.whatsappfeatureapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappfeatureapp.R
import com.example.whatsappfeatureapp.databinding.CallItemBinding
import com.example.whatsappfeatureapp.model.Call

object UnreadString {
    fun getUnreadString(count: Int, toAfter:Boolean = false, toBefore:Boolean = false): String {
        var addBefore = ""
        if(toBefore) addBefore = " "
        var addAfter = ""
        if(toAfter) addAfter = " "
        return if(count <= 1) ""
        else "$addBefore($count)$addAfter"
    }
}
object TimeAgo {
    private val SECOND_MILLIS = 1000;
    private val MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private val HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private val DAY_MILLIS = 24 * HOUR_MILLIS;

    fun getTimeAgo(millis: Long): String {
        var time: Long = millis;
        if (time < 1000000000000L) {
            time *= 1000;
        }

        val now: Long = System.currentTimeMillis();
        if (time > now || time <= 0) {
            return "";
        }

        val diff = now - time;
        if (diff < MINUTE_MILLIS) {
            return "just now";
        } else if (diff < 2 * MINUTE_MILLIS) {
            return "a minute ago";
        } else if (diff < 50 * MINUTE_MILLIS) {
            return "${diff / MINUTE_MILLIS} minutes ago";
        } else if (diff < 90 * MINUTE_MILLIS) {
            return "an hour ago";
        } else if (diff < 24 * HOUR_MILLIS) {
            return "${diff / HOUR_MILLIS} hours ago";
        } else if (diff < 48 * HOUR_MILLIS) {
            return "yesterday";
        } else {
            return "${diff / DAY_MILLIS} days ago";
        }
    }
}

class CallAdapter(private val context: Context, private val callItems: List<Call>): RecyclerView.Adapter<CallAdapter.CallViewHolder>() {

    private lateinit var binding: CallItemBinding

    override fun getItemCount() = callItems.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = CallItemBinding.inflate(layoutInflater, parent, false)
        return CallViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        val callItem = callItems[position]
        holder.bind(callItem)
    }

    inner class CallViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(callItem: Call) {

            binding.txtUserName.text = callItem.userName

            if(callItem.linkStatus) {
                binding.imgUserLink.setImageResource(R.drawable.baseline_link_24)
            }
            else {
                binding.imgUserLink.setImageResource(R.drawable.baseline_link_24_red)
            }
            if(callItem.callType) {
                binding.btnCall.setImageResource(R.drawable.baseline_call_24)
            }
            else {
                binding.btnCall.setImageResource(R.drawable.baseline_videocam_24)
            }

            binding.txtLastCall.text = UnreadString.getUnreadString(callItem.unreadCount, true) + TimeAgo.getTimeAgo(callItem.lastCallTime.time)

            binding.imgUserPic.setImageResource(callItem.userPic)
        }
    }
}