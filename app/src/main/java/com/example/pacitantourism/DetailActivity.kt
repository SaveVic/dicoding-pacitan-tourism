package com.example.pacitantourism

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var detailBack: ImageButton
    private lateinit var detailTitle: TextView
    private lateinit var detailImg: ImageView
    private lateinit var detailLoc: TextView
    private lateinit var detailDist: TextView
    private lateinit var detailTime: TextView
    private lateinit var detailPrice: TextView
    private lateinit var detailDesc: TextView

    private lateinit var dataTourism: Tourism

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        dataTourism = intent.getSerializableExtra("tourism_data") as Tourism

        detailBack = findViewById(R.id.detail_button_back)
        detailTitle = findViewById(R.id.detail_title)
        detailImg = findViewById(R.id.detail_image)
        detailLoc = findViewById(R.id.detail_loc)
        detailDist = findViewById(R.id.detail_dist)
        detailTime = findViewById(R.id.detail_time)
        detailPrice = findViewById(R.id.detail_price)
        detailDesc = findViewById(R.id.detail_desc)

        initiateData()
    }

    private fun initiateData(){
        detailBack.setOnClickListener(this)
        detailTitle.text = dataTourism.title
        Glide.with(this).load(dataTourism.image).into(detailImg)
        detailLoc.text = dataTourism.location
        val dist = "${dataTourism.distance} km"
        detailDist.text = dist
        val time = if(dataTourism.time > 60) "${(dataTourism.time / 60).toInt()} jam ${dataTourism.time % 60} menit" else "${dataTourism.time} menit"
        detailTime.text = time
        detailPrice.text = dataTourism.price
        detailDesc.text = dataTourism.description
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.detail_button_back -> finish()
        }
    }
}