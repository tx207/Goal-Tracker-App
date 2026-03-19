package com.example.test_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_app.R
import com.example.test_app.data.model.DataState
import com.example.test_app.data.model.goalList
import com.example.test_app.ui.composables.GoalBox
import com.example.test_app.ui.theme.Color_Border
import com.example.test_app.ui.theme.Color_PageBackground
import com.example.test_app.ui.theme.Shadow_Elevation
import com.example.test_app.ui.theme.Shape_BorderRoundedCorner

@Composable
fun Show1(modifier: Modifier = Modifier) {

    //Main list
    Column(
        modifier = Modifier
            .padding(16.dp)
            .shadow(
                elevation = Shadow_Elevation.large,
                shape = Shape_BorderRoundedCorner.large,
            )
            .fillMaxSize()
            .clip(Shape_BorderRoundedCorner.large)
            .background(color = Color_PageBackground)
            .border(1.dp, Color_Border, shape = Shape_BorderRoundedCorner.large)
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        //"Goal" + Opt
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 16.dp, start = 16.dp, end = 16.dp ,bottom = 2.dp)
                .background(color = Color_PageBackground, shape = CircleShape)
                .border(2.dp, color = Color_Border, shape = CircleShape),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Goal",
                color = Color(0xFF213C51),
                modifier = Modifier
                    .padding(start = 16.dp),
                fontSize = 20.sp,
            )

            Image(
                painterResource(id = R.drawable.ic_plus),
                contentDescription = "option",
                modifier = Modifier
                    .fillMaxHeight(0.6f)
                    .padding(end = 16.dp)
                    .clickable(onClick = {
                        DataState.AddGoalSheetState = true
                    })
            )
        }


        //Item
        GoalSheet()
        GoalItemGen()
    }
}


@Composable
fun GoalItemGen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color_PageBackground),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        items(goalList) {info ->
            GoalBox(
                icGoal = info.ic,
                nameGoal = info.name,
                nowMoney = info.nowMoney,
                goalMoney = info.goalMoney
            )
        }
    }
}