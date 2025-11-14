package com.nesta.makeitstop.features.feature_breathing.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("BreathingTimer")
data class Breathing(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val name:String,
    val inhaleSeconds:Int = 0,
    val holdSeconds:Int = 0,
    val exhaleSeconds:Int = 0,
    val totalCycles:Int = 0,
)
