package com.example.recyclerviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_chat.view.*

class ChatAdapter: RecyclerView.Adapter<ChatAdapter.ItemViewHolder>() {
    private val chats = ArrayList<Chat>(

    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat,parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatAdapter.ItemViewHolder, position: Int) {
        holder.bind(chats[position])
    }

    override fun getItemCount(): Int {
        return chats.size
    }

    fun addChat(chat: Chat){
        this.chats.add(chat)
        notifyDataSetChanged()
    }

    fun addChats(chats: ArrayList<Chat>){
        chats.addAll(chats)
        notifyDataSetChanged()

    }
    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(chat:Chat){
            itemView.item_tv_chat_name.text = chat.name
            itemView.item_tv_chat_message.text = chat.message

            itemView.apply{
                item_tv_chat_name.text = chat.name
                item_tv_chat_message.text = chat.message
            }
        }
    }
}