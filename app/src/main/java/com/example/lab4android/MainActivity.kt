package com.example.lab4android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = LinearLayoutManager(this , RecyclerView.VERTICAL , false )
        val dividerItemDecoration = DividerItemDecoration(this , RecyclerView.VERTICAL)


        binding.recyclerView.apply {
            adapter = Adapter(resources.openRawResource(R.raw.articles))
            layoutManager = manager
            addItemDecoration(dividerItemDecoration)
        }

    }
}