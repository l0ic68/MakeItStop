package com.nesta.makeitstop.addiction.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "addiction")
data class Addiction(
    @PrimaryKey(autoGenerate = true)
    val iD: Int = 0,
    val name: String
)
