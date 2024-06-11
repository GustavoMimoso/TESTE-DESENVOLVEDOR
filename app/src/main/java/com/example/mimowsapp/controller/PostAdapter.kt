package com.example.mimowsapp.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mimowsapp.R
import com.example.mimowsapp.model.Post

class PostAdapter(private val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
        val bodyTextView: TextView = itemView.findViewById(R.id.body_text_view)
        val bodyTextView2: TextView = itemView.findViewById(R.id.body_text_view2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.titleTextView.text = post.name
        holder.bodyTextView.text = post.email
        holder.bodyTextView2.text = post.website
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}
