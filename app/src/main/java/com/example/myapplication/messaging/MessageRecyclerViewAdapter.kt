package com.example.myapplication.messaging


import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R



class MessageRecyclerViewAdapter(private val c: Context, private val messages: List<Message>, private val session: String, private val user: String) :  RecyclerView.Adapter<MessageRecyclerViewAdapter.MyViewHolder>() {
    //declare class variables
    private val TAG = "MessageRecycler"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(c).inflate(R.layout.single_message, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //sets messages from list into text views with blue rectangle background and left gravity
        if(session == messages[position].session) {
            holder.message.gravity = Gravity.START
            holder.message.visibility = View.VISIBLE

            val getUser = messages[position].user
            holder.title.text = getUser

            Log.i(TAG, getUser)
            val getMessage = messages[position].message
            holder.body.text = getMessage
            holder.body.background = ContextCompat.getDrawable(holder.itemView.context as FragmentActivity, R.drawable.rounded_blue_rectangle)
            Log.i(TAG, getMessage)
        }
        //sets background to green rectangle and right gravity if the message is sent by yourself
        if(user == messages[position].user){
            holder.message.gravity = Gravity.END
            holder.body.background = ContextCompat.getDrawable(holder.itemView.context as FragmentActivity, R.drawable.rounded_green_rectangle)
        }
    }

    override fun getItemCount(): Int {
        //returns list size
        return messages.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //set views for view holder
        val message = view.findViewById(R.id.message) as LinearLayout
        val title = view.findViewById(R.id.title) as TextView
        val body = view.findViewById(R.id.body) as TextView

    }

}