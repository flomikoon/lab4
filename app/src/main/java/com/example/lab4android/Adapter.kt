package com.example.lab4android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4android.databinding.TextBinding
import name.ank.lab4.BibDatabase
import name.ank.lab4.Keys
import java.io.InputStream
import java.io.InputStreamReader

class Adapter(base: InputStream) : RecyclerView.Adapter<Adapter.ViewHolder>(){
    private val reader = InputStreamReader(base)
    private val database = BibDatabase(reader)


    class ViewHolder(binding: TextBinding) : RecyclerView.ViewHolder(binding.root){
        val author = binding.author
        val title = binding.title
        val journal = binding.journal
        val page = binding.page
    }

    override fun getItemCount(): Int = Int.MAX_VALUE
    //= database.size()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TextBinding.inflate(inflater , parent , false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = database.getEntry(position%database.size())

        holder.author.text = "Author: " + entry.getField(Keys.AUTHOR) + "\n"
        holder.title.text = "Title: " + entry.getField(Keys.TITLE) + "\n"
        holder.journal.text = "Journal: " + entry.getField(Keys.JOURNAL) + "\n"
        holder.page.text = "Pages: " + (entry.getField(Keys.PAGES) ?: "unknow")
    }
}