package com.cherepanov.invitation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class FreindsAdapter(private val context: Context, private val friends: List<Friend>):
    RecyclerView.Adapter<FreindsAdapter.FreindsViewHolder>(){

    class FreindsViewHolder(view: View): RecyclerView.ViewHolder(view){
        val img: ImageView = itemView.findViewById(R.id.friends_img)
        val fname: TextView = itemView.findViewById(R.id.friends_name)
        fun bindView(friends: Friend){
            Picasso.get().load(friends.image).into(img)
            fname.text = friends.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FreindsViewHolder =
        FreindsViewHolder(LayoutInflater.from(context).inflate(R.layout.friend_layout, parent, false))

    override fun getItemCount(): Int = friends.size

    override fun onBindViewHolder(holder: FreindsViewHolder, position: Int) {
        holder.bindView(friends[position])
    }

}