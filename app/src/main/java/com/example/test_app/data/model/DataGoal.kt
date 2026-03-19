package com.example.test_app.data.model

import androidx.compose.runtime.mutableStateListOf

var totalGoals: Int = 0

data class DataGoalInfo(
    var name: String,
    var ic: Int,
    var nowMoney: Int,
    var goalMoney: Int
)

var goalList = mutableStateListOf<DataGoalInfo>()