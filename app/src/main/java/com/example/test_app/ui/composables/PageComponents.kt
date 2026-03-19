package com.example.test_app.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.test_app.R
import com.example.test_app.ui.theme.Color_Border
import com.example.test_app.ui.theme.Color_PageBackground

@Composable
fun BoxItem(
    modifier: Modifier,
    boxColor: Color = Color.White,
    boxText: String? = null,
    iconURL: Int? = null,
    textColor: Color = Color.Black,
    contentAlignment: Alignment = Alignment.Center
) {
    Box(modifier = modifier
        .fillMaxSize()
        .background(boxColor),
        contentAlignment = contentAlignment,
    ) {
        if (boxText != null) {
            Text(
                modifier = Modifier,
                text = boxText,
                fontSize = 20.sp,
                color = textColor
            )
        }
        if (iconURL != null) {
            Image(
                painterResource(id = iconURL),
                contentDescription = "setting",
                modifier = Modifier
            )
        }
    }
}


@Composable
fun GoalBox(
    icGoal: Int,
    nameGoal: String,
    nowMoney: Int,
    goalMoney: Int
) {
    ConstraintLayout(
        modifier = Modifier
            .padding(bottom = 16.dp, top = 6.dp)
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(32.dp))
            .clip(RoundedCornerShape(32.dp))
            .background(color = Color_PageBackground)
            .border(1.dp , Color_Border, shape = RoundedCornerShape(32.dp))
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
        val marginFixed = 16.dp

        val (iconGoalItem,nameGoalItem,nowMoneyItem,goalMoneyItem,moreOption,progressBar) = createRefs()


        Image(
            painter = painterResource(id = icGoal),
            contentDescription = "goal",
            modifier = Modifier
                .constrainAs(iconGoalItem) {
                    start.linkTo(parent.start, margin = marginFixed)
                    top.linkTo(parent.top, margin = marginFixed)
                }
                .size(70.dp),
        )

        Text(
            text = nameGoal,
            modifier = Modifier
                .constrainAs(nameGoalItem) {
                    start.linkTo(iconGoalItem.end, margin = marginFixed)
                    top.linkTo(iconGoalItem.top, margin = marginFixed/4)
                },
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        var fontSizeMoney = 20.sp
        Text(
            text = "$nowMoney",
            modifier = Modifier
                .constrainAs(nowMoneyItem) {
                    start.linkTo(iconGoalItem.end, margin = marginFixed)
                    top.linkTo(nameGoalItem.bottom, margin = marginFixed/2)
                },
            fontSize = fontSizeMoney,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Text(
            text = "/$goalMoney",
            modifier = Modifier
                .constrainAs(goalMoneyItem) {
                    start.linkTo(nowMoneyItem.end)
                    top.linkTo(nowMoneyItem.top)
                },
            fontSize = fontSizeMoney,
            fontWeight = FontWeight.Bold
        )

        Image(
            painter = painterResource(id = R.drawable.ic_option),
            contentDescription = "More",
            modifier = Modifier
                .constrainAs(moreOption) {
                    end.linkTo(parent.end, margin = marginFixed)
                    top.linkTo(parent.top,margin = marginFixed*2)
                }
                .height(25.dp)
        )

        Row (
            modifier = Modifier
                .constrainAs(progressBar) {
                    top.linkTo(iconGoalItem.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .padding(marginFixed),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            var blank: Color = Color(0xFF8A244B)
            var full: Color = Color(0xFFC95465)

            val fullBar = ( nowMoney.toFloat() / goalMoney.toFloat() ) * 20

            var nowColor: Color
            for (i in 1..30) {
                if (i < fullBar) {
                    nowColor = full
                } else {
                    nowColor = blank
                }
                Box(
                    modifier = Modifier
                        .background(color = nowColor, shape = CircleShape)
                        .width(5.dp)
                        .height(30.dp)
                )
            }
        }
    }
}


