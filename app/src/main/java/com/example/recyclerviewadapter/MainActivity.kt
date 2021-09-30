package com.example.recyclerviewadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ParcelFileDescriptor
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewadapter.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var titlesList= mutableListOf<String>()
    private var descList= mutableListOf<String>()
    private var imagesList= mutableListOf<Int>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postToList()

            binding.rvRecyclerView.layoutManager=LinearLayoutManager(this)
            binding.rvRecyclerView.adapter=RecyclerAdapter(titlesList,descList,imagesList)
    }

    private fun addToList(title:String, description:String,image:Int){
        titlesList.add(title)
        descList.add(description)
        imagesList.add(image)
    }

    private fun postToList(){
        for(i in 1..25){
            addToList("Title $i","Description $i", R.mipmap.ic_launcher_round)
        }
    }
}