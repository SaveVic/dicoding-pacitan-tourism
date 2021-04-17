package com.example.pacitantourism

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvMain: RecyclerView
    private lateinit var profileMain: ImageButton
    private var list: ArrayList<Tourism> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar?.hide()
        rvMain = findViewById(R.id.main_rv)
        rvMain.setHasFixedSize(true)

        profileMain = findViewById(R.id.main_profile)
        profileMain.setOnClickListener(this)

        list.addAll(TourismData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvMain.layoutManager = LinearLayoutManager(this)
        val listTourismAdapter = ListTourismAdapter(list)
        rvMain.adapter = listTourismAdapter

        listTourismAdapter.setClickCallback(
            object : OnClickItemCallback {
                override fun onClickItem(tourism: Tourism) {
                    onItemClick(tourism)
                }
            }
        )
    }

    private fun onItemClick(tourism: Tourism) {
        val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
        detailIntent.putExtra("tourism_data", tourism as Serializable)
        startActivity(detailIntent)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.main_profile -> navigateProfile()
        }
    }

    private fun navigateProfile(){
        val profileIntent = Intent(this@MainActivity, ProfileActivity::class.java)
        startActivity(profileIntent)
    }
}