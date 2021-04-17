package com.example.pacitantourism

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView

class ProfileActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var profileBack: ImageButton
    private lateinit var profileImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profileBack = findViewById(R.id.profile_button_back)
        profileImg = findViewById(R.id.profile_img)

        profileBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.profile_button_back -> finish()
        }
    }
}