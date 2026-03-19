package com.example.test_app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.test_app.R
import com.example.test_app.ui.composables.BoxItem
import com.example.test_app.ui.composables.PageBody1
import com.example.test_app.ui.composables.PageBody2
import com.example.test_app.ui.composables.PageBody3
import com.example.test_app.ui.composables.PageOpt
import com.example.test_app.ui.composables.SortBox
import com.example.test_app.ui.theme.Color_Border
import com.example.test_app.ui.theme.Color_PageBackground
import com.example.test_app.ui.theme.Shadow_Elevation
import com.example.test_app.ui.theme.Shape_BorderRoundedCorner

@Composable
fun HomeScreen() {

    var PageNow by remember { mutableStateOf(PageOpt.Page1) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        //Header
        Row(
            modifier = Modifier.weight(5f).zIndex(1f)
        ) {
            BoxItem(modifier = Modifier.weight(1.2f), Color.Gray, iconURL = R.drawable.ic_setting)
            BoxItem(modifier = Modifier.weight(3f), PageNow.color, PageNow.title)
            SortBox(
                modifier = Modifier
                    .width(96.dp)
                    .fillMaxHeight(),
                {}
            )
        }



        //Body
        Box(
            modifier = Modifier.weight(85f)
        ) {
            when (PageNow.id) {
                1 -> PageBody1()
                2 -> PageBody2()
                3 -> PageBody3()
                else -> PageBody2()
            }
        }


        //Nav Bar
        Row(
            modifier = Modifier
                .weight(10f)
                .padding(start = 16.dp, end = 16.dp , bottom = 32.dp)
                .shadow(elevation = Shadow_Elevation.large, shape = Shape_BorderRoundedCorner.medium)
                .background(color = Color_PageBackground, shape = Shape_BorderRoundedCorner.medium)
                .border(2.dp ,color = Color_Border, shape = Shape_BorderRoundedCorner.medium)
        ) {
            PageOpt.entries.forEach { option ->
                BoxItem(
                    modifier = Modifier
                        .weight(option.weight)
                        .clickable {
                            PageNow = option;
                        },
                    option.color,
                    option.title,
                )
            }
        }
    }
}


