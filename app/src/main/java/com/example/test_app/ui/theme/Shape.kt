package com.example.test_app.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

var Shape_BorderRoundedCorner = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large =  RoundedCornerShape(32.dp)
)

object Shadow_Elevation {
    var small = 2.dp
    var medium = 6.dp
    var large = 10.dp
}