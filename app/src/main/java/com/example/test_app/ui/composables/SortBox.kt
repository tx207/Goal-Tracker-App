package com.example.test_app.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.test_app.R

@Composable
fun SortBox(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ConstraintLayout(modifier = modifier.clickable { onClick() }) {

        val (sortBox,sortBoxList) = createRefs()
        var sortBoxListVisible by remember { mutableStateOf(false) }

        Image(
            painter = painterResource(id = R.drawable.ic_sort),
            contentDescription = "sort",
            modifier = Modifier
                .size(96.dp)
                .background(shape = CircleShape, color = Color.White)
                .border(width = 2.dp, color = Color.Black, shape = CircleShape)
                .constrainAs(sortBox) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .clickable {
                    sortBoxListVisible = !sortBoxListVisible
                }
        )
        if (sortBoxListVisible) {
            SortBoxList(
                modifier = modifier
                    .constrainAs(sortBoxList) {
                        top.linkTo(sortBox.bottom, margin = 8.dp)
                        end.linkTo(sortBox.end)
                    }
                    .background(color = Color.Red, shape = CircleShape)
                    .fillMaxWidth()
            )
        }
    }
}


@Composable
fun SortBoxList(modifier: Modifier = Modifier) {
    BoxItem(
        modifier = modifier
            .width(192.dp)
            .height(75.dp),
        Color.Gray,
        "Sort 1"
    )
}