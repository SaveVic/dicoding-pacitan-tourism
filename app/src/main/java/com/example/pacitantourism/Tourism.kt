package com.example.pacitantourism

import java.io.Serializable

data class Tourism(
    val title: String,
    val image: String,
    val description: String,
    val location: String,
    val distance: Double,
    val time: Double,
    val price: String
) : Serializable